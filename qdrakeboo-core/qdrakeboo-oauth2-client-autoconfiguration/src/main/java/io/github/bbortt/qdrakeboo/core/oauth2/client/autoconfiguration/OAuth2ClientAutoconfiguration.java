package io.github.bbortt.qdrakeboo.core.oauth2.client.autoconfiguration;

import io.github.bbortt.qdrakeboo.core.oauth2.client.autoconfiguration.config.GlobalMethodSecurityConfig;
import io.github.bbortt.qdrakeboo.core.oauth2.client.autoconfiguration.config.OAuth2ClientAutoconfigurationProperties;
import io.github.bbortt.qdrakeboo.core.oauth2.client.autoconfiguration.config.OAuth2ResourceServerConfig;
import io.github.bbortt.qdrakeboo.core.oauth2.client.autoconfiguration.config.RemoteTokenServiceConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({GlobalMethodSecurityConfig.class, OAuth2ResourceServerConfig.class,
    RemoteTokenServiceConfig.class})
@EnableConfigurationProperties({OAuth2ClientAutoconfigurationProperties.class})
public class OAuth2ClientAutoconfiguration {

}