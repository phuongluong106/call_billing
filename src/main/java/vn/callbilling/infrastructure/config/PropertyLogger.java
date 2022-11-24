package vn.callbilling.infrastructure.config;

import java.util.Arrays;
import java.util.stream.StreamSupport;

import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

@Profile("!prod")
@Component
public class PropertyLogger {

    private static final String PASSWORD = "password";
    private static final String CREDENTIALS = "credentials";

    @SuppressWarnings("rawtypes")
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        final Environment env = event.getApplicationContext().getEnvironment();
    }
}
