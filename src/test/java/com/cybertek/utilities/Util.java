package com.cybertek.utilities;

public class Util {

    public static class Sleep_Custom_Method{

        public static void sleep(int seconds){
            try {
                Thread.sleep(seconds * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


