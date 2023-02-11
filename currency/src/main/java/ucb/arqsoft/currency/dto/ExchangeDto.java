package ucb.arqsoft.currency.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeDto {

    private QueryDto query;
    private InfoDto info;
    private BigDecimal result;

    public ExchangeDto() {
    }

    public ExchangeDto(QueryDto query, InfoDto info, BigDecimal result) {
        this.query = query;
        this.info = info;
        this.result = result;
    }

    public QueryDto getQuery() {
        return query;
    }

    public void setQuery(QueryDto query) {
        this.query = query;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ExchangeDto [query=" + query + ", info=" + info + ", result=" + result + "]";
    }
}
