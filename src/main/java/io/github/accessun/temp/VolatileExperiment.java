package io.github.accessun.temp;

public class VolatileExperiment {

    static volatile int i = 0;
    static volatile int j = 0;
    
    static void read() {
        System.out.println("i = " + i + "; j = " + j);
    }
    
    static void write() {
        i++;
        j++;
    }
    
    public static void main(String[] args) {
        new Thread(() -> {
            for (int t = 0; t < 1000; t++) {
                write();
            }
        }).start();
        
        new Thread(() -> {
            for (int t = 0; t < 5; t++) {
                read();
            }
        }).start();
    }
}
