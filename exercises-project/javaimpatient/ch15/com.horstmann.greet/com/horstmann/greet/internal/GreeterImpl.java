package javaimpatient.ch15.com.horstmann.greet.com.horstmann.greet.internal;

import javaimpatient.ch15.com.horstmann.greet.com.horstmann.greet.Greeter;

public class GreeterImpl implements Greeter
{
    public String greet(String subject)
    {
        return "Hello, " + subject + "!";
    }
}
