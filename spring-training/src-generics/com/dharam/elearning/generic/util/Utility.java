package com.dharam.elearning.generic.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Utility
{
	private Log log = LogFactory.getLog(this.getClass());

	public void logException(Exception e)
	{
		log.error("Code Crash: ");
		log.error("Cause: " + ExceptionUtils.getRootCause(e));
		log.error("StackTrace: " + ExceptionUtils.getStackTrace(e));
	}
}
