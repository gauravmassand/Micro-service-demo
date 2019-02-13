package interestservice.interestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class InterestController {

    @Autowired InterestRateServiceProxy interestRateServiceProxy;

    @GetMapping("calculateInterestRateFor/{city}/interestRate/{interestRate}")
    public InterestVO calculateInterest(@PathVariable("city") String city,
                                        @PathVariable("interestRate") BigDecimal interestRate) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("city", city);
        ResponseEntity<InterestVO> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/getLoanDetailsFor/{city}",InterestVO.class,pathVariables);
        InterestVO response = responseEntity.getBody();
        return new InterestVO(response.getId(),response.getCity(),response.getCurrentRate(),interestRate.multiply(response.getCurrentRate()),response.getPort());

    }

    @GetMapping("calculateInterestRateFeignFor/{city}/interestRate/{interestRate}")
    public InterestVO calculateInterestFeign(@PathVariable("city") String city,
                                             @PathVariable("interestRate") BigDecimal interestRate) {
        InterestVO response = interestRateServiceProxy.calculateInterest(city);
        return  new InterestVO(response.getId(),response.getCity(),response.getCurrentRate(),interestRate.multiply(response.getCurrentRate()),response.getPort());
    }

}
