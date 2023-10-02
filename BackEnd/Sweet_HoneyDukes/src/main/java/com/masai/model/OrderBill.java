package com.masai.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBill {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderBillId;

    @NotNull(message = "Date should be there")
    private LocalDate orderBill;
    
    private Double totalCost;

    @JsonIgnore
    @OneToOne(mappedBy = "orderBill", cascade = CascadeType.ALL)
    private SweetOrder sweetOrderList;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @Override
    public String toString() {
        return "OrderBill{" +
                "orderBillId=" + orderBillId +
                ", orderBill=" + orderBill +
                ", totalCost=" + totalCost +
                '}';
    }

	
}