package ucb.arqsoft.currencykt.api

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ucb.arqsoft.currencykt.bl.CurrencyBl
import java.math.BigDecimal

@RestController
@RequestMapping("/api/v1/currency")
class CurrencyApi (private val currencyBl: CurrencyBl) {

    private val logger: Logger = LoggerFactory.getLogger(CurrencyApi::class.java)

    @GetMapping
    fun getCurrency(
        @RequestParam from: String,
        @RequestParam to: String,
        @RequestParam amount: BigDecimal
    ): String {
        logger.info("GET: Exchange $amount from $from to $to");
        logger.info("Starting business logic");
        currencyBl.exchangeRate(amount, from, to);
        return "Hello World";
    }
}