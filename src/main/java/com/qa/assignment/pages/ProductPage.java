package com.qa.assignment.pages;

import com.microsoft.playwright.Page;
import com.qa.constants.Locator;

public class ProductPage extends BasePage
{
    public ProductPage(Page page)
    {
        super(page);
    }

    public void sort(String sortOrder)
    {
        if (sortOrder.equalsIgnoreCase("Z to A"))
        {
            page.locator(Locator.SORT_OPTION).selectOption("za");
            page.waitForTimeout(2000);

            assert page.locator(Locator.SORT_OPTION).textContent().contains("Z to A");
        } else if (sortOrder.equalsIgnoreCase("high to Low"))
        {
            page.locator(Locator.SORT_OPTION).selectOption("hilo");
            page.waitForTimeout(2000);

            assert page.locator(Locator.SORT_OPTION).textContent().contains("high to low");

        }else if (sortOrder.equalsIgnoreCase("A to Z"))
        {
            page.locator(Locator.SORT_OPTION).selectOption("az");
            page.waitForTimeout(1000);

            assert page.locator(Locator.SORT_OPTION).textContent().contains("A to Z");

        } else if (sortOrder.equalsIgnoreCase("low to high"))
        {
            page.locator(Locator.SORT_OPTION).selectOption("lohi");
            page.waitForTimeout(1000);

            assert page.locator(Locator.SORT_OPTION).textContent().contains("Low to high");
        }else
        {
            System.err.println("Invalid option");
        }
    }
}
