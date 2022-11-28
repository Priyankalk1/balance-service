package com.maveric.balanceservice.controller;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.service.BalanceService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class BalanceController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BalanceController.class);
    @Autowired
    BalanceService balanceService;

    /* Returns the User Balance details*/
    @GetMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> getBalances(@PathVariable String accountId) {
        BalanceDto balanceDtoResponse = balanceService.getBalanceByAccountId(accountId);
        log.info("API call returning Balance details for given Account Id");
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
    }

    /* Saving the balance details by accountId */
    @PostMapping("accounts/{accountId}/balances")
    public ResponseEntity<BalanceDto> createBalance(@PathVariable String accountId,@Valid @RequestBody BalanceDto balanceDto) {
        log.info("API call to create a new Balance for given Account Id");
        BalanceDto balanceDtoResponse = balanceService.createBalance(accountId,balanceDto);
        log.info("New Balance Created successfully");
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.CREATED);
    }
    /* Returns the balance amount by balanceId */
    @GetMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<String> getBalanceDetails(@PathVariable String accountId,@PathVariable String balanceId) {
        log.info("API call returning balance for the given valid Account Id");
        BalanceDto balanceDtoResponse = balanceService.getBalanceDetails(accountId,balanceId);
        return new ResponseEntity<>(String.valueOf(balanceDtoResponse.getAmount()), HttpStatus.OK);
    }

    /* Update Balance details by balanceId */
    @PutMapping("accounts/{accountId}/balances/{balanceId}")
    public ResponseEntity<BalanceDto> updateBalance(@PathVariable String accountId,@PathVariable String balanceId,@Valid @RequestBody BalanceDto balanceDto) {
        log.info("API call to Update Balance for valid Balance Id");
        BalanceDto balanceDtoResponse = balanceService.updateBalance(accountId,balanceId,balanceDto);
        log.info("Balance Updated successfully");
        return new ResponseEntity<>(balanceDtoResponse, HttpStatus.OK);
    }
    /* Delete Balance details by balanceId */
    @DeleteMapping("accounts/{accountId}/balances/{balancesId}")
    public ResponseEntity<String> deleteBalance(@PathVariable String accountId,@PathVariable String balancesId) {
        String result = balanceService.deleteBalance(balancesId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /* Delete Balance details by accountId */
    @DeleteMapping("accounts/{accountId}/balances")
    public ResponseEntity<String> deleteBalance(@PathVariable String accountId) {
        log.info("API call to delete balance based on Account Id");
        String result = balanceService.deleteBalanceByAccountId(accountId);
        log.info("Balance deleted successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
