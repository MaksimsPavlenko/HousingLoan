package root.calculation.utils;

public class CalculationUtils {

    public static double yearRateToMonthRate(double rate){
        return rate / 12 / 100;
    }

    public static double getPositiveNumber(double number){
        return Math.abs(number);
    }

}
