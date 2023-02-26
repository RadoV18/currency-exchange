package ucb.arqsoft.currencykt.bl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ucb.arqsoft.currencykt.dao.Currency
import ucb.arqsoft.currencykt.dao.repository.CurrencyRepository
import ucb.arqsoft.currencykt.dto.ExchangeDto
import ucb.arqsoft.currencykt.exception.ServiceException
import java.math.BigDecimal
@Service
class CurrencyBl {

    @Value("\${api.key}")
    private lateinit var apiKey: String;
    private val logger: Logger = LoggerFactory.getLogger(CurrencyBl::class.java)
    @Autowired
    private lateinit var currencyRepository : CurrencyRepository;

    fun exchangeRate(amount: BigDecimal, from: String, to: String): ExchangeDto {
        if(amount < BigDecimal.ZERO) {
            logger.error("Amount must be greater than zero");
            throw IllegalArgumentException("Amount must be greater than zero");
        }

        val client = OkHttpClient();

        val request: Request = Request.Builder()
            .url(
                "https://api.apilayer.com/exchangerates_data/convert?" +
                        "&from=$from" +
                        "&to=$to" +
                        "&amount=$amount"
            )
            .addHeader("apikey", apiKey)
            .build();

        try {
            logger.info("Calling external service");
            val response = client.newCall(request).execute();

            if(!response.isSuccessful) {
                throw Exception("Error calling external service");
            }

            logger.info("Parsing response");
            val body = response.body?.string();

            val objectMapper = jacksonObjectMapper();
            val dto = objectMapper.readValue(body, ExchangeDto::class.java)
            val currency = Currency(
                currencyFrom = from,
                currencyTo = to,
                amount = amount,
                result = dto.result
            )
            logger.info("Saving response in database");
            currencyRepository.save(currency);
            logger.info("Response saved.");
            return dto;
        } catch (e: Exception) {
            logger.error("Error calling external service");
            throw ServiceException("Error calling external service");
        }
    }
}
