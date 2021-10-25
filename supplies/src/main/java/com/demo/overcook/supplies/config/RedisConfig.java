package com.demo.overcook.supplies.config;

import com.demo.overcook.supplies.model.Dish;
import com.demo.overcook.supplies.model.Ingredient;
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

  private final RedisAttributes redisAttributes;

  public RedisConfig(final RedisAttributes redisAttributes) {
    this.redisAttributes = redisAttributes;
  }

  @Bean
  public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
    return new LettuceConnectionFactory(redisAttributes.getHost(), redisAttributes.getPort());
  }

  @Bean
  ReactiveRedisOperations<String, Ingredient> ingredientOperations(
          final ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
    final Jackson2JsonRedisSerializer<Ingredient> serializer = new Jackson2JsonRedisSerializer<>(Ingredient.class);
    final RedisSerializationContext.RedisSerializationContextBuilder<String, Ingredient> builder =
            RedisSerializationContext
            .newSerializationContext(new StringRedisSerializer());
    final RedisSerializationContext<String, Ingredient> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, context);
  }

  @Bean
  ReactiveRedisOperations<String, Dish> dishOperations(
          final ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
    final Jackson2JsonRedisSerializer<Dish> serializer = new Jackson2JsonRedisSerializer<>(Dish.class);
    final RedisSerializationContext.RedisSerializationContextBuilder<String, Dish> builder = RedisSerializationContext
            .newSerializationContext(new StringRedisSerializer());
    final RedisSerializationContext<String, Dish> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, context);
  }
}