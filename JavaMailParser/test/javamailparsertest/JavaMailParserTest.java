package javamailparsertest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
 
import org.junit.runner.JUnitCore;
 
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.Failure;

import javamailparser.*;

public class JavaMailParserTest{

    @Test
    public void GetDomain(){
        String test = "test@mail.ru";
        String res = "mail.ru";
        Mail m = new Mail(test);
        assertEquals(res, m.getDomain());
    }
    
    @Test
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
    
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        // Вот подключение нашего собственного слушателя/листенера
        core.addListener(new MailParserListener());
        core.run(JavaMailParserTest.class);
    }
}
    
class MailParserListener extends RunListener {
 
    @Override
    public void testStarted(Description desc) {
        System.out.println("Started:" + desc.getDisplayName());
    }
 
    @Override
    public void testFinished(Description desc) {
        System.out.println("Finished:" + desc.getDisplayName());
    }
 
    @Override
    public void testFailure(Failure fail) {
        System.out.println("Failed:" + fail.getDescription().getDisplayName() 
                + " [" + fail.getMessage() + "]");
    }
}