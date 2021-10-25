package com.demo.overcook.supplies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

  @NotEmpty
  private Set<Ingredient> ingredientList;
}