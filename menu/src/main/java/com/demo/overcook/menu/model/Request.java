package com.demo.overcook.menu.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "request")
public class Request implements Serializable {

  @NonNull
  @NotEmpty
  private String id;

  @NonNull
  @NotEmpty
  private Menu menu;

  @NonNull
  @NotEmpty
  private Long timeLimit;

  @NonNull
  @NotEmpty
  private Date date;

  @NonNull
  @NotEmpty
  private String state;
}
