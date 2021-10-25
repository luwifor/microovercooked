package com.demo.overcook.supplies.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class Request {

  @NotBlank
  private String dishId;

  @NotNull
  private Ingredient ingredient;
}