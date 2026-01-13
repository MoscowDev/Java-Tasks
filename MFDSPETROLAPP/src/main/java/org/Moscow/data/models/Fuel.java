package org.Moscow.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fuel {
    private String fuelName;
    private double pricePerLiter;
    private double quantity;


}

