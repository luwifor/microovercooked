package com.demo.overcook.supplies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

  @NotBlank
  private String name;

  @NotNull
  private Status state;

  // This function was overridden to allow use the object in a HashSet
  @Override
  public int hashCode() {
    return name.toLowerCase().hashCode();
  }

  // This function was overridden to allow use the object in a HashSet
  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Ingredient)) {
      return false;
    }
    final Ingredient ingredient = (Ingredient) object;
    return ingredient.getName().equalsIgnoreCase(name);
  }
}