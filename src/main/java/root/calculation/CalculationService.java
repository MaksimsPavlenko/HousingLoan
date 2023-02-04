package root.calculation;

import root.calculation.response.LoanCalculationResponse;
import root.calculation.strategy.LoanCalculationStrategy;
import root.loan.Loan;
import root.loan.LoanType;

import java.util.Map;

public class CalculationService {

    Map<LoanType, LoanCalculationStrategy> calculationStrategyForLoanType;

    public CalculationService(Map<LoanType, LoanCalculationStrategy> calculationStrategyForLoanType) {
        this.calculationStrategyForLoanType = calculationStrategyForLoanType;
    }

    public LoanCalculationResponse getLoanCalculation(Loan loan){
        return calculationStrategyForLoanType.get(loan.getLoanType()).calculateLoan(loan);
    }
}
