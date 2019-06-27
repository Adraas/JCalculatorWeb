package ru.wkn.filters;

import ru.wkn.util.CookieManager;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityProfileFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String cookie = CookieManager.getCookie(req);
        if (cookie != null) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/sign_in.jsp").forward(req, response);
        }
    }
}
