package io.zwt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 要启用这个，不然测试不通过
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "io.zwt")
public class SimpleAspectConfiguration {
}
