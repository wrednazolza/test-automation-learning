package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ASUS on 2017-07-16.
 */
public class EditPostPage extends AdminPage{
    public EditPostPage(WebDriver driver) {super(driver);}

    public EditPostPage editPost(String s) {
        driver.findElement(By.id("title")).clear();
        insertText(s, By.id("title"));
        click(By.id("publish"));
        return this;
    }
}
