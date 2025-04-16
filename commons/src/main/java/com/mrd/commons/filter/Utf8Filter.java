package com.mrd.commons.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Utility class for UTF-8 Servlet Filter. This filter would be used to consistently set the character encoding as UTF-8.
 *
 * @author Y Kamesh Rao
 */
public class Utf8Filter implements Filter {

    
    public void destroy() {
    }


    
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException,
            ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }


    
    public void init(FilterConfig arg0) throws ServletException {
    }

}
