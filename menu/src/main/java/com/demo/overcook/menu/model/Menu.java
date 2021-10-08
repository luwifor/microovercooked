package com.demo.overcook.menu.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Menu implements Serializable {

  @NonNull
  @NotEmpty
  private List<Dish> dishes;

  private static final long serialVersionUID = 1285454306356845812L;
}
