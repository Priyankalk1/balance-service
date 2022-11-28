package com.maveric.balanceservice.dto;

import com.maveric.balanceservice.enumeration.Currency;
import lombok.*;
import org.hibernate.validator.Valid;

/*import javax.validation.Valid;*/
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class BalanceDto {
    private String  _id;
    @Valid
    @NotBlank(message = "Account Id is mandatory")
    private String accountId;
    @Valid
    @NotNull(message = "Amount is mandatory")
    @Min(value = 0,message = "Amount shouldn't be lesser than zero")
    private Number amount;
    @Valid
    @NotNull(message = "Currency is mandatory INR/DOLLAR/EURO ")
    private Currency currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
