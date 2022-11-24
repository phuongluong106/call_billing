package vn.callbilling.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class InsertCallRequest extends ApiRequest{
    @JsonProperty("call_duration")
    @Valid
    Integer callDuration;
}
