/**
 * 
 */
package com.evergreenprogrammer.microservices.commongatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author TapojitBhattacharya
 *
 */
@Component
public class ZuulPreFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulPreFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#run()
	 */
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
		logger.info("ZuulPreFilter.run---> {}");
		logger.info(String.format("%s request to %s", httpServletRequest.getMethod(),
				httpServletRequest.getRequestURL().toString()));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {

		return "pre"; // pre, post, error
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {

		return 1; // For multiple Zuul based filters it defines priority
	}

}
