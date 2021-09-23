package com.demo.overcook.menu.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "dish")
public class Dish implements Serializable {

    @NonNull
    @NotEmpty
    @Id
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

    private static final long serialVersionUID = 1285454306356845811L;
}
