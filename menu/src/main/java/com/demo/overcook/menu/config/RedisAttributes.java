package com.demo.overcook.menu.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.redis")
public class RedisAttributes {
  private String host;
  private Integer port;
}
