package vn.callbilling.application.controller;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.callbilling.application.request.InsertCallRequest;
import vn.callbilling.application.response.CallBillingResponse;
import vn.callbilling.application.response.OnlineResponse;
import vn.callbilling.domain.model.CallBill;
import vn.callbilling.domain.service.CallAndBillingService;


@RestController
@RequestMapping("/mobile/{user_name}")
@Validated
public class CallBillingController {
    @Autowired
    CallAndBillingService callAndBillingService;

    @PutMapping(value = "/call")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "System Error")
    })
    public ResponseEntity<OnlineResponse<String>> insertCall(@PathVariable("user_name")
                                                             @Length(min = 1, max = 12, message = "user_name length must be between 1 and 12")
                                                             String userName
            , @RequestBody InsertCallRequest insertCallRequest) throws Exception {
        callAndBillingService.insertCall(userName, insertCallRequest.getCallDuration());
        return ResponseEntity.ok(new OnlineResponse<>("", HttpStatus.OK.value(), "OK", null));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/billing")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 500, message = "System Error")
    })
    public ResponseEntity<OnlineResponse<CallBillingResponse>> getCallBill(
            @PathVariable("user_name")
            @Length(min = 1, max = 12, message = "user_name length must be between 1 and 12") String userName) {
        CallBill callBill = callAndBillingService.getBill(userName);
        if (ObjectUtils.allNotNull(callBill)) {
            return ResponseEntity.ok(new OnlineResponse<>(CallBillingResponse.builder()
                    .callCount(callBill.getCallCount())
                    .blockCount(callBill.getBlockCount()).build(), HttpStatus.OK.value(), null, null));
        } else {
            return ResponseEntity.ok(new OnlineResponse<>(CallBillingResponse.builder().build(), HttpStatus.OK.value(), null, null));
        }
    }
}
