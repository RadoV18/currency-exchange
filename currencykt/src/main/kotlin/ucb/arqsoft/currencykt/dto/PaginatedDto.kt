package ucb.arqsoft.currencykt.dto

data class PaginatedDto<T> (
    val data: List<T>?,
    val limit: Int,
    val offset: Int,
    val total: Long
)