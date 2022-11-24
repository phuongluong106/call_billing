package vn.callbilling.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import vn.callbilling.infrastructure.entities.CallBillingEntity;

import javax.persistence.LockModeType;
@Repository
public interface CallBillingRepository  extends JpaRepository<CallBillingEntity, String> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public CallBillingEntity findByUserName(String userName);
}
