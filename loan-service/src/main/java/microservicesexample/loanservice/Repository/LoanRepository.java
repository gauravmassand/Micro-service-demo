package microservicesexample.loanservice.Repository;

import microservicesexample.loanservice.entitiy.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    Loan findByCity(String city);
}
