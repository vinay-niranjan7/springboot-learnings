package com.vinay7.filterdemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        long start=System.currentTimeMillis();

        HttpServletRequest httpRequest= (HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        String requestID= UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-ID: ",requestID);

        System.out.println("Incoming Request Type: "+ httpRequest.getMethod()+" Url: "+httpRequest.getRequestURI());
        try{
            chain.doFilter(request,response);
        }
        finally {
            long duration=System.currentTimeMillis()-start;
            System.out.println("Response Status: "+httpResponse.getStatus()+" Duration: "+duration);
        }



    }
}
