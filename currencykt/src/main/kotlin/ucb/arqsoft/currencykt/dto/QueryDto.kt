package ucb.arqsoft.currencykt.dto

import java.math.BigDecimal

data class QueryDto (
    val from: String,
    val to: String,
    val amount: BigDecimal
)