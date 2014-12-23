package javamailparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.IDN;

public class Mail {
    private String mail; 
    private String domain; 
    private String username; 
    public Mail(String mail){
        this.mail = mail;
        parseToNameAndHost();
    }
    private void parseToNameAndHost(){
        String mail = this.mail;
        int atPos = this.mail.indexOf('@');
        if (atPos > 0){
            this.domain = mail.substring(atPos+1);
            this.username = mail.substring(0,atPos);
        }
    }
    public String getDomain(){
        return this.domain;
    }
    public String getUsername(){
        return this.username;
    }
    
    public boolean isValid(){
        if (this.username == null || this.domain == null ) { return false; }
        if (this.isPunycode()) { return this.isValidPunycode(); }
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(this.mail);
        return m.matches();
    }
    private boolean isPunycode(){
        String asciiDomain = IDN.toASCII(this.domain);
        Pattern p = Pattern.compile("xn--.+\\.xn--.+");
        Matcher m = p.matcher(asciiDomain);
        return m.matches();
    }
    private boolean isValidPunycode(){
        String asciiMail = IDN.toASCII(this.username) + "@" + IDN.toASCII(this.domain);
        Pattern p = Pattern.compile(".+@xn--.+\\.xn--[a-z0-9]+");
        Matcher m = p.matcher(asciiMail);
        System.out.println(asciiMail);
        return m.matches();
    }
}