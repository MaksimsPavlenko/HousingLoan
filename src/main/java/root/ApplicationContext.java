package root;

import root.calculation.strategy.HousingLoanCalculationStrategy;
import root.calculation.strategy.LoanCalculationStrategy;
import root.loan.LoanType;

import java.util.HashMap;
import java.util.Map;

import static root.loan.LoanType.HOUSING;

public class ApplicationContext {

    Map<LoanType, LoanCalculationStrategy> calculationStrategyForLoanType;

    public ApplicationContext() {
        calculationStrategyForLoanType = new HashMap<>();
        calculationStrategyForLoanType.put(HOUSING, new HousingLoanCalculationStrategy());
    }

    public Map<LoanType, LoanCalculationStrategy> getCalculationStrategyForLoanType() {
        return calculationStrategyForLoanType;
    }
}
