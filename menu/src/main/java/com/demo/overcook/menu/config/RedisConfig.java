package com.demo.overcook.menu.config;

import com.demo.overcook.menu.model.Dish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

  @Bean
  public ReactiveRedisConnectionFactory connectionFactory(RedisAttributes redisAttributes) {
    return new LettuceConnectionFactory(redisAttributes.getHost(), redisAttributes.getPort());
  }


  @Bean
  ReactiveRedisOperations<String, Dish> redisOperations(ReactiveRedisConnectionFactory redisConnectionFactory) {
    Jackson2JsonRedisSerializer<Dish> serializer = new Jackson2JsonRedisSerializer<>(Dish.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, Dish> builder =
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, Dish> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(redisConnectionFactory, context);
  }
}
