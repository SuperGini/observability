package com.gini.config;

//import io.opentelemetry.api.OpenTelemetry;
//import io.opentelemetry.instrumentation.logback.appender.v1_0.OpenTelemetryAppender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;


//https://www.youtube.com/watch?v=fjYAU3jayVo&t=949s
//https://www.youtube.com/watch?v=jfbUwZwzC98
@Configuration
@RequiredArgsConstructor
public class OtlConfg implements InitializingBean {

//    private final OpenTelemetry openTelemetry;
//
//
    @Override
    public void afterPropertiesSet() {
//        OpenTelemetryAppender.install(this.openTelemetry);
    }
}
