package com.sha.transaction.model.service;

import com.sha.transaction.model.entity.Transaction;
import com.sha.transaction.model.repository.TransactionRepository;
import com.sha.transaction.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends AbstractTransactionService
{

    @Override
    public List<Transaction> findAllTransactionsOfUser(Integer userID) {
        return repository.findAllByUserID(userID);

    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Transaction save(Transaction entity) {
        try
        {
            return repository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
            return new Transaction();
        }
    }

    @Override
    public void deleteByID(Integer id) {
        try
        {
            repository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
        }
    }
}
