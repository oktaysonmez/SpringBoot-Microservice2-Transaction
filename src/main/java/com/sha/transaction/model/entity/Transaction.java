package com.sha.transaction.model.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "TRANSACTIONS")
@javax.persistence.Entity
public class Transaction extends Entity<Integer>
{
    @NonNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TRANSACTION_ID")
    @Id
    @Override
    public Integer getId()
    {
        return super.getId();
    }

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productID;

    @Column(name = "USER_ID", nullable = false)
    private Integer userID;

    @Temporal(TemporalType.DATE)
    @Column(name = "TRANSACTION_TIME", nullable = false)
    private Date transactionTime;

}
