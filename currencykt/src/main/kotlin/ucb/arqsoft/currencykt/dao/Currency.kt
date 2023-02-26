package ucb.arqsoft.currencykt.dao

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "currency")
class Currency (
    var currencyFrom: String,
    var currencyTo: String,
    var amount: BigDecimal,
    var result: BigDecimal,
    @Id
    @GeneratedValue
    var id: Long = 0
) {
    constructor() : this("", "", BigDecimal.ZERO, BigDecimal.ZERO)
}