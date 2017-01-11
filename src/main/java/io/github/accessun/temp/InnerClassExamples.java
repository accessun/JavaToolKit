package io.github.accessun.temp;

class Hello {
    
}

public class InnerClassExamples {
    
    public Object get() {
        return new Hello() { // first anon inner class that extends `Hello`
            {
                new Hello() { // anon inner class inside the first inner class that extends `Hello`
                    // $1$1
                    {
                        new Hello() {
                            // $1$1$1
                            {
                                System.out.println();
                            }
                        };
                        new Hello() {
                            // $1$1$2
                            {
                                System.out.println();
                            }
                        };
                    }
                };
            }
        };
    }
    
    
    public static void main(String[] args) {
        Object obj = new InnerClassExamples().get();
        System.out.println(obj);
    }
}
