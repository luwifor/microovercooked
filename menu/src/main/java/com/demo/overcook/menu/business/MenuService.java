package com.demo.overcook.menu.business;

import com.demo.overcook.menu.model.Menu;
import reactor.core.publisher.Mono;

public interface MenuService {
  Mono<Menu> listMenu();
}
