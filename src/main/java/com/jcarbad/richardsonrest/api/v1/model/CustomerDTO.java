package com.jcarbad.richardsonrest.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
   private String firstName;
   private String lastName;
   private String customerUrl;
}
