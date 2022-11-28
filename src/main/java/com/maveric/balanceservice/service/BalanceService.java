package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;

public interface BalanceService {

    BalanceDto getBalanceByAccountId(String accountId);

    public BalanceDto createBalance(String accountId, BalanceDto balanceDto);

    public BalanceDto getBalanceDetails(String accountId,String balanceId);
    public String deleteBalance(String balanceId);
    public String deleteBalanceByAccountId(String accountId);

    public BalanceDto updateBalance(String accountId,String balanceId,BalanceDto balanceDto);
}
