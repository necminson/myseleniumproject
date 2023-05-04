package com.myfirstproject.utilities;

public class ThreadSleepUtil {

    public static long threadSleepUtil (long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return milis;
    }

}