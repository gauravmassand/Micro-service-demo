package microservicesexample.loanservice.controller;

import microservicesexample.loanservice.Repository.LoanRepository;
import microservicesexample.loanservice.entitiy.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private Environment environment;

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/getLoanDetailsFor/{city}")
    public Loan getCurrentLoanDetails(@PathVariable("city") String city) {
        Loan loanDetails = loanRepository.findByCity(city);
        loanDetails.setPort(Integer.parseInt(environment.getProperty("server.port")));
        return loanDetails;
    }
}
