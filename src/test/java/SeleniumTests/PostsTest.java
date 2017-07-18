package SeleniumTests;

import PageObjects.*;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by streser on 02.01.2017.
 */
public class PostsTest extends SeleniumTest {
    private String title;
    private String content;

    @Before
    public void generateTestData() {
        UUID uuid = UUID.randomUUID();
        title = "Post Title" + uuid.toString();
        content = "Post Content" + uuid.toString();
    }

    @Test
    public void shouldBePossibleToAddNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        DashboardPage dp = lp.logIn();
        PostsListPage plp = dp.goToPostsListPage();
        AddNewPostPage anpp = plp.goToAddNewPostPage();

        anpp.addNewPost(title, content);

        plp = anpp.goToPostsListPage();
        assertTrue(plp.isPostPublished(title));
        lp = plp.logOut();

        BlogPage bp = lp.goToBlogPage();
        assertTrue(bp.isPostPublished(title));
    }

    @Test
    public void shouldBePossibleToEditNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        DashboardPage dp = lp.logIn();
        PostsListPage plp = dp.goToPostsListPage();
        AddNewPostPage anpp = plp.goToAddNewPostPage();

        anpp.addNewPost(title, content);

        plp = anpp.goToPostsListPage();
        assertTrue(plp.isPostPublished(title));

        EditPostPage epp = plp.goToPost(title);
        epp.editPost(title + "edited");
        plp = epp.goToPostsListPage();
        assertTrue(plp.isPostPublished(title + "edited"));

        lp = plp.logOut();
        BlogPage bp = lp.goToBlogPage();
        assertTrue(bp.isPostPublished(title + "edited"));
    }

}