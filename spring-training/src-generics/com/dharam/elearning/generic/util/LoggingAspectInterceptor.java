package com.dharam.elearning.generic.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingAspectInterceptor extends HandlerInterceptorAdapter
{
    private Log log = LogFactory.getLog(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
	log.info(
		"\n\n==================================== IN ===================================="
		+ "\n\n\t URL :: " + request.getRequestURL()
		+ "\n\n\t IP :: " + request.getRemoteAddr()
		+ "\n\n\t USER - AGENT :: " + request.getHeader("User-Agent")
		+ "\n\n"
		);
	return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
	log.info(
		"\n\n==================================== OUT ===================================="
		+"\n\n\t URL :: " + request.getRequestURL()
		+ "\n\n"
		);
    }
}
