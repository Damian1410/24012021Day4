import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @BeforeMethod
    public void openAlertPage() {
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
    }


    @Test
    public void simpleAlert() {
        getDriver().findElement(By.id("simple-alert")).click();

        getDriver().switchTo().alert().accept();

        Assert.assertEquals(getDriver().findElement(By.id("simple-alert-label")).getText(), "OK button pressed");
    }

    @Test
    public void promptAlert() {
        getDriver().findElement(By.id("prompt-alert")).click();
        String name = "Maciej Kowalczuk";
        getDriver().switchTo().alert().sendKeys(name);
        getDriver().switchTo().alert().accept();

        Assert.assertEquals(getDriver().findElement(By.id("prompt-label")).getText(), "Hello " + name + "! How are you today?");
    }


}
