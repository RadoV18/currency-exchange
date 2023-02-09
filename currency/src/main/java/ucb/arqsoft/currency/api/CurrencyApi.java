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
    public ResponseEntity<ResponseDto<Void>> getExchange(
        @RequestParam String from,
        @RequestParam String to,
        @RequestParam BigDecimal amount
    ) {
        logger.info("GET: Exchange " +  amount + " " + from + " to " + to);
        logger.info("Starting business logic");
        currencyBl.exchange(from, to, amount);
        return ResponseEntity.ok(new ResponseDto<Void>());
    }

}
