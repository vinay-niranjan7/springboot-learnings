package com.vinay7.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest= (HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;

        String token=httpRequest.getHeader("token");
        String apikey=httpRequest.getHeader("x-api-key");
        if(token==null || !token.equals("123")){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if(apikey==null || !apikey.equals("api123")){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(
                    "{\n" +
                            "    \"message\":\"api key is missing or invalid\"\n" +
                            "}"
            );

            return;
        }

        chain.doFilter(request,response);

    }
}
