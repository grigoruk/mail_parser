package javamailparsertest;

import junit.framework.*;

import javamailparser.*;

public class JavaMailParserTest extends TestCase {

//    public void testSmoke() {        
//        Mail m = new Mail("test@mail.ru");
//    }

    public void testGetDomain(){
        String test = "test@mail.ru";
        String res = "mail.ru";
        Mail m = new Mail(test);
        assertEquals(res, m.getDomain());
    }
    
    public void testMailValidation(){
        Mail m = new Mail("test@mail.ru");
        assertTrue(m.isValid());
        
        m = new Mail("sdfsdf@@@@@rdfdf");
        assertFalse(m.isValid());
        
        m = new Mail("example@localhost");
        assertFalse(m.isValid());
        
        m = new Mail("@local@host");
        assertFalse(m.isValid());
        
        m = new Mail("ivan@xn--c1ad6a.xn--p1ai");
        assertTrue(m.isValid());     
        
        m = new Mail("иван@иванов.рф");
        assertTrue(m.isValid());
        
    }

}