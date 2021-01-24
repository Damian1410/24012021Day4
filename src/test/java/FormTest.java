import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FormTest extends BaseTest {

    @Test
    public void shouldSendForm() {

        getDriver().get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = getDriver().findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");

        WebElement lastName = getDriver().findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        WebElement age = getDriver().findElement(By.id("inputAge3"));
        age.sendKeys("20");

        WebElement email = getDriver().findElement(By.cssSelector("input[type='email']"));
        email.sendKeys("kowalski@wp.pl");

        WebElement sex = getDriver().findElement(By.id("gridRadiosFemale"));
        sex.click();

        List<WebElement> yearOfExperience = getDriver().findElements(By.cssSelector("input[name='gridRadiosExperience']"));
        yearOfExperience.get(2).click();

        WebElement profession = getDriver().findElement(By.id("gridCheckAutomationTester"));
        profession.click();

        Select continents = new Select(getDriver().findElement(By.id("selectContinents")));
        continents.selectByIndex(5);
        continents.selectByValue("europe");
        continents.selectByVisibleText("Africa");

        Select commands = new Select(getDriver().findElement(By.id("selectSeleniumCommands")));
        commands.selectByIndex(3);

        File file = new File("src/main/resources/file.txt");

        WebElement uploadFile = getDriver().findElement(By.id("chooseFile"));
        uploadFile.sendKeys(file.getAbsolutePath());

        WebElement saveButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        saveButton.click();

        WebElement formMessage = getDriver().findElement(By.id("validator-message"));
        String textSuccess = "Form send with success";

        Assert.assertEquals(formMessage.getText(), textSuccess);

    }

}
