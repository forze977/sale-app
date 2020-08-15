package com.forze.sale.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class OrderModel {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String orderString;
    @NotNull
    private String guid;
    @NotNull
    private Timestamp timestamp = new Timestamp(new Date().getTime());
    private boolean isDone = false;
    @NotNull
    private String name;
    @Min(0)
    private int tableNumber = -1;
    private boolean isCancel = false;
}