package vn.callbilling.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CallBillingResponse{
    @JsonProperty("call_count")
    Integer callCount;
    @JsonProperty("block_count")
    Integer blockCount;
}
