package com.demo.overcook.supplies.controller;

import com.demo.overcook.supplies.business.SupplyService;
import com.demo.overcook.supplies.model.Ingredient;
import com.demo.overcook.supplies.model.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/supplies")
public class SuppliesController {

  private final SupplyService supplyService;

  public SuppliesController(final SupplyService supplyService) {
    this.supplyService = supplyService;
  }

  // just for debug purposes
  // retrieve the list of ingredients related to a dish
  @GetMapping("/{id}")
  public Flux<Ingredient> getIngredients(@PathVariable final String id) {
    return supplyService.getIngredients(id);
  }

  // update a ingredient status
  @PutMapping("/upsert")
  public Mono<Boolean> upsertSupply(@Valid @RequestBody final Request request) {
    return supplyService.upsertIngredient(request);
  }
}