package com.maveric.balanceservice.service;

import com.maveric.balanceservice.dto.BalanceDto;
import com.maveric.balanceservice.exception.BalanceNotFoundException;
import com.maveric.balanceservice.model.Balance;
import com.maveric.balanceservice.repository.BalanceRepository;
import com.maveric.userservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.maveric.balanceservice.constants.Constants.getCurrentDateTime;
import static com.maveric.balanceservice.util.ModelDtoTransformer.toDto;
import static com.maveric.balanceservice.util.ModelDtoTransformer.toEntity;

@Service
public class BalanceServiceImpl implements BalanceService{
    @Autowired
    private BalanceRepository balanceRepository;


    @Override
    public List<BalanceDto> getBalances() {
        List<Balance> list= balanceRepository.findAll();
        List<BalanceDto> listDto = new ArrayList<BalanceDto>(list.size());
        for(Balance balance:list)
        {
            listDto.add(toDto(balance));
        }
        return listDto;
    }

    @Override
    public BalanceDto createBalance(BalanceDto balanceDto) {
        balanceDto.setCreatedAt(getCurrentDateTime());
        balanceDto.setUpdatedAt(getCurrentDateTime());
        Balance balance = toEntity(balanceDto);
        Balance balanceResult = balanceRepository.save(balance);
        return  toDto(balanceResult);
    }

    @Override
    public BalanceDto getBalanceDetails(String balanceId) {
        Balance balanceResult=balanceRepository.findById(Integer.valueOf(balanceId)).orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
        return toDto(balanceResult);
    }

    @Override
    public Balance updateBalance(String balanceId) {
            Balance balance = balanceRepository.findById(Integer.valueOf(balanceId))
                    .orElseThrow(() -> new ResourceNotFoundException(Integer.valueOf(balanceId)));

            balance.setId(balance.getId());
            balance.setAmount(balance.getAmount());
            balance.setCurrency(balance.getCurrency());
            balance.setCreatedAt(balance.getCreatedAt());
           balance.setUpdatedAt(balance.getUpdatedAt());
            return balanceRepository.save(balance);
        }

    @Override
    public String deleteBalance(String balanceId) {
        balanceRepository.deleteById(Integer.valueOf(balanceId));
        return "balance deleted successfully.";
    }
}
