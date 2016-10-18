package io.github.accessun.bitwise;

import java.util.Arrays;

import org.junit.Test;

public class BitTest {

    @Test
    public void test() {
        int a = 50;
        int b = 20;
        int c = 0;
        
        System.out.println("a\t" + a + "\t" + bin(a));
        System.out.println("b\t" + b + "\t" + bin(b));

        c = a & b;
        System.out.format("%s\t%d\t%s\n", "a & b", c, bin(c));
        
        c = a | b;
        System.out.format("%s\t%d\t%s\n", "a | b", c, bin(c));
        
        c = a ^ b;
        System.out.format("%s\t%d\t%s\n", "a ^ b", c, bin(c));
        
        c = ~a;
        System.out.format("%s\t%d\t%s\n", "~a", c, bin(c));
        
        c = a << 2;
        System.out.format("%s\t%d\t%s\n", "a << 2", c, bin(c));
        
        c = a >> 2;
        System.out.format("%s\t%d\t%s\n", "a >> 2", c, bin(c));
        
        c = a >>> 2;
        System.out.format("%s\t%d\t%s\n", "a >>> 2", c, bin(c));
    }

    @Test
    public void test2() {
        shiftRightPrint(8);
        shiftRightPrint(-8);
    }

    private void shiftRightPrint(int i) {
        int maxIterations = Integer.toBinaryString(Math.abs(i)).length();
        System.out.println(Integer.toBinaryString(i));
        for (int j = 1; j < maxIterations; j++) {
            i = i >> 1;
            System.out.println(Integer.toBinaryString(i));
        }
    }

    @Test
    public void test3() {
        System.out.println(0x7fffffff);
        System.out.println(Math.pow(2, 32));
        System.out.println(pow(2, 31));
        int i = -(-2147483648) + 1;
        System.out.println(i);
    }
    
    @Test
    public void te() {
        Arrays.asList(0, 1, 2, 3, 4, 5).forEach(x -> System.out.println(pow(2, x)));
    }

    private long pow(long base, long expo) {
        return pow(base, expo, 1);
    }
    
    private long pow(long base, long expo, long intermediate) {
        if (expo == 0)
            return intermediate;
        return pow(base, expo - 1, intermediate * base);
    }
    
    private String bin(int i) {
        return bin(i, 8);
    }
    
    private String bin(int i, int width) {
        String res = Integer.toBinaryString(i);
        if (i >= 0)
            res = String.format("%" + width + "s", res).replace(' ', '0');
        else
            res = res.substring(res.length() - width, res.length());
        return res;
    }
    
    @Test
    public void testFib() {
        fib(10);
    }
    
    private void fib(int number) {
        fib(0, 1, number);
    }
    
    private void fib(int a, int b, int count) {
        if (count == 0) {
            System.out.println();
            return;
        }
        System.out.print(b + " ");
        fib(b, a + b, --count);
    }
    
}
