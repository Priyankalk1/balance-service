package com.maveric.balanceservice.mapper;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

@Component
public class BalanceMapperImpl implements BalanceMapper {
    @Override
    public Balance map(BalanceDto balanceDto) {
        return new Balance(
                balanceDto.get_id(),
                balanceDto.getAccountId(),
                balanceDto.getAmount(),
                balanceDto.getCurrency(),
                balanceDto.getCreatedAt(),
                balanceDto.getUpdatedAt()
        );
    }

    @Override
    public BalanceDto map(Balance balance) {
        return new BalanceDto(
                balance.get_id(),
                balance.getAccountId(),
                balance.getAmount(),
                balance.getCurrency(),
                balance.getCreatedAt(),
                balance.getUpdatedAt()
        );
    }

    @Override
    public List<Balance> mapToModel(List<BalanceDto> balanceDtos) {
        if(!balanceDtos.isEmpty())
            return balanceDtos.stream().map(balance -> new Balance(
                    balance.get_id(),
                    balance.getAccountId(),
                    balance.getAmount(),
                    balance.getCurrency(),
                    balance.getCreatedAt(),
                    balance.getUpdatedAt()
            )).toList();
        else
            return Collections.<Balance>emptyList();
    }

    @Override
    public List<BalanceDto> mapToDto(List<Balance> balances) {
        if(!balances.isEmpty())
            return balances.stream().map(balanceDto -> new BalanceDto(
                    balanceDto.get_id(),
                    balanceDto.getAccountId(),
                    balanceDto.getAmount(),
                    balanceDto.getCurrency(),
                    balanceDto.getCreatedAt(),
                    balanceDto.getUpdatedAt()
            )).toList();
        else
            return Collections.<BalanceDto>emptyList();
    }

}
