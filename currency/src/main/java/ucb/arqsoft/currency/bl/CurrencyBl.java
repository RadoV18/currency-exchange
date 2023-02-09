package ucb.arqsoft.currency.bl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ucb.arqsoft.currency.dto.ExchangeDto;
import ucb.arqsoft.currency.exception.ServiceException;

@Service
public class CurrencyBl {

    @Value("${api.key}")
    private String apiKey;
    Logger logger = LoggerFactory.getLogger(CurrencyBl.class);
    
    public ExchangeDto exchange(String from, String to, BigDecimal amount) {
        // Check if the amount is greater than zero
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount must be greater than zero");
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?" +
                        "&from=" + from +
                        "&to=" + to +
                        "&amount=" + amount
                )
                .addHeader("apikey", apiKey)
                .build();

        try {
            logger.info("Calling the external service");
            Response response = client.newCall(request).execute();

            if(!response.isSuccessful()) {
                throw new ServiceException("Error while calling the external service");
            }

            logger.info("Parsing the response");
            // TODO: parse the response
        } catch (Exception e) {
            throw new ServiceException("Error while calling the external service");
        }
        
        return new ExchangeDto();
    }
}
