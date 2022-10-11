package com.maveric.balanceservice.util;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ModelDtoTransformer {

    public static Balance toEntity(BalanceDto dto) {
        return new Balance(
                dto.getId(),
                dto.getAccountId(),
                dto.getAmount(),
                dto.getCurrency(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }

    public static BalanceDto toDto(Balance model) {
        return new BalanceDto(
                model.getId(),
                model.getAccountId(),
                model.getAmount(),
                model.getCurrency(),
                model.getCreatedAt(),
                model.getUpdatedAt()
        );
    }
}
