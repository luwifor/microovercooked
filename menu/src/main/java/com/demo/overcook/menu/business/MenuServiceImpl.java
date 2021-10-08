package com.demo.overcook.menu.business;

import com.demo.overcook.menu.model.Dish;
import com.demo.overcook.menu.model.Menu;
import java.util.UUID;

import com.demo.overcook.menu.model.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

  private final ReactiveRedisOperations<String, Dish> reactiveRedisOperations;

  private final ReactiveRedisOperations<String, Request> reactiveRedisOperationsRequest;

  @Override
  public Mono<Menu> listMenu() {
    return reactiveRedisOperations.keys("*")
        .flatMap(reactiveRedisOperations.opsForValue()::get)
        .collectList()
        .map(dishes -> Menu.builder().dishes(dishes).build());
  }

  @Override
  public Mono<Dish> getDish(String id) {
      return reactiveRedisOperations.keys("*")
              .flatMap(reactiveRedisOperations.opsForValue()::get).last().filter(x -> id.equals(x.getId()));
  }

  @Override
  public Mono<Boolean> createDish(Dish dish) {
    return Mono.just(UUID.randomUUID().toString())
        .map(id -> {
          dish.setId(id);
          return dish;
        })
        .flatMap(d -> reactiveRedisOperations.opsForValue().set(d.getId(), d));
  }

  @Override
    public Mono<Boolean> createRequest(Request request) {
      return Mono.just(UUID.randomUUID().toString())
              .map(id -> {
                  request.setId(id);
                  return request;
              })
              .flatMap(d -> reactiveRedisOperationsRequest.opsForValue().set(d.getId(), d));
  }
}
