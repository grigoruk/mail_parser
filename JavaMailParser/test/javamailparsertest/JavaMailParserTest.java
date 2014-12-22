package javamailparsertest;

import junit.framework.*;

import javamailparser.*;

public class JavaMailParserTest extends TestCase {
    // … standard setup code …

    // Test object creation
    public void test_smoke() {
        String test = "test@mail.ru";
        String res ="mail.ru";
        JavaMailParser parser = new JavaMailParser(test);
        assertEquals(res, parser.getDomain());
    }
}