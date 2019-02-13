package microservicesexample.loanservice.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "loan_details")
public class Loan {

    public Loan() {
    }

    @Id
    private Long Id;

    @Column(name = "city")
    private String city;

    @Column(name = "current_rate")
    private BigDecimal currentRate;

    private int port;

    public Loan(Long id, String city, BigDecimal currentRate, int port) {
        Id = id;
        this.city = city;
        this.currentRate = currentRate;
        this.port = port;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
