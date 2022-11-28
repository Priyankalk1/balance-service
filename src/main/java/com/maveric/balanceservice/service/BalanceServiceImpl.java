package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.BalanceAlreadyExistException;
import com.maveric.balanceservice.exception.BalanceNotFoundException;
import com.maveric.balanceservice.mapper.BalanceMapper;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import static com.maveric.balanceservice.constants.Constants.*;

@Service
public class BalanceServiceImpl implements BalanceService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BalanceServiceImpl.class);
    @Autowired
    private BalanceRepository repository;

    @Autowired
    private BalanceMapper mapper;


    @Override
    public BalanceDto getBalanceByAccountId(String accountId) {

        Balance balanceResult = repository.findByAccountId(accountId);
        if (balanceResult != null)
        {
            log.info("Retrieved Balance details for given Account Id");
            return mapper.map(balanceResult);
        }
        else
        {
            log.info("Balance not found for given Account Id returns Empty Balance details");
            return new BalanceDto();
        }
    }

    public BalanceDto createBalance(String accountId, BalanceDto balanceDto) {
        if (accountId.equals(balanceDto.getAccountId())) {
            if(repository.findByAccountId(accountId)==null) {
                balanceDto.setCreatedAt(getCurrentDateTime());
                balanceDto.setUpdatedAt(getCurrentDateTime());
                Balance balance = mapper.map(balanceDto);
                Balance balanceResult = repository.save(balance);
                log.error("Created new Balance successfully");
                return mapper.map(balanceResult);
            }
            else {
                log.error("Balance Already Exist for this Account Id");
                throw new BalanceAlreadyExistException("Balance already exists for this Account Id-"+balanceDto.getAccountId());
            }
        } else {
            log.error("Account Id not found! Cannot create balance.");
            throw new BalanceNotFoundException("Account Id not found! Cannot create balance.");
        }
    }

    @Override
    public BalanceDto getBalanceDetails(String accountId,String balanceId) {
        log.info("Retrieved list of Balance details for given Balance Id");
        Balance balanceResult = repository.findById(balanceId).orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
        return mapper.map(balanceResult);
    }

    @Override
    public String deleteBalance(String balanceId) {
        if(repository.findById(balanceId).isEmpty())
        {
            log.info("Balance Id does not exist! Cannot delete Balance details.");
            throw new BalanceNotFoundException(BALANCE_NOT_FOUND_MESSAGE+balanceId);
        }
        repository.deleteById(balanceId);
        log.info("Deleted Balance details for given Balance Id");
        return BALANCE_DELETED_SUCCESS;
    }
    @Override
    public String deleteBalanceByAccountId(String accountId) {
        repository.deleteByAccountId(accountId);
        return BALANCE_DELETED_SUCCESS;
    }

    @Override
    public BalanceDto updateBalance(String accountId, String balanceId, BalanceDto balanceDto) {
        if (accountId.equals(balanceDto.getAccountId())) {
            Balance balanceResult = repository.findById(balanceId).orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
            balanceResult.set_id(balanceResult.get_id());
            balanceResult.setAmount(balanceDto.getAmount());
            balanceResult.setCurrency(balanceDto.getCurrency());
            balanceResult.setAccountId(balanceResult.getAccountId());
            balanceResult.setCreatedAt(balanceResult.getCreatedAt());
            balanceResult.setUpdatedAt(getCurrentDateTime());
            Balance accountUpdated = repository.save(balanceResult);
            log.info("Balance details Updated Successfully for given Balance Id");
            return mapper.map(accountUpdated);
        } else {
            log.error("Account Id not found! Cannot Update Balance");
            throw new BalanceNotFoundException("Account Id not found! Cannot Update Balance");
        }
    }
}
