package com.jcarbad.richardsonrest.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
   @NotBlank
   private String firstName;

   @NotBlank
   private String lastName;

   private String customerUrl;
}
