package ucb.arqsoft.currency.dto;

import java.math.BigDecimal;

public class QueryDto {

    private String from;
    private String to;
    private BigDecimal amount;

    public QueryDto() {
    }

    public QueryDto(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "QueryDto [from=" + from + ", to=" + to + ", amount=" + amount + "]";
    }

}
