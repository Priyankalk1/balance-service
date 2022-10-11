package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import com.maveric.balanceservice.service.BalanceService;
import com.maveric.userservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BalanceController {
    @Autowired
    BalanceService balanceService;

    @Autowired
    BalanceRepository balanceRepository;

    @GetMapping("/accounts/{accountId}/balances")
    public ResponseEntity<List<BalanceDto>> getBalances(@PathVariable String accountId, @RequestParam(defaultValue = "0") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<BalanceDto> balanceDtoResponse = balanceService.getBalances();
        return new ResponseEntity<List<BalanceDto>>(balanceDtoResponse, HttpStatus.OK);
    }

    @PostMapping("/accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> createBalance(@PathVariable String accountId, @RequestBody BalanceDto balanceDto) {
        BalanceDto balanceDtoResponse = balanceService.createBalance(balanceDto);
        return new ResponseEntity<BalanceDto>(balanceDtoResponse, HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<BalanceDto> getBalanceDetails(@PathVariable String accountId,@PathVariable String balanceId) {
        BalanceDto balanceDtoResponse = balanceService.getBalanceDetails(balanceId);
        return new ResponseEntity<BalanceDto>(balanceDtoResponse, HttpStatus.OK);
    }

    @PutMapping("/accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<BalanceDto> updateBalance(@PathVariable String accountId,@PathVariable String balanceId) {
        BalanceDto balanceDtoResponse = balanceService.getBalanceDetails(balanceId);
        return new ResponseEntity<BalanceDto>(balanceDtoResponse, HttpStatus.OK);
    }
    @DeleteMapping("/accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<String> deleteBalance(@PathVariable String accountId,@PathVariable String balanceId) {
        String result = balanceService.deleteBalance(balanceId);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}

