package com.qa.assignment.pages;

import com.microsoft.playwright.Page;
import com.qa.constants.Locator;

public class LoginPage extends BasePage
{
    public LoginPage(Page page)
    {
        super(page);
    }

    public void login(String username, String password)
    {
        page.locator(Locator.USERNAME).fill(username);
        page.waitForTimeout(1000);

        page.locator(Locator.PASSWORD).fill(password);
        page.waitForTimeout(1000);

        page.locator(Locator.LOGIN_BUTTON).click();
        page.waitForTimeout(1000);
        assert page.getByText("Products").isVisible();
    }
}
