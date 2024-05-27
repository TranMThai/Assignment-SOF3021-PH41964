package com.sof_3021.ph41964.filter;

import com.sof_3021.ph41964.entity.Employee;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);

        String path = request.getRequestURI();

        if (path.equals("/login") || path.equals("/login/enter")) {
            chain.doFilter(req, res);
            return;
        }

        if (session == null || session.getAttribute("auth") == null) {
            response.sendRedirect("/login");
            return;
        }else{
            if(path.startsWith("/bill")||path.startsWith("/bill_detail")){
                if(!((Employee)session.getAttribute("auth")).getRole()){
                    response.sendRedirect("/login");
                    return;
                }
            }
            chain.doFilter(req, res);
        }
    }
}
