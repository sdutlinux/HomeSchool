package com.linuxgroup.filter;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by tan on 14-9-22.
 */
public class MyStrutsFilter extends StrutsPrepareAndExecuteFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();
        if(path.contains("/restful/")) {
//            log.debug("跳过struts");
            chain.doFilter(request, response);
        } else {
//            log.debug("进入struts");
            super.doFilter(request, response, chain);
        }
    }
}
