import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selectable extends BaseTest {

    @Test
    public void shouldSelect245() {
        getDriver().get("https://seleniumui.moderntester.pl/selectable.php");

        List<WebElement> selectList = getDriver().findElements(By.cssSelector("#selectable>li"));

        Actions actions = new Actions(getDriver());

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(selectList.get(1))
                .click(selectList.get(3))
                .click(selectList.get(4))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        Assert.assertEquals(getDriver().findElement(By.id("select-result")).getText(), "#2 #4 #5");

    }

}
