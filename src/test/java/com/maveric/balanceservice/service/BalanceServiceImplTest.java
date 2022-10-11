package com.maveric.balanceservice.service;
import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class BalanceServiceImplTest {
        @Mock
        private BalanceRepository balanceRepository;
        @InjectMocks
        private BalanceServiceImpl balanceService;

        @Test
        void shouldReturnBalanceWhenCreateBalanceInvoked() {

            when(balanceRepository.save(any())).thenReturn(balanceService.createBalance(new BalanceDto()));
            BalanceDto balanceDto = balanceService.createBalance(getBalanceDto());

            assertNotNull(balanceDto);
        }


    @Test
        void shouldDeleteBalanceBalanceInvoked(){

            balanceRepository.deleteById(1);
            verify(balanceRepository,atLeastOnce()).deleteById(1);
        }
        @Test
        void shouldReturnBalancesWhenBlanceIsNotEmptyInDb(){
            List<Balance> balance = new ArrayList<Balance>();
            balance.add(getBalances());
            when(balanceRepository.findAll()).thenReturn(balance);
            assertFalse((BooleanSupplier) balanceService.getBalanceDetails("1"));

        }

        private Balance getBalances() {
            Balance balance = new Balance();
            balance.setId("2");
            balance.setAccountId("12");
            balance.setCurrency("INR");
            balance.setCreatedAt("2022-09-01T10:45:49.520Z");
            balance.setUpdatedAt("2022-09-01T10:45:49.520Z");

            return balance;

        }
        private BalanceDto getBalanceDto() {
            BalanceDto balanceDto = new BalanceDto();
            balanceDto.setId("2");
            balanceDto.setAccountId("12");
            balanceDto.setCurrency("INR");
            balanceDto.setCreatedAt("2022-09-01T10:45:49.520Z");
            balanceDto.setUpdatedAt("2022-09-01T10:45:49.520Z");

            return balanceDto;

        }

    }

