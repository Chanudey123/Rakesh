package com.example.Rakesh.Payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class OrdDto {

    public Long id;

    @NotNull
    @Size(max=10)
    public String customer_name;

    @NotNull
    public LocalDate order_date;

    @NotNull
    public Integer total_amount;
}
