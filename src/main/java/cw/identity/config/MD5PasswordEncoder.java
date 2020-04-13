package cw.identity.config;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MD5PasswordEncoder implements PasswordEncoder {

	Cipher s_cipher;
    SecretKey s_key;
	
    @Override
    public String encode(CharSequence charSequence) {
        String encPass = "";
       try {
    	    encPass=this.encrypt(charSequence.toString());
        }catch(Exception ex){
            System.out.println("An exception trying to encode a password");
        }
        return encPass;
    }
    
    public void initCipher() {
        try {
            this.s_key = new SecretKeySpec(new byte[] { 100, 25, 28, -122, -26, 94, -3, -72 }, "DES");
            this.s_cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private String encrypt(final String value) throws Exception {
        String clearText = value;
        if (clearText == null) {
            clearText = "";
        }
        if (this.s_cipher == null) {
            this.initCipher();
        }
        if (this.s_cipher == null) {
            throw new ServletException("CryptoUtility.encrypt() - Can't load cipher");
        }
        String result = "";
        try {
            this.s_cipher.init(1, this.s_key);
            MessageDigest md = null;
            md = MessageDigest.getInstance("SHA");
            md.update(value.getBytes("UTF-8"));
            final byte[] raw = md.digest();
            result = new String(org.apache.commons.codec.binary.Base64.encodeBase64(raw), "UTF-8");
        }
        catch (Exception ex) {
            throw new ServletException("CryptoUtility.encrypt() - Can't init cipher", (Throwable)ex);
        }
        return result;
    }
    
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        boolean t = encode(charSequence).equals(s);
        return t;
    }
}