package ucb.arqsoft.currency.bl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import ucb.arqsoft.currency.dto.ExchangeDto;

@Service
public class CurrencyBl {
    
    public ExchangeDto exchange(String from, String to, BigDecimal amount) {
        // Check if the amount is greater than zero
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount must be greater than zero");
        }

        return new ExchangeDto();
    }
}
