package com.maveric.balanceservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class BalanceDto {

        private String id;
        private String accountId;
        private Integer amount;
        private String currency;
        private String createdAt;
        private String updatedAt;



}



