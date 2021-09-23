package com.demo.overcook.menu.model;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

  @NonNull
  @NotEmpty
  private String id;

  @NonNull
  @NotEmpty
  private String name;

  @NonNull
  @NotEmpty
  private String description;

  @NonNull
  @NotEmpty
  private List<String> ingredients;

  @NonNull
  @NotEmpty
  private Long cookingTime;

}
