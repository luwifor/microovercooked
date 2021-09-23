package com.demo.overcook.menu.model;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Menu implements Serializable {

  private String id;

  @NonNull
  @NotEmpty
  private List<Dish> dishes;

  private static final long serialVersionUID = 1285454306356845812L;
}
