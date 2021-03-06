package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by streser on 02.01.2017.
 */
public class AddNewPostPage extends AdminPage {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage addNewPost(String postTitle, String postContent) {
        insertText(postTitle, By.cssSelector("input#title"));
        insertText(postContent,  By.xpath("//*[@id=\"content\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sample-permalink")));
        click(By.id("publish"));
        return this;
    }

}
