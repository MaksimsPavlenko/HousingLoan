package loan;

import root.calculation.CalculationService;
import root.calculation.response.LoanCalculationResponse;
import root.ApplicationContext;
import org.junit.Test;
import root.loan.HousingLoan;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class HousingLoanTest {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final ApplicationContext applicationContext = new ApplicationContext();

    CalculationService calculationService =
            new CalculationService(applicationContext.getCalculationStrategyForLoanType());

    @Test
    public void calculateHousingLoanTest(){
        int loanPeriod = 5;
        double rate = 5.50;
        double loanAmount = 5000.0;

        HousingLoan housingLoan = new HousingLoan(loanAmount,rate,loanPeriod);
        LoanCalculationResponse r = calculationService.getLoanCalculation(housingLoan);

        assertEquals(60, r.getResponses().size());

        assertEquals(df.format(1), df.format(r.getResponses().get(0).getPeriod()));
        assertEquals(df.format(5000), df.format(r.getResponses().get(0).getBeginningBalance()));
        assertEquals(df.format(95.51), df.format(r.getResponses().get(0).getPayment()));
        assertEquals(df.format(72.59), df.format(r.getResponses().get(0).getLoanRepayment()));
        assertEquals(df.format(22.92), df.format(r.getResponses().get(0).getInterestPayment()));
        assertEquals(df.format(4927.41), df.format(r.getResponses().get(0).getEndingBalance()));

        int lastElem = r.getResponses().size() - 1;
        assertEquals(df.format(60), df.format(r.getResponses().get(lastElem).getPeriod()));
        assertEquals(df.format(95.07), df.format(r.getResponses().get(lastElem).getBeginningBalance()));
        assertEquals(df.format(95.51), df.format(r.getResponses().get(lastElem).getPayment()));
        assertEquals(df.format(95.07), df.format(r.getResponses().get(lastElem).getLoanRepayment()));
        assertEquals(df.format(0.44), df.format(r.getResponses().get(lastElem).getInterestPayment()));
        assertEquals(df.format(0.00), df.format(r.getResponses().get(lastElem).getEndingBalance()));

        int loanPeriod2 = 12;
        double rate2 = 3.50;
        double loanAmount2 = 100000.0;

        HousingLoan housingLoan2 = new HousingLoan(loanAmount2,rate2,loanPeriod2);
        LoanCalculationResponse r2 = calculationService.getLoanCalculation(housingLoan2);

        assertEquals(144, r2.getResponses().size());

        assertEquals(df.format(1), df.format(r2.getResponses().get(0).getPeriod()));
        assertEquals(df.format(100000), df.format(r2.getResponses().get(0).getBeginningBalance()));
        assertEquals(df.format(851.45), df.format(r2.getResponses().get(0).getPayment()));
        assertEquals(df.format(559.79), df.format(r2.getResponses().get(0).getLoanRepayment()));
        assertEquals(df.format(291.67), df.format(r2.getResponses().get(0).getInterestPayment()));
        assertEquals(df.format(99440.21), df.format(r2.getResponses().get(0).getEndingBalance()));

        int lastElem2 = r2.getResponses().size() - 1;
        assertEquals(df.format(144), df.format(r2.getResponses().get(lastElem2).getPeriod()));
        assertEquals(df.format(848.98), df.format(r2.getResponses().get(lastElem2).getBeginningBalance()));
        assertEquals(df.format(851.45), df.format(r2.getResponses().get(lastElem2).getPayment()));
        assertEquals(df.format(848.98), df.format(r2.getResponses().get(lastElem2).getLoanRepayment()));
        assertEquals(df.format(2.48), df.format(r2.getResponses().get(lastElem2).getInterestPayment()));
        assertEquals(df.format(0.00), df.format(r2.getResponses().get(lastElem2).getEndingBalance()));
    }
}