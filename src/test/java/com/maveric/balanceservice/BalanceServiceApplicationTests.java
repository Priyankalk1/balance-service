package com.maveric.balanceservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.enumeration.Currency;
import com.maveric.balanceservice.model.Balance;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public
class BalanceServiceApplicationTests {

	public static final String APIV1 ="/api/v1/accounts/123/balances";

	@Test
	void contextLoads() {
		assertTrue(true);
	}
	public static BalanceDto getBalanceDto()
	{
		return  BalanceDto.builder()
				._id("1")
				.accountId("123")
				.amount(2000)
				.currency(Currency.INR)
				.build();
	}
	public static Balance getBalance()
	{
		return  Balance.builder()
				._id("1")
				.accountId("123")
				.amount(2000)
				.currency(Currency.INR)
				.build();
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
