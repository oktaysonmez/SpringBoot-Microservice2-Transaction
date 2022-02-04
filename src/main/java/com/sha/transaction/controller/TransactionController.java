package com.sha.transaction.controller;

import com.sha.transaction.model.entity.Transaction;
import com.sha.transaction.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController
{
    @Autowired
    private AbstractTransactionService service;

    // api/transaction/userID
    @GetMapping("{userID}")
    public ResponseEntity<List<Transaction>> getTransactionOfUser(@PathVariable Integer userID)
    {
        return ResponseEntity.ok(service.findAllTransactionsOfUser(userID));
    }

    // api/transaction
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("{transactionID}") // api/transaction/transactionID
    public ResponseEntity<?> deleteTransactionByID(@PathVariable Integer transactionID)
    {
        service.deleteByID(transactionID);

        return new ResponseEntity(HttpStatus.OK);
    }

    // api/transaction
    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction)
    {
        Transaction savedTransaction = service.save(transaction);

        return new ResponseEntity<>(savedTransaction,HttpStatus.CREATED);
    }
}
