package javaimpatient.ch15.ch15.sec05.com.horstmann.hello;

import javaimpatient.ch15.com.horstmann.greet.com.horstmann.greet.Greeter;

public class HelloWorld {
    public static void main(String[] args) {
       Greeter greeter = Greeter.newInstance();
       System.out.println(greeter.greet("Modular World"));
    }
}
