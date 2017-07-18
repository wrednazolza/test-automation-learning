package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ASUS on 2017-07-15.
 */
public class AddNewPagePage extends AdminPage{
    public AddNewPagePage(WebDriver driver) {
        super(driver);
    }

    public AddNewPagePage addNewPage(String title, String content) {
        insertText(title, By.id("title"));
        insertText(content, By.id("content"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sample-permalink")));
        click(By.id("publish"));
        return this;
    }
}
