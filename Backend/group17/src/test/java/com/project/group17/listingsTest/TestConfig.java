package com.project.group17.listingsTest;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.project.group17.config.JwtService;

@Configuration
public class TestConfig {
    @Bean
    public JwtService mockJwtService() {
        return Mockito.mock(JwtService.class);
    }
}

