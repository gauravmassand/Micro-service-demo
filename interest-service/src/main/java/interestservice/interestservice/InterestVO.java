package interestservice.interestservice;

import java.math.BigDecimal;

public class InterestVO {

    private Long id;
    private String city;

    public InterestVO() {
    }

    private BigDecimal currentRate;

    public InterestVO(Long id, String city, BigDecimal currentRate, BigDecimal calculatedRate, int port) {
        this.id = id;
        this.city = city;
        this.currentRate = currentRate;
        this.calculatedRate = calculatedRate;
        this.port = port;
    }

    private BigDecimal calculatedRate;
    private int port;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(BigDecimal currentRate) {
        this.currentRate = currentRate;
    }

    public BigDecimal getCalculatedRate() {
        return calculatedRate;
    }

    public void setCalculatedRate(BigDecimal calculatedRate) {
        this.calculatedRate = calculatedRate;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
