package ucb.arqsoft.currencykt.dao.repository

import org.springframework.data.repository.CrudRepository
import ucb.arqsoft.currencykt.dao.Currency

interface CurrencyRepository: CrudRepository<Currency, Long> {
    override fun <S : Currency> save(entity: S): S
}