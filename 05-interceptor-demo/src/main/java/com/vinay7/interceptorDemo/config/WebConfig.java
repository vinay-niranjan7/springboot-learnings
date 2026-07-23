package com.vinay7.interceptorDemo.config;


import com.vinay7.interceptorDemo.interceptor.AuthenticationInterceptor;
import com.vinay7.interceptorDemo.interceptor.AuthorizationInterceptor;
import com.vinay7.interceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;
    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor,
                     AuthorizationInterceptor authorizationInterceptor) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/public/**")
                .order(1);

        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")
                .order(3);

        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/api/**")
                .order(2);
    }
}

