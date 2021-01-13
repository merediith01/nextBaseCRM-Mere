package com.cybertek.test.Sprint2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class UserStory10 {


    WebDriver driver;
    public com.cybertek.utilities.WebDriverFactory WebDriverFactory;
    public Object String;

    @BeforeMethod
    public void setupMethod() {
        // open a new browser
        driver = com.cybertek.utilities.WebDriverFactory.getDriver("chrome");
        String URL = "https://login.nextbasecrm.com/";
        String Login = "hr33@cybertekschool.com";
        String password = "UserUser";

        driver.get(URL);
        System.out.println("The title of the page is: " + driver.getTitle());
        String actualTitle = driver.getTitle();
        System.out.println("ACTUAL TITLE STRING: " + actualTitle);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl =" + actualUrl);

        // Login in
        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[1]/input")).sendKeys(Login);
        //Password
        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[2]/input")).sendKeys(password);
        //Clicks "Log In"
        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/input")).click();

        String expected = "(26) Portal";
        String actual = driver.getTitle();
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        System.out.println(expected.equals(actual)?"Pass:":"Fail");
    }

    @Test
    public void TaskTab() {
        // Selects "Task" tab on the main selection menu
        driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // selects "High priority"
        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[1]/div[1]/div[1]/label")).click();


        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Users can click on ""Checklist"" to create checklists items
        driver.findElement(By.cssSelector("#post-buttons-bottom > span.tasks-task-mpf-link")).click();



        //
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Selects "Deadline" textbox
        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[1]/span[1]/span/input[1]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // In the date picker pop up window, select whatever date you want
        {
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"popup-window-content-calendar_popup_0.866357455244481\"]/div"));

            for (WebElement element : elements) {
                System.out.println(element.getText());
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //Selecting the month
                if (element.getText().equals("July")) {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //Selecting the date
                    List<WebElement> days = driver.findElements(By.xpath("//div[@class='bx-calendar-cell bx-calendar-weekend bx-calendar-active "));

                    //Selecting from all days in the month
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (WebElement d : days) {
                        System.out.println(d.getText());
                        if (d.getText().equals(31)) {
                            d.click();
                            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                            return;
                        }
                    }

                }

            }

            // Click on <Select> button on the date-picker(calendar) pop up window
            driver.findElement(By.xpath("//a[.='Select']")).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            driver.close();
        }
    }

}



