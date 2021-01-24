import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDrop() {
        getDriver().get("https://seleniumui.moderntester.pl/droppable.php");

        WebElement drag = getDriver().findElement(By.id("draggable"));
        WebElement drop = getDriver().findElement(By.id("droppable"));

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(drag,drop).perform();

        Assert.assertEquals(getDriver().findElement(By.cssSelector("#droppable>p")).getText(),"Dropped!");

    }

}
