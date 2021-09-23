package com.demo.overcook.menu.business;

import com.demo.overcook.menu.model.Dish;
import com.demo.overcook.menu.model.Menu;
import reactor.core.publisher.Mono;

public interface MenuService {
  Mono<Menu> listMenu();
  Mono<Boolean> createDish(Dish dish);
}
