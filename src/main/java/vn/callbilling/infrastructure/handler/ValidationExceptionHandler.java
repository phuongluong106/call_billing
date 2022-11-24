package vn.callbilling.infrastructure.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.callbilling.application.enums.OnlineResponseCode;
import vn.callbilling.application.response.OnlineResponse;
import vn.callbilling.shared.utils.LogHelper;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationExceptions(
            ConstraintViolationException ex) {
        Map<String, String> validationList = new HashMap<>();
        ex.getConstraintViolations().stream().forEach(x->{
            var invalidValue = x.getInvalidValue();
            validationList.put(x.getInvalidValue().toString(), x.getMessage());
        });
        OnlineResponse response = OnlineResponse.builder()
                .responseCode(OnlineResponseCode.UnprocessableEntity.getCode())
                .responseMessage("Invalid Request Body!")
                .errors(validationList)
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        
        logException(ex);
        OnlineResponse response = OnlineResponse.builder()
                .responseCode(OnlineResponseCode.SystemError.getCode())
                .responseMessage("SYSTEM_ERROR")
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private void logException(Exception ex) {
        
        LogHelper.logException(getClass(), ex, null);
        LogHelper.error(getClass(), "[EXCEPTION] type={}, message={}", ex.getClass().getName(), ex.getMessage(), ex);
    }
}
