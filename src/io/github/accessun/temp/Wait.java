package io.github.accessun.temp;

public class Wait {

    public static void waitSomeTime(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }
}
