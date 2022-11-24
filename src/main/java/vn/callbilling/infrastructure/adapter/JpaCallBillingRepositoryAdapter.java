package vn.callbilling.infrastructure.adapter;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import vn.callbilling.domain.model.Call;
import vn.callbilling.domain.model.CallBill;
import vn.callbilling.domain.ports.CallBillingRepositoryPort;
import vn.callbilling.infrastructure.entities.CallBillingEntity;
import vn.callbilling.infrastructure.repository.CallBillingRepository;

import java.time.LocalDateTime;

@Component
public class JpaCallBillingRepositoryAdapter implements CallBillingRepositoryPort {
    @Autowired
    CallBillingRepository callBillingRepository;
    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public CallBill findCallBilling(String userName) {
        CallBillingEntity callBillingEntity = callBillingRepository.findByUserName(userName);
        if(ObjectUtils.allNotNull(callBillingEntity)) {
            return CallBill.builder()
                    .callCount(callBillingEntity.getCallCount())
                    .blockCount(callBillingEntity.getBlockCount())
                    .userName(callBillingEntity.getUserName()).build();
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void saveCallBilling(Call call) {
        CallBillingEntity callBillingEntity = callBillingRepository.findByUserName(call.getUserName());
        if(ObjectUtils.allNotNull(callBillingEntity)){
            callBillingEntity.setCallCount(callBillingEntity.getCallCount() + 1);
            callBillingEntity.setBlockCount(callBillingEntity.getBlockCount() + call.getBlockCount());
            callBillingEntity.setUpdateBy("SYSTEM");
            callBillingEntity.setUpdateDate(LocalDateTime.now());
            callBillingRepository.save(callBillingEntity);
        }
        else{
            callBillingRepository.save(CallBillingEntity.builder()
                    .userName(call.getUserName())
                    .blockCount(call.getBlockCount())
                    .callCount(1)
                    .createBy("SYSTEM")
                    .createDate(LocalDateTime.now()).build());
        }
    }
}
