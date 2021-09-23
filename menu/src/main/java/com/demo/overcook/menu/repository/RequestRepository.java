package com.demo.overcook.menu.repository;

import com.demo.overcook.menu.model.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RequestRepository {

  private final ReactiveRedisOperations<String, Request> reactiveRedisOperations;

}
