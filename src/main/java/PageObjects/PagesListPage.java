package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ASUS on 2017-07-15.
 */
public class PagesListPage extends AdminPage {
    public PagesListPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPagePage goToAddNewPagePage() {
        click(By.linkText("Add New"));
        return new AddNewPagePage(driver);
    }

    public boolean isPagePublished(String title) {
        return driver.getPageSource().contains(title);
    }

    public EditPagePage goToPage(String title) {
        click(By.linkText(title));
        return new EditPagePage(driver);
    }
}
