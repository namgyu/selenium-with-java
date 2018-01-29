import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    @Test
    public void searchWebdriver() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "webdriver/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");

        System.out.println("[Prev] Page title is: " + driver.getTitle());

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("webdriver");
        element.submit();

        System.out.println("[Next] Page title is: " + driver.getTitle());

        // 10초 대기
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("webdriver");
            }
        });

        driver.quit();
    }
}
