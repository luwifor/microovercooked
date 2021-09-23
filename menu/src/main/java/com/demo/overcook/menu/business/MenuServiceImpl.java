package com.demo.overcook.menu.business;

import com.demo.overcook.menu.model.Dish;
import com.demo.overcook.menu.model.Menu;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

  private final ReactiveRedisOperations<String,Dish> reactiveRedisOperations;

  @Override
  public Mono<Menu> listMenu() {
    return Mono.empty();
  }

  private List<Dish> dishes(){
   return null;
  }
}
