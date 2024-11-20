package com.qa.testrunner;

import com.microsoft.playwright.*;
import com.qa.assignment.pages.CheckoutPage;
import com.qa.assignment.pages.HomePage;
import com.qa.assignment.pages.LoginPage;
import com.qa.assignment.pages.ProductPage;
import com.qa.constants.CredsConstant;
import com.qa.constants.Locator;
import com.qa.constants.URLConstant;
import com.qa.constants.UserInfo;
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

    @Test(testName = "Sort order - Z to A", priority = 1)
    public void sortDescending()
    {
        ProductPage productpage = new ProductPage(page);
        productpage.sort("Z to A");
    }

    @Test(testName = "Sort order - High to Low", priority = 2)
    public void sortHighToLow()
    {
        ProductPage productPage = new ProductPage(page);
        productPage.sort("high to low");
    }

    @Test(testName = "adding product to cart and validate checkout journey", priority = 3)
    public void addingProduct() {
        ProductPage productPage = new ProductPage(page);
        productPage.addToCart(com.qa.constants.Locator.PRODUCT1);
        productPage.addToCart(com.qa.constants.Locator.PRODUCT2);
        productPage.addToCart(com.qa.constants.Locator.PRODUCT3);
        productPage.addToCart(com.qa.constants.Locator.PRODUCT4);
        productPage.addToCart(com.qa.constants.Locator.PRODUCT5);
        productPage.addToCart(Locator.PRODUCT6);

        productPage.goToCart();

        CheckoutPage checkoutpage = new CheckoutPage(page);
        checkoutpage.checkout();

        checkoutpage.checkoutInfo(UserInfo.USERNAME, UserInfo.USER_LASTNAME, UserInfo.POSTAL_CODE);

        checkoutpage.finish();
    }
    @AfterMethod
    public void tearDown()
    {
        page.close();
        browser.close();
        playwright.close();

    }
}
