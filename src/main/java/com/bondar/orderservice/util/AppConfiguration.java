package com.bondar.orderservice.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("file:application.yml")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppConfiguration {

    @Value("${payment-service.path}")
    static String path;

    @Value("${payment-service.method}")
    static String method;

    public static String getPath() {
        return path;
    }

    public static String getMethod() {
        return method;
    }
}
