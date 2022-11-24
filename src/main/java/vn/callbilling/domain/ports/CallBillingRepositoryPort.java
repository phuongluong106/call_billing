package vn.callbilling.domain.ports;

import vn.callbilling.domain.model.Call;
import vn.callbilling.domain.model.CallBill;

public interface CallBillingRepositoryPort {
    CallBill findCallBilling(String userName);
    void saveCallBilling(Call call);
}