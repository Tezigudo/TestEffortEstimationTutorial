package functions;

import functions.special.B;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.StrictMath.abs;

import java.util.List;
import static java.lang.StrictMath.pow;

// TODO: Add more complex method, testcase, and log statement afor it

public class Calculator<T> {
    
    protected Double answer;
    protected T tmp;

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator(){
        answer = 0.0;
        tmp = null;
        Car car = Car.TOYOTA;
        car.values();
        logger.info("Calculator is created");
    }
    public static Calculator create(){
        return new Calculator();
    }

    public void power(Double x) {
        logger.info("power method is called");
        if (answer==null) { //ignore
            logger.info("answer is null");
            return;
        }
        logger.info("do power calculation with " + x.toString() + " and " + answer.toString());
        answer = pow(answer, x);
    }
    public T tmp(T t){
        return t;
    }

    public  <R> void plus_renamed (Double x){
        this.answer+=x;
        logger.info("plus method is called");
    }

    public void plus(Double x){
        if(this.isNull(x, answer)){
            logger.info("x or answer is null");
            return;
        }
        logger.info("do plus calculation with " + x.toString() + " and " + answer.toString());
        this.answer+=x;
    }


    public void minus( Double x){
        if(this.isNull(x, answer)){
            logger.info("x or answer is null");
            return;
        }
        logger.info("do minus calculation with " + x.toString() + " and " + answer.toString());
        this.answer-=x;
    }

    public void times ( Double x){
        if(isStaticNull(x, answer)){
            logger.info("x or answer is null");
            return;
        }
        logger.info("do times calculation with " + x.toString() + " and " + answer.toString());
        this.answer*=x;
    }

    public void divided(Double x  ){
        if(Calculator.isStaticNull(x, answer)){
            logger.info("x or answer is null");
            return;
        }
        if (abs(x)<=0.0){
            logger.warn("the number was divided by 0");
            answer = null;
            return;
        }
        logger.info("do divided calculation with " + x.toString() + " and " + answer.toString());
        this.answer/=x;
    }

    public void complex_statement(Double x, Double y){
        if(this.isNull(x, answer)){
            logger.info("x or answer is null");
            return;
        }
        if(this.isNull(y, answer)){
            logger.info("y or answer is null");
            return;
        }
        logger.info("do complex statement calculation with " + x.toString() + " and " + y.toString() + " and " + answer.toString());
        this.answer = pow(answer, x) + pow(answer, y);
    }
    public void aaa1(int i){}
    public void aaa1_1(int i, double j, Double d){}
    public void aaa2(double i){}
    public void aaa3(float i){}
    public void aaa4(boolean i){}
    public void aaa5(short i){}
    public void aaa6(long i){}
    public void aaa7(byte i){}
    public void aaa8(char i){}
    public void aaa9(byte[] i){}
    public void aaa10(Integer[] i){}
    public void aaa11(Integer... i){}
    public void aaa12(Double[][] i){
        SubClass b = new SubClass();
    }


    public void aaa13(){}


    public Double getAnswer()
    {
        logger.info(" getting Answer: {}", answer);
        return answer;
    }
    private boolean isNull(Double x, Double answer) {
        if (x==null|answer==null){
            return true;
        }
        return false;
    }
    public static boolean isStaticNull(Double x, Double answer) {
        if (x==null|answer==null){
            return true;
        }
        return false;
    }
    private void aaa(Double x,
                     Double answer,
                     Double answer1,
                     Double answe4) {
        System.out.println(x+""+answer+""+answer1+""+answe4);
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
    public static class A {
        public static B b;

    }
    public class SubClass{
        public SubClass(){
            ABC a = new ABC();
            SayHello();
        }
        public class ABC{

        }
        public void SayHello(){
            System.out.println("Hello World");
        }
    }

}
