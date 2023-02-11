package ucb.arqsoft.currencykt.bl

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CurrencyBl {

    private val logger: Logger = LoggerFactory.getLogger(CurrencyBl::class.java)

    fun exchangeRate(amount: BigDecimal, from: String, to: String) {
        if(amount < BigDecimal.ZERO) {
            logger.error("Amount must be greater than zero");
            throw IllegalArgumentException("Amount must be greater than zero");
        }
    }
}