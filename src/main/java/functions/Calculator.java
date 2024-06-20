package functions;

import functions.special.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.pow;

import java.util.List;

public class Calculator<T> {

    protected Double answer;
    protected T tmp;

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public Calculator(){
        answer = 0.0;
        tmp = null;
        logger.info("Calculator is created");
    }

    public static Calculator create(){
        return new Calculator();
    }

    public void power(Double x) {

        if (answer == null) {
            return;
        }
        logger.info("do power calculation with " + x.toString() + " and " + answer.toString());
        answer = pow(answer, x);
    }

    public T tmp(T t){
        return t;
    }

    public <R> void plus_renamed(Double x){
        this.answer += x;
        logger.info("plus method is called");
    }

    public void plus(Double x){
        if (this.isNull(x, answer)){
            logger.info("x or answer is null");
            return;
        }
        logger.info("do plus calculation with " + x.toString() + " and " + answer.toString());
        this.answer += x;
    }

    public void minus(Double x){
        if (this.isNull(x, answer)){
            return;
        }
        logger.info("do minus calculation with " + x.toString() + " and " + answer.toString());
        this.answer -= x;
    }

    public void times(Double x){
        if (isStaticNull(x, answer)){
            return;
        }
        logger.info("do times calculation with " + x.toString() + " and " + answer.toString());
        this.answer *= x;
    }

    public void divided(Double x){
        if (Calculator.isStaticNull(x, answer)){
            return;
        }
        if (abs(x) <= 0.0){
            logger.warn("the number was divided by 0");
            answer = null;
            return;
        }
        logger.info("do divided calculation with " + x.toString() + " and " + answer.toString());
        this.answer /= x;
    }


    public Double[] quadraticFormula(Double a, Double b, Double c) {
        logger.info("quadraticFormula method is called with a={}, b={}, c={}", a, b, c);
        if (a == 0) {
            logger.error("a cannot be 0 in a quadratic equation");
            return null;
        }
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            logger.error("Discriminant is negative, no real roots");
            return null;
        }
        double sqrtDiscriminant = Math.sqrt(discriminant);
        Double[] roots = new Double[2];
        roots[0] = (-b + sqrtDiscriminant) / (2 * a);
        roots[1] = (-b - sqrtDiscriminant) / (2 * a);
        logger.info("Quadratic formula results: root1={}, root2={}", roots[0], roots[1]);
        return roots;
    }

    // Method to calculate the factorial of a number
    public Double factorial(Double n) {
        logger.info("factorial method is called with n={}", n);
        if (n < 0) {
            logger.error("Factorial is not defined for negative numbers");
            return null;
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        logger.info("Factorial of {} is {}", n, result);
        return result;
    }

    // Method to calculate the nth Fibonacci number
    public Double fibonacci(Double n) {
        logger.info("fibonacci method is called with n={}", n);
        if (n < 0) {
            logger.error("Fibonacci is not defined for negative numbers");
            return null;
        }

        double a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        Double result = n == 0 ? a : b;
        logger.info("Fibonacci number at position {} is {}", n, result);
        return result;
    }

    // Method to check if a number is prime
    public Boolean isPrime(Double n) {
        logger.info("isPrime method is called with n={}", n);
        if (n < 2) {
            logger.info("{} is not prime", n);
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                logger.info("{} is not prime", n);
                return false;
            }
        }
        logger.info("{} is prime", n);
        return true;
    }


    public Double getAnswer() {
        logger.info(" getting Answer: {}", answer);
        return answer;
    }

    private boolean isNull(Double x, Double answer) {
        return x == null || answer == null;
    }

    public static boolean isStaticNull(Double x, Double answer) {
        return x == null || answer == null;
    }

    public Integer Layer1(Integer a){
        long ii = B.i;
        long iii = functions.special.B.i;
        Integer j = B.Layer2_RENAME(a);
        return j;
    }

    public Integer Layer1_2(List<Integer> i){
        Integer j = B.Layer2_2(i);
        return j;
    }

    public static void main(String[] args){
        Calculator calc = new Calculator();
        calc.plus_renamed(1.0);
        System.out.println(calc.getAnswer());
        String a = "/Users/yutarokashiwa/.m2/repository/org/opentest4j/opentest4j/1.1.1/opentest4j-1.1.1.jar,org/opentest4j/AssertionFailedError,org/opentest4j/AssertionFailedError,Normal,5c926c86eeaa81c12cd59061b6a0d03afd5a2f21";
        if(a.contains("/.m2/")){
            System.out.println("YES");
        }
    }
}
