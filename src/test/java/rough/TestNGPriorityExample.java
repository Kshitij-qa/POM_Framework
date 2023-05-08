package rough;

import org.testng.annotations.Test;

public class TestNGPriorityExample {


    @Test(priority = -1)
    public void testMethod1() {
        System.out.println("This is test method 1 with negative priority.");
    }

    @Test(priority = 1)
    public void testMethod2() {
        System.out.println("This is test method 3 with positive priority.");
    }

    @Test(priority = 0)
    public void testMethod3() {
        System.out.println("This is test method 2 with zero priority.");
    }

    @Test
    public void testMethod4() {
        System.out.println("This is test method 4 with default priority.");
    }


}
