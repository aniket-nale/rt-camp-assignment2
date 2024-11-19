package com.qa.assignment.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage
{
    public HomePage(Page page)
    {
        super(page);
    }

    public void launchURL(String url)
    {
        page.navigate(url);
        assert page.url().equalsIgnoreCase(url);
        page.waitForTimeout(1000);
    }
}
