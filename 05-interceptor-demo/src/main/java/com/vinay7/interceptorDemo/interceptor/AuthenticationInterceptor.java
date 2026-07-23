package com.vinay7.interceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        System.out.println("AuthenticationInterceptor called");
        String apiKey = request.getHeader("x-api-key");

        if(apiKey == null || !apiKey.equals("api123")) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write("\n" +
                    "{\n" +
                    "    \"message\" : \"Headers are missing or are invalid\"\n" +
                    "}");
            return false;
        }

        return true;
    }
}
