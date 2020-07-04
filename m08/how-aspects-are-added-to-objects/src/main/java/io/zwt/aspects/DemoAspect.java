package io.zwt.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect extends CallTracker {

    @Before("execution(void advisedMethod())")
    public void logException() {
        trackCall();
    }

}
