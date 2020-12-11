package com.exalt.microservice.netflixzuulapigatewayserver;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter  extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);

    /**
     * when should the filter be executed, before the request or after it !
     * 1-pre
     * 2-post
     * 3-error
     * */
    @Override
    public String filterType() {

        return "pre";
    }

    /**
     * this function used to determine the filter order
     * */
    @Override
    public int filterOrder() {

        return 0;
    }
    /**
     * to see if we want to execute this filter or not
     * */
    @Override
    public boolean shouldFilter() {

        return true;
    }
    /**
     * the complete logic of the filter
     * */
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request =
                RequestContext.getCurrentContext().getRequest();

        logger.info("request -> {} request uri -> {}",request,request.getRequestURI());

        return null;
    }
}
