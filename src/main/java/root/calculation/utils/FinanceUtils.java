package root.calculation.utils;

import static org.apache.poi.ss.formula.functions.Finance.ipmt;
import static org.apache.poi.ss.formula.functions.Finance.ppmt;


public class FinanceUtils {

    /**
    Rate   Required. The interest rate per period.

    Per    Required. Specifies the period and must be in the range 1 to nper.

    Nper   Required. The total number of payment periods in an annuity.

    Pv     Required. The present value — the total amount that a series of future payments is worth now.

    Fv     Optional. The future value, or a cash balance you want to attain after the last payment is made.
           If fv is omitted, it is assumed to be 0 (zero), that is, the future value of a loan is 0.

    Type   Optional. The number 0 or 1 and indicates when payments are due.
    */

    public static double getLoanRepayment(Double rate, Integer per, Integer nPer, Double pv, Double fv, Integer type){
        return ppmt(rate, per, nPer, pv, fv, type);
    }

    public static double getInterestPayment(Double rate, Integer per, Integer nPer, Double pv, Double fv, Integer type){
        return ipmt(rate, per, nPer, pv, fv, type);
    }

    public static double getPayment(Double rate, Integer per, Integer nPer, Double pv, Double fv, Integer type){
        return getLoanRepayment(rate, per, nPer, pv, fv, type) + getInterestPayment(rate, per, nPer, pv, fv, type);
    }
}
