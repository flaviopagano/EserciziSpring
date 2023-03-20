package com.example.Spring.Repositories1;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String modelName;
    @NotNull
    private int serialNumber;
    @Nullable
    private int currentPrice;


}
