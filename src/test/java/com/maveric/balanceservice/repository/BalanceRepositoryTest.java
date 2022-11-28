package com.maveric.balanceservice.repository;


import com.maveric.balanceservice.model.Balance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.maveric.balanceservice.BalanceServiceApplicationTests.getBalance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@RunWith(SpringRunner.class)
public class BalanceRepositoryTest {

    @Autowired
    BalanceRepository repository;

    @Test
    public void testSave() {
        Balance balance = repository.save(getBalance());
        assertEquals("123",balance.getAccountId());
    }

    @Test
    public void testFindAll() {
        List<Balance> balances = repository.findAll();
        assertNotNull(balances);
        assert(balances.size()>0);
    }

}