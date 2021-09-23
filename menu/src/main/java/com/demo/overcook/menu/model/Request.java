package com.demo.overcook.menu.model;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {

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
