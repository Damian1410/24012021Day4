import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Mountain {
    private String peak;
    private String height;

    Mountain(WebElement row) {
        peak = row.findElements(By.cssSelector("td")).get(0).getText();
        height = row.findElements(By.cssSelector("td")).get(3).getText();
    }

    public String getPeak() {
        return peak;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "peak='" + peak + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
