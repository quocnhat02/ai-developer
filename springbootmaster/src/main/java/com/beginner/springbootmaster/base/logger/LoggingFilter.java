package com.beginner.springbootmaster.base.logger;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoggingFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getHeaderNames().asIterator().forEachRemaining(name ->
                System.out.println(name + ": " + request.getHeader(name)));

        String lightCodeSE = request.getHeader("lightCodeSE");
        if (lightCodeSE != null && lightCodeSE.equals("reject")) {
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendError(403, "Forbidden");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
