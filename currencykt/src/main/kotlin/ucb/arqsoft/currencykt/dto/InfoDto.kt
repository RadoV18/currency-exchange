package ucb.arqsoft.currencykt.dto

import java.math.BigDecimal
import java.math.BigInteger

data class InfoDto (
    val timestamp: BigInteger,
    val rate: BigDecimal
)