package functions.distributions;

import functions.Calculator;

import static java.lang.StrictMath.pow;

public class Calculator3 extends Calculator {
    public static TmpAttribute tmpAttribute = new TmpAttribute();
    public Double getAnswer()
    {
        //This over ride is no use
        return super.getAnswer();
    }

    public static Double getAttribute()
    {
        return tmpAttribute.getTmpAttribute();
    }
}
