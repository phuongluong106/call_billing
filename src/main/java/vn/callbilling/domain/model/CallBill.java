package vn.callbilling.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CallBill {
    private String userName;
    private Integer blockCount;
    private Integer callCount;
}
