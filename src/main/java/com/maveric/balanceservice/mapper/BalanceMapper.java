package com.maveric.balanceservice.mapper;


import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="Balance")
public interface BalanceMapper {

    Balance map(BalanceDto balanceDto);

    BalanceDto map(Balance balance);

    List<Balance> mapToModel (List<BalanceDto> balances);

    List<BalanceDto> mapToDto (List<Balance> balances);
}
