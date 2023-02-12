package ucb.arqsoft.currencykt.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExchangeDto (
    val query: QueryDto,
    val info: InfoDto,
    val result: BigDecimal
)