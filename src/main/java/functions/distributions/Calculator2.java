package functions.distributions;

import functions.ExtraDistributions.CalculatorExtra;
import functions.*;

import static java.lang.StrictMath.pow;

public class Calculator2 extends Calculator {
    public Double getAnswer()
    {
        //This over ride is no use
        return super.getAnswer();
    }
    public static boolean isStaticNull(Double x, Double answer) {
        if (x==null|answer==null){
            return true;
        }
        return false;
    }
    public Double getAttribute()
    {
        return CalculatorExtra.tmpAttribute;
    }
    public static Integer aho(){
        return 1;
    }
}
