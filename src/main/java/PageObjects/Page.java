package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by streser on 02.01.2017.
 */
public abstract class Page {
    protected final WebDriver driver;

    public String baseUrl = "http://streser.nazwa.pl/szkolenia";

    public Page(WebDriver driver){
        this.driver = driver;
    }

    protected void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        driver.findElement(locator).click();
    }

    protected void insertText(String text, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        driver.findElement(locator).sendKeys(text);
    }


    public BlogPage goToBlogPage() {
        driver.get(baseUrl);
        return new BlogPage(driver);
    }

}
