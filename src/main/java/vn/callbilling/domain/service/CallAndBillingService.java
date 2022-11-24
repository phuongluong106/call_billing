package vn.callbilling.domain.service;

import vn.callbilling.domain.model.CallBill;

public interface CallAndBillingService {
    void insertCall(String userName, Integer callDuration) throws Exception;
    CallBill getBill(String userName);
}
