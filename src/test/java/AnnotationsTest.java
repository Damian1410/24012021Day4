import org.testng.annotations.*;

public class AnnotationsTest {


    @BeforeClass
    public void beforeAll() {
        System.out.println("to jest przed wszystkimi testami");
    }

    @AfterClass
    public void afterAll() {
        System.out.println("to sie wykonuje po wszystkich testach");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("to sie wykonuje przed kazdym testem");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("to sie wykonuje po kazdym tescie");
    }

    @Test
    public void test1() {
        System.out.println("To jest pierwszy test");
    }

    @Test
    public void test2() {
        System.out.println("To jest drugi test");
    }

    @Test
    public void test3() {
        System.out.println("To jest trzeci test");
    }

}
