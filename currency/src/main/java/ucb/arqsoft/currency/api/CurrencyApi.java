package ucb.arqsoft.currency.api;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ucb.arqsoft.currency.bl.CurrencyBl;
import ucb.arqsoft.currency.dto.ExchangeDto;
import ucb.arqsoft.currency.dto.ResponseDto;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyApi {

    private static Logger logger = LoggerFactory.getLogger(CurrencyApi.class);
    private CurrencyBl currencyBl;

    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping
    public ResponseEntity<ResponseDto<ExchangeDto>> getExchange(
        @RequestParam String from,
        @RequestParam String to,
        @RequestParam BigDecimal amount
    ) {
        logger.info("GET: Exchange " +  amount + " " + from + " to " + to);
        logger.info("Starting business logic");
        ExchangeDto exchangeDto = currencyBl.exchange(from, to, amount);
        ResponseDto<ExchangeDto> responseDto = new ResponseDto<ExchangeDto>(exchangeDto, true, null);
        logger.info("Sending response");
        return ResponseEntity.ok(responseDto);
    }

}
