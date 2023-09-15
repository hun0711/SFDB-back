package com.back;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.back.api.repository.ApiDao;

@Configuration
@EnableScheduling
public class WebConfig implements WebMvcConfigurer {
}
