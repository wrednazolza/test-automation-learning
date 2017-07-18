package SeleniumTests;

import PageObjects.*;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by ASUS on 2017-07-15.
 */
public class PagesTest extends SeleniumTest {
    private String title;
    private String content;


    @Before
    public void generateTestData() {
        UUID uuid = UUID.randomUUID();
        title = "Page Title" + uuid.toString();
        content = "Page Content" + uuid.toString();
    }


    @Test
    public void shouldBePossibleToAddNewPage() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        DashboardPage dp = lp.logIn();
        PagesListPage plp = dp.goToPagesListPage();
        AddNewPagePage anpp = plp.goToAddNewPagePage();

        anpp.addNewPage(title, content);

        plp = anpp.goToPagesListPage();
        assertTrue(plp.isPagePublished(title));

        lp = plp.logOut();

        BlogPage bp = lp.goToBlogPage();
        assertTrue(bp.isPagePublished(title));
    }

    @Test
    public void shouldBePossibleToEditNewPage() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        DashboardPage dp = lp.logIn();
        PagesListPage plp = dp.goToPagesListPage();
        AddNewPagePage anpp = plp.goToAddNewPagePage();

        anpp.addNewPage(title, content);

        plp = anpp.goToPagesListPage();
        assertTrue(plp.isPagePublished(title));

        EditPagePage epp = plp.goToPage(title);
        epp.editPage(title + "edited");
        plp = epp.goToPagesListPage();
        assertTrue(plp.isPagePublished(title + "edited"));

        lp = plp.logOut();
        BlogPage bp = lp.goToBlogPage();
        assertTrue(bp.isPostPublished(title + "edited"));
    }
}