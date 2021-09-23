package com.demo.overcook.menu.controller;

import com.demo.overcook.menu.business.MenuService;
import com.demo.overcook.menu.model.Dish;
import com.demo.overcook.menu.model.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/menu")
@RequiredArgsConstructor
public class MenuController {

  private final MenuService menuService;

  @GetMapping(path = "/listMenu")
  public Mono<Menu> listAvailableMenu() {
    return null;
  }

  @GetMapping(path = "/dish")
  public Mono<Dish> getDish(@RequestParam(name = "id") String id) {
    return null;
  }

  @PostMapping(path = "/createDishMenu")
  public Mono<Dish> createDish(@RequestBody Dish dish) {
    return null;
  }

}
