package vn.callbilling.infrastructure.adapter;

import org.springframework.stereotype.Component;
import vn.callbilling.domain.model.Call;
import vn.callbilling.domain.ports.CallRepositoryPort;
import vn.callbilling.infrastructure.entities.CallEntity;
import vn.callbilling.infrastructure.repository.CallRepository;

import java.time.LocalDateTime;

@Component
public class JpaCallRepositoryAdapter implements CallRepositoryPort {
    private CallRepository callRepository;

    public JpaCallRepositoryAdapter(CallRepository callRepository) {
        this.callRepository = callRepository;
    }

    @Override
    public void saveCall(Call call) {
        CallEntity callEntity = CallEntity.builder().userName(call.getUserName())
                .blockCount(call.getBlockCount())
                .callDuration(call.getCallDuration())
                .createBy("SYSTEM")
                .createDate(LocalDateTime.now()).build();
        callRepository.save(callEntity);
    }
}
