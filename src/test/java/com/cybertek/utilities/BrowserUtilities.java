package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtilities {


    public static List<String> getElementsText(List<WebElement> list){
        List<String> webelementsAsString = new ArrayList<>();

        for (WebElement each : list){
            webelementsAsString.add(each.getText());
        }
        return webelementsAsString;
    }

    public static void wait(int sec){
        try {
            Thread.sleep(1000 * sec);
        }catch (InterruptedException e){
            System.out.println("Interrupted exeception caught");
        }
    }
}
