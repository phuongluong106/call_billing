package vn.callbilling.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.callbilling.infrastructure.entities.CallEntity;
@Repository
public interface CallRepository extends JpaRepository<CallEntity, Integer> {

}
