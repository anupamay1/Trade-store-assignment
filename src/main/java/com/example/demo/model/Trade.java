package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Table(name = "Trade")
@Data
@ToString
public class Trade {

    @Id
    private String tradeId;

    private int version;

    private String counterParty;

    private String bookId;

    private LocalDate maturityDate;

    private LocalDate createdDate;

    private String expiredFlag;
}
