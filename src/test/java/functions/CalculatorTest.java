package functions;

import static functions.distributions.Calculator2.aho;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import functions.distributions.Calculator2;
import functions.distributions.Calculator3;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {

    @Deprecated
    public static void common(){
        Integer i = 0;
        i += 1;
    }

    @Test
    public void testAdd_N001(){
        Calculator calc = new Calculator();
        calc.plus_renamed(1.0);
        assertEquals(calc.getAnswer(), Double.valueOf(1));
        common();
    }

    @Test
    public void testaho_N002(){
        Calculator2 calc2 = new Calculator2();
        assertEquals(aho(), Integer.valueOf(1));
    }

    @Test
    public void testCalc2_N001(){
        Calculator2 calc2 = new Calculator2();
        Double answer = calc2.getAnswer();
        assertEquals(answer, Double.valueOf(0.0));
    }

    @Test
    public void testCalc3_N001(){
        Calculator3 calc3 = new Calculator3();
        Double tmpAtribute = calc3.getAttribute();
        assertEquals(tmpAtribute, Double.valueOf(0.0));
    }

    @Test(expected = AssertionError.class)
    public void testFailure(){
        Calculator3 calc3 = new Calculator3();
        Double tmpAtribute = calc3.getAttribute();
        assertEquals(tmpAtribute, Double.valueOf(100.0));
    }

    @Test
    public void testMinus_N001(){
        Calculator calc = new Calculator();
        calc.minus(1.0);
        assertEquals(calc.getAnswer(), Double.valueOf(-1.0));
        common();
    }

    @Test
    public void testMinus_N002(){
        Calculator calc = new Calculator();
        calc.minus(null);
        assertEquals(calc.getAnswer(), Double.valueOf(0));
    }

    @Test
    public void testMinus_N003(){
        Calculator calc = new Calculator();
        calc.minus(-1.0);
        assertEquals(calc.getAnswer(), Double.valueOf(1.0));
    }

    @Test
    public void testTimes_N001(){
        Calculator calc = new Calculator();
        calc.times(2.0);
        assertEquals(calc.getAnswer(), Double.valueOf(0.0));
    }

    @Test
    public void testTimes_N002(){
        Calculator calc = new Calculator();
        calc.plus(1.0);
        calc.times(2.0);
        assertEquals(calc.getAnswer(), Double.valueOf(2.0));
    }

    @Test
    public void testTimes_N003(){
        Calculator calc = new Calculator();
        calc.plus(1.0);
        calc.times(-2.0);
        assertEquals(calc.getAnswer(), Double.valueOf(-2.0));
    }

    @Test
    public void testTimes_N004(){
        Calculator calc = new Calculator();
        calc.times(null);
        assertEquals(calc.getAnswer(), Double.valueOf(0));
    }

    @Test
    public void testDivided_N001(){
        Calculator calc = new Calculator();
        calc.divided(1.0);
        assertEquals(calc.getAnswer(), Double.valueOf(0));
    }

    @Test
    public void testDivided_N002(){
        Calculator calc = new Calculator();
        calc.divided(null);
        assertEquals(calc.getAnswer(), Double.valueOf(0));
    }

    @Test
    public void testDivided_N003(){
        Calculator calc = new Calculator();
        calc.divided(0.0);
        assertNull(calc.getAnswer());
        aho();
    }

    @Test
    public void testDivided_N004(){
        Calculator calc = new Calculator();
        calc.plus(1.0);
        calc.divided(2.0);
        assertEquals(calc.getAnswer(), Double.valueOf(0.5));
    }

    @Test
    public void testDivided_N005(){
        Calculator calc = new Calculator();
        calc.plus(1.0);
        calc.divided(-2.0);
        assertEquals(calc.getAnswer(), Double.valueOf(-0.5));
    }

    @Test
    public void testLayer_N001(){
        Calculator calc = new Calculator();
        Integer i = calc.Layer1(3);
        assertEquals(i, Integer.valueOf(4));
    }

    @Test
    public void testLayer_N002(){
        Calculator calc = new Calculator();
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        Integer i = calc.Layer1_2(a);
        assertEquals(i, Integer.valueOf(2));
    }

    @Test
    public void testPower_N001(){
        Calculator calc = new Calculator();
        calc.plus(2.0);
        calc.power(2.0);
        assertEquals(calc.getAnswer(), Double.valueOf(4));
    }

    @Test(expected = NullPointerException.class)
    public void testPower_N002(){
        Calculator calc = new Calculator();
        calc.plus(2.0);
        calc.power(null);
        assertEquals(calc.getAnswer(), Double.valueOf(2.0));
    }

    @Test
    public void testPower_N003(){
        Calculator calc = new Calculator();
        calc.plus(2.0);
        calc.power(-2.0);
        assertEquals(calc.getAnswer(), Double.valueOf(0.25));
    }

    @Test
    public void testQuadraticFormula_N001(){
        Calculator calc = new Calculator();
        Double[] roots = calc.quadraticFormula(1.0, -3.0, 2.0);
        assertEquals(roots[0], Double.valueOf(2.0));
        assertEquals(roots[1], Double.valueOf(1.0));
    }

    @Test
    public void testQuadraticFormula_N002(){
        Calculator calc = new Calculator();
        Double[] roots = calc.quadraticFormula(1.0, 2.0, 1.0);
        assertEquals(roots[0], Double.valueOf(-1.0));
        assertEquals(roots[1], Double.valueOf(-1.0));
    }

    @Test
    public void testQuadraticFormula_N003(){
        Calculator calc = new Calculator();
        Double[] roots = calc.quadraticFormula(1.0, 0.0, -1.0);
        assertEquals(roots[0], Double.valueOf(1.0));
        assertEquals(roots[1], Double.valueOf(-1.0));
    }

    @Test
    public void testQuadraticFormula_N004(){
        Calculator calc = new Calculator();
        Double[] roots = calc.quadraticFormula(1.0, 0.0, 1.0);
        assertNull(roots);
    }

    @Test
    public void testQuadraticFormula_N005(){
        Calculator calc = new Calculator();
        Double[] roots = calc.quadraticFormula(0.0, 2.0, 1.0);
        assertNull(roots);
    }


    @Test
    public void testFactorial_N001(){
        Calculator calc = new Calculator();
        Double result = calc.factorial(5.0);
        assertEquals(result, Double.valueOf(120.0));
    }

    @Test
    public void testFactorial_N002(){
        Calculator calc = new Calculator();
        Double result = calc.factorial(0.0);
        assertEquals(result, Double.valueOf(1.0));
    }

    @Test(expected = NullPointerException.class)
    public void testFactorial_N003(){
        Calculator calc = new Calculator();
        Double result = calc.factorial(null);
        assertEquals(result, Double.valueOf(1.0));
    }

    @Test
    public void testFactorial_N004(){
        Calculator calc = new Calculator();
        Double result = calc.factorial(-5.0);
        assertNull(result);
    }

    @Test
    public void testFactorial_N005(){
        Calculator calc = new Calculator();
        Double result = calc.factorial(1.0);
        assertEquals(result, Double.valueOf(1.0));
    }

    @Test
    public void testFibonacci_N001(){
        Calculator calc = new Calculator();
        Double result = calc.fibonacci(10.0);
        assertEquals(result, Double.valueOf(55.0));
    }

    @Test
    public void testFibonacci_N002(){
        Calculator calc = new Calculator();
        Double result = calc.fibonacci(0.0);
        assertEquals(result, Double.valueOf(0.0));
    }

    @Test
    public void testFibonacci_N003(){
        Calculator calc = new Calculator();
        Double result = calc.fibonacci(1.0);
        assertEquals(result, Double.valueOf(1.0));
    }

    @Test
    public void testFibonacci_N004(){
        Calculator calc = new Calculator();
        Double result = calc.fibonacci(-1.0);
        assertNull(result);
    }

    @Test
    public void testIsPrime_N001(){
        Calculator calc = new Calculator();
        Boolean result = calc.isPrime(17.0);
        assertEquals(result, Boolean.TRUE);
    }

    @Test
    public void testIsPrime_N002(){
        Calculator calc = new Calculator();
        Boolean result = calc.isPrime(18.0);
        assertEquals(result, Boolean.FALSE);
    }

    @Test
    public void testIsPrime_N003(){
        Calculator calc = new Calculator();
        Boolean result = calc.isPrime(2.0);
        assertEquals(result, Boolean.TRUE);
    }

    @Test
    public void testIsPrime_N004(){
        Calculator calc = new Calculator();
        Boolean result = calc.isPrime(1.0);
        assertEquals(result, Boolean.FALSE);
    }

    @Test
    public void testIsPrime_N005(){
        Calculator calc = new Calculator();
        Boolean result = calc.isPrime(-17.0);
        assertEquals(result, Boolean.FALSE);
    }

    @Test
    public void testIsPrime_N007(){
        Calculator calc = new Calculator();
        Boolean result = calc.isPrime(0.0);
        assertEquals(result, Boolean.FALSE);
    }

    @Test
    public void testIsPrime_N008(){
        Calculator calc = new Calculator();
        Boolean result = calc.isPrime(19.0);
        assertEquals(result, Boolean.TRUE);
    }
}
