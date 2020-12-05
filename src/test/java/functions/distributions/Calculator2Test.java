package functions.distributions;
import functions.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculator2Test {
    String a;
    Calculator2Test(){
        super();
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }
    @BeforeAll
    public static void  beforeEach(){
        System.out.println("beforeEach");

    }
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");

    }
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");

    }

    @Test
    public void special_N001(){
        Calculator.A.b.echo();
    }
    @Test
    public void all(){
        Calculator c = new Calculator();
        c.aaa1(1);
        c.aaa1_1(1, 1, 1.0);
        c.aaa2(1);
        c.aaa3(1);
        c.aaa4(false);
        c.aaa5((short) 1);
        c.aaa6(1);
        c.aaa7("a".getBytes()[0]);
        c.aaa8('1');
        c.aaa9("a".getBytes());
        c.aaa10(new Integer[2]);
        c.aaa11(new Integer[2]);
        c.aaa12(null);


    }

}
