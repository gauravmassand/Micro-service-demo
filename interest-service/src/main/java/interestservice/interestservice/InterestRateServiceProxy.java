package interestservice.interestservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="loan-service",url="localhost:8000")
public interface InterestRateServiceProxy {
    @GetMapping("getLoanDetailsFor/{city}")
    public InterestVO calculateInterest(
            @PathVariable("city") String city);

}
