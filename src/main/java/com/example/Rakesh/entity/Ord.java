package com.example.Rakesh.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "ord")
public class Ord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "ord_date")
    private LocalDate ord_date;

    @Column(name = "total_amount")
    private Integer total_amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public void SetId(Long id){
        this.id=id;
    }
    public Long getId(Long id){
        return id;
    }

    public void SetCustomerName(String customer_name){
        this.customer_name=customer_name;
    }

    public String getCustomerName(){
        return customer_name;
    }

    public void SetOrdDate(LocalDate ord_date){
        this.ord_date=ord_date;
    }

    public LocalDate getOrdDate(){
        return ord_date;
    }

    public void SetTotalAmount(Integer total_amount){
        this.total_amount=total_amount;
    }

    public Integer getTotalAmount(){
        return total_amount;
    }

}