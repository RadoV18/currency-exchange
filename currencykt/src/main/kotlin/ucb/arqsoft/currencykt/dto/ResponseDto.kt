package ucb.arqsoft.currencykt.dto

data class ResponseDto<T>(
    val data: T?,
    val message: String,
    val successful: Boolean
)