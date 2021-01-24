import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsTest {

    @Test
    public void shouldPass() {
        Assert.assertEquals(1, 1);
        String s = "text";
        Assert.assertEquals(s, "text");
        Assert.assertTrue(2 < 5);

    }

    @Test
    public void shouldFail(){
        Assert.assertFalse(true);
    }

}
