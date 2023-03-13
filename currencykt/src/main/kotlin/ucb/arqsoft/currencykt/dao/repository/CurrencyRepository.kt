package ucb.arqsoft.currencykt.dao.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import ucb.arqsoft.currencykt.dao.Currency

interface CurrencyRepository: CrudRepository<Currency, Long> {
    override fun <S : Currency> save(entity: S): S

    @Query("""
        SELECT c FROM Currency c
        WHERE
            (:from IS NULL OR c.currencyFrom = :from) AND
            (:to IS NULL OR c.currencyTo = :to)
        ORDER BY
            CASE WHEN :sortBy = 'requestDate' AND :sortOrder = 'asc' THEN c.requestDate END ASC,
            CASE WHEN :sortBy = 'requestDate' AND :sortOrder = 'desc' THEN c.requestDate END DESC,
            CASE WHEN :sortBy = 'amount' AND :sortOrder = 'asc' THEN c.amount END ASC,
            CASE WHEN :sortBy = 'amount' AND :sortOrder = 'desc' THEN c.amount END DESC,
            CASE WHEN :sortBy = 'result' AND :sortOrder = 'asc' THEN c.result END ASC,
            CASE WHEN :sortBy = 'result' AND :sortOrder = 'desc' THEN c.result END DESC
        LIMIT :limit OFFSET :offset
    """)
    fun findAllWithLimitAndOffset(
        @Param("limit") limit: Int,
        @Param("offset") offset: Int,
        @Param("from") from: String?,
        @Param("to") to: String?,
        @Param("sortBy") sortBy: String?,
        @Param("sortOrder") sortOrder: String?
    ): List<Currency>
}