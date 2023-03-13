package ucb.arqsoft.currencykt.api

import okhttp3.internal.connection.Exchange
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import ucb.arqsoft.currencykt.bl.CurrencyBl
import ucb.arqsoft.currencykt.dto.ExchangeDto
import ucb.arqsoft.currencykt.dto.PaginatedDto
import ucb.arqsoft.currencykt.dto.ResponseDto
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
    ): ResponseEntity<ResponseDto<ExchangeDto>> {
        logger.info("GET: Exchange $amount from $from to $to");
        logger.info("Starting business logic");
        val exchangeDto = currencyBl.exchangeRate(amount, from, to);

        return ResponseEntity.ok(
            ResponseDto(
                data = exchangeDto,
                message = "Success",
                successful = true
            )
        );
    }

    @GetMapping("/all")
    fun getAllExchanges(
        @RequestParam limit: Int,
        @RequestParam offset: Int,
        @RequestParam requestParams: Map<String, String>
    ): ResponseEntity<ResponseDto<PaginatedDto<ExchangeDto>>> {
        logger.info("GET: $limit exchanges starting from $offset");
        val paginatedExchangeDto: PaginatedDto<ExchangeDto> =
            currencyBl.getExchangeList(limit, offset, requestParams);
        logger.info("Sending response");
        return ResponseEntity.ok(
            ResponseDto(
                data = paginatedExchangeDto,
                message = "Success",
                successful = true
            )
        )
    }

}