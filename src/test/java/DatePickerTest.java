import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DatePickerTest extends BaseTest {

    @Test
    public void selectDateTest() {
        selectDate(6, 2, 2022);
        selectDate(2, 11, 2020);
        selectDate(3, 5, 2015);

    }

    private void selectDate(int day, int month, int year) {
        getDriver().get("https://seleniumui.moderntester.pl/datepicker.php");

        getDriver().findElement(By.id("datepicker")).click();

        waitForDatePicker();

        selectYear(year);

        selectMonth(month);

        selectDay(day);

        //todo add assertion

    }

    private void selectDay(int day) {
        List<WebElement> days = getDriver().findElements(By.cssSelector("[data-handler='selectDay']:not(.ui-datepicker-other-month)"));
        days.get(day - 1).click();
    }

    private void selectMonth(int month) {
        List<String> monthList =
                Arrays.asList("January", "February", "March", "April", "May",
                        "June", "July", "August", "September", "October", "November", "December");

        if (getIndexOfCurrentMonth(monthList) < month - 1) {
            do {
                clickNextButton();
            } while (getIndexOfCurrentMonth(monthList) != month - 1);
        } else {
            do {
                clickPrevButton();
            } while (getIndexOfCurrentMonth(monthList) != month - 1);
        }
    }

    private void selectYear(int year) {
        if (getCurrentYear() < year) {
            do {
                clickNextButton();
            } while (getCurrentYear() != year);
        } else {
            do {
                clickPrevButton();
            } while (getCurrentYear() != year);
        }
    }

    private void waitForDatePicker() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getIndexOfCurrentMonth(List<String> monthList) {
        return monthList.indexOf(getDriver().findElement(By.className("ui-datepicker-month")).getText());
    }

    private void clickPrevButton() {
        getDriver().findElement(By.cssSelector("[data-handler='prev']")).click();
    }

    private void clickNextButton() {
        getDriver().findElement(By.cssSelector("[data-handler='next']")).click();
    }

    private int getCurrentYear() {
        return Integer.parseInt(getDriver().findElement(By.className("ui-datepicker-year")).getText());
    }
}
