package com.demo.overcook.menu.config;

import com.demo.overcook.menu.model.Dish;
import com.demo.overcook.menu.model.Request;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class RedisConfig {

  private final RedisAttributes redisAttributes;

  public RedisConfig(final RedisAttributes redisAttributes) {
    this.redisAttributes = redisAttributes;
  }

  @Bean
  public ReactiveRedisConnectionFactory redisConnectionFactory() {
    return new LettuceConnectionFactory(this.redisAttributes.getHost(), this.redisAttributes.getPort());
  }

  @Bean
  ReactiveRedisOperations<String, Dish> redisOperations(ReactiveRedisConnectionFactory redisConnectionFactory) {
    Jackson2JsonRedisSerializer<Dish> serializer = new Jackson2JsonRedisSerializer<>(Dish.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, Dish> builder =
        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, Dish> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(redisConnectionFactory, context);
  }

  @Bean
  ReactiveRedisOperations<String, Request> redisOperationsRequest(ReactiveRedisConnectionFactory redisConnectionFactory) {
    Jackson2JsonRedisSerializer<Request> serializer = new Jackson2JsonRedisSerializer<>(Request.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, Request> builder =
            RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, Request> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(redisConnectionFactory, context);
  }

}
