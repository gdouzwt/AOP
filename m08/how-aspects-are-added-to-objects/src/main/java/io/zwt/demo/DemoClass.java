package io.zwt.demo;

import org.springframework.stereotype.Component;

@Component
public class DemoClass {


    public void advisedMethod() {

    }


    public void callsTheAdvisedMethod() {
        advisedMethod();
    }

}
