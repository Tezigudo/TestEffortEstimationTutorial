package functions;

import static java.lang.StrictMath.pow;

public class Calculator2 extends Calculator {
    public void power(double x) {
        if (answer==null) return;//ignore
        answer = pow(answer, x);
    }
}
