package vn.callbilling.domain.service;

import vn.callbilling.domain.model.Call;
import vn.callbilling.domain.model.CallBill;
import vn.callbilling.domain.ports.CallBillingRepositoryPort;
import vn.callbilling.domain.ports.CallRepositoryPort;

public class CallAndBillingServiceImpl extends AbstractService implements CallAndBillingService{
    private CallRepositoryPort callRepositoryPort;
    private CallBillingRepositoryPort callBillingRepositoryPort;

    public CallAndBillingServiceImpl(CallRepositoryPort callRepositoryPort, CallBillingRepositoryPort callBillingRepositoryPort) {
        this.callRepositoryPort = callRepositoryPort;
        this.callBillingRepositoryPort = callBillingRepositoryPort;
    }

    @Override
    public void insertCall(String userName, Integer callDuration) throws Exception {
        Integer block = callDuration / 30;
        if (callDuration % 30 != 0) {
            block = block + 1;
        }
        Call call = Call.builder()
                .userName(userName)
                .callDuration(callDuration)
                .blockCount(block).build();
        callRepositoryPort.saveCall(call);
        callBillingRepositoryPort.saveCallBilling(call);
    }

    @Override
    public CallBill getBill(String userName) {
        CallBill callBill = callBillingRepositoryPort.findCallBilling(userName);
        return callBill;
    }
}
