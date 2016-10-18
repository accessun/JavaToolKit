package io.github.accessun.temp;

import java.util.Map;

import java.util.HashMap;

public class ImplicitlyDanglingObj {

    private Object[] largeDataSet; // contains a large amount of data here

    public Map getNestedAnonMap() {
        
        Map nestedAnonMap = new HashMap(){{ // $1
            put("name", "Tom");
            put("email", "tom@example.com");
            put("extraInfo", new HashMap(){{ // $1$1
                put("phone", new HashMap(){{ // $1$1$1
                    put("office", "12345678");
                }});
                put("address", new HashMap(){{ // $1$1$2
                    put("home", "Gale Crater, Mars, Solar System");
                }});
            }});
        }};
        return nestedAnonMap;
    }
    
    public static void main(String[] args) {
        /*
         * The following instance of ImplicitlyDanglingObj got referenced
         * implicitly once a reference to nestedAnonMap is kept. This may
         * potentially cause a memory leak.
         */
        Map nestedAnonMap = new ImplicitlyDanglingObj().getNestedAnonMap();
        System.out.println(nestedAnonMap);
    }
}