package com.qa.testrunner;

import com.microsoft.playwright.*;
import com.qa.assignment.pages.HomePage;
import com.qa.assignment.pages.LoginPage;
import com.qa.assignment.pages.ProductPage;
import com.qa.constants.CredsConstant;
import com.qa.constants.URLConstant;
import org.testng.annotations.*;

public class TestNG
{
    Playwright playwright;
    Browser browser;
    Page page;
    BrowserContext browserContext;

    @BeforeMethod
    public void launch()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();

        HomePage homepage = new HomePage(page);
        homepage.launchURL(URLConstant.BASE_URL);

        LoginPage loginpage = new LoginPage(page);
        loginpage.login(CredsConstant.USER, CredsConstant.PASSWORD);
    }

    @Test(testName = "Sort order - Z to A")
    public void sortDescending()
    {
        ProductPage productpage = new ProductPage(page);
        productpage.sort("Z to A");
    }

    @Test(testName = "Sort order - High to Low")
    public void sortHighToLow()
    {
        ProductPage productPage = new ProductPage(page);
        productPage.sort("high to low");
    }

    @AfterMethod
    public void tearDown()
    {
        page.close();
        browser.close();
        playwright.close();

    }
}
