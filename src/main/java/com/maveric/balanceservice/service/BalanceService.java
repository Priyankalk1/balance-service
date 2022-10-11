package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;

import java.util.List;

public interface BalanceService {
    public List<BalanceDto> getBalances();

    public BalanceDto createBalance(BalanceDto balance);

    public BalanceDto getBalanceDetails(String balanceId);

    public Balance updateBalance(String balanceId);
    public String deleteBalance(String balanceId);
}
