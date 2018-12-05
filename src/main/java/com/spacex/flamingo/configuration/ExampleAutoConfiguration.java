package com.spacex.flamingo.configuration;

import com.spacex.flamingo.properties.ExampleServiceProperties;
import com.spacex.flamingo.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ExampleService.class)
@EnableConfigurationProperties(ExampleServiceProperties.class)
public class ExampleAutoConfiguration {
    private final ExampleServiceProperties exampleServiceProperties;

    @Autowired
    public ExampleAutoConfiguration(ExampleServiceProperties exampleServiceProperties) {
        this.exampleServiceProperties = exampleServiceProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    public ExampleService exampleService() {
        return new ExampleService(exampleServiceProperties.getPrefix(), exampleServiceProperties.getSuffix());
    }
}
