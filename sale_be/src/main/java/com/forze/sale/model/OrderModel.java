package com.forze.sale.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class OrderModel {
    @Id @GeneratedValue
    private Long id;
    private String orderString;
    private Long amount;
    private String guid;
    private Timestamp timestamp;
    private boolean isDone;
}