package vn.callbilling.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import vn.callbilling.domain.service.CallAndBillingService;
import vn.callbilling.domain.service.CallAndBillingServiceImpl;
import vn.callbilling.infrastructure.adapter.JpaCallBillingRepositoryAdapter;
import vn.callbilling.infrastructure.adapter.JpaCallRepositoryAdapter;

@Configuration
public class ServiceConfiguration {
    @Autowired
    JpaCallBillingRepositoryAdapter jpaCallBillingRepositoryAdapter;
    @Autowired
    JpaCallRepositoryAdapter jpaCallRepositoryAdapter;
    @Bean("callAndBillingService")
    CallAndBillingService callAndBillingService(){
        return new CallAndBillingServiceImpl(jpaCallRepositoryAdapter, jpaCallBillingRepositoryAdapter);
    }
}
