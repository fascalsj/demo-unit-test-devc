package com.belajar.tdd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table
public class CheckoutEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer amount;

    private String promoCode;

    private Integer discountAmout;

    private Integer totalAmount;
}
