package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

import java.util.List;

public interface BalanceService {
    public List<BalanceDto> getBalances();

    public BalanceDto createBalance(BalanceDto balance);

    public BalanceDto getBalanceDetails(String balanceId);

    public BalanceDto updateBalance(String balanceId);
    public String deleteBalance(String balanceId);
}