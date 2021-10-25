package com.demo.overcook.supplies.business;

import com.demo.overcook.supplies.model.Dish;
import com.demo.overcook.supplies.model.Ingredient;
import com.demo.overcook.supplies.model.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class SupplyService {

  private final ReactiveRedisOperations<String, Dish> dishOps;

  public Flux<Ingredient> getIngredients(final String dishId) {
    return dishOps.opsForValue().get(dishId).map(Dish::getIngredientList).flatMapMany(Flux::fromIterable);
  }

  public Mono<Boolean> upsertIngredient(final Request request) {
    return getDish(request.getDishId()).map(dish -> {
      dish.getIngredientList().remove(request.getIngredient());
      dish.getIngredientList().add(request.getIngredient());
      return dish;
    }).flatMap(dish -> dishOps.opsForValue().set(request.getDishId(), dish));
  }

  private Mono<Dish> getDish(final String dishId) {
    return dishOps.opsForValue().get(dishId).defaultIfEmpty(createDish());
  }

  private Dish createDish() {
    final Dish dish = new Dish();
    dish.setIngredientList(new HashSet<>());
    return dish;
  }
}