package com.maveric.balanceservice.repository;

import com.maveric.balanceservice.model.Balance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BalanceRepository extends MongoRepository<Balance,String> {
    Balance findByAccountId(String accountId);
    void deleteByAccountId(String accountId);
}
