package io.zwt.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLoggingAspect extends CallTracker {

    Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspect.class);

    @AfterThrowing(pointcut = "io.zwt.SystemArchitecture.Repository() || io.zwt.SystemArchitecture.Service()", throwing = "ex")
    public void logException(Exception ex) {
        trackCall();
        logger.error("Exception", ex);
    }

}
