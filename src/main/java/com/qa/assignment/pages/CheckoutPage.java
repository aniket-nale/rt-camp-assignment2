package com.qa.assignment.pages;

import com.microsoft.playwright.Page;
import com.qa.constants.Locator;

public class CheckoutPage extends BasePage
{
    public CheckoutPage(Page page)
    {
        super(page);
    }
    public void checkout()
    {
        assert page.locator(Locator.CHECKOUT).isVisible();
        page.locator(Locator.CHECKOUT).click();
        page.waitForTimeout(1000);

        assert page.getByText("Checkout: Your Information").isVisible();
    }
    public void checkoutInfo(String Firstname, String Lastname, String Postal_code)
    {
        assert page.locator(Locator.FIRSTNAME).isVisible();
        page.locator(Locator.FIRSTNAME).fill(Firstname);
        page.waitForTimeout(1000);

        assert page.locator(Locator.LASTNAME).isVisible();
        page.locator(Locator.LASTNAME).fill(Lastname);
        page.waitForTimeout(1000);

        assert page.locator(Locator.POSTAL_CODE).isVisible();
        page.locator(Locator.POSTAL_CODE).fill(Postal_code);
        page.waitForTimeout(1000);

        assert page.locator(Locator.CONTINUE).isVisible();
        page.locator(Locator.CONTINUE).click();

        assert page.getByText("Checkout: Overview").isVisible();
    }
    public void finish()
    {
        page.locator(Locator.FINISH).click();
        page.waitForTimeout(1000);
        assert page.getByText("Checkout: Complete!").isVisible();
    }
}
