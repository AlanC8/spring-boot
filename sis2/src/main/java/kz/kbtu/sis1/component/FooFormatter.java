package kz.kbtu.sis1.component;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter {
    public String format() {
        return "foo";
    }
}