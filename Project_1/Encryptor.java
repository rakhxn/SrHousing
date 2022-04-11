package Project_1;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String test = "98f6bcd4621d373cade4e832627b4f6";

        if(encryptString("test").equals(test)){
            System.out.println("True");
        }
        else
            System.out.println("False");
    }

    public static String encryptString(String input) throws NoSuchAlgorithmException{

        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger bigInt = new BigInteger(1,messageDigest);
        return bigInt.toString(16);
    }
}
