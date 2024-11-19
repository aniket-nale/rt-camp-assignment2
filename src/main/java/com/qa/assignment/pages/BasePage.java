package com.qa.assignment.pages;

import com.microsoft.playwright.Page;

public class BasePage
{
    Page page;
    BasePage(Page page)
    {
        this.page=page;
    }
}
