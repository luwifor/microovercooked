package com.demo.overcook.menu.business;

import com.demo.overcook.menu.model.Dish;
import com.demo.overcook.menu.model.Menu;
import com.demo.overcook.menu.model.Request;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuService {
  Mono<Menu> listMenu();
  Mono<Dish> getDish(String id);
  Mono<Boolean> createDish(Dish dish);
  Mono<Boolean> createRequest(Request request);
}
