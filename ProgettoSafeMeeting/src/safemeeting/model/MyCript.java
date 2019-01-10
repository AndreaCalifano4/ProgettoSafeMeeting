package safemeeting.model;

/**
 * Classe usata per salvare sul database o recuperare dal 
 * database informazioni relative ad un corso;
 * @author Emilio Mainardi
 * @author Donato Marmora
 * @author Luca Di Chiara
 */

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class MyCript {

  private static final String secretKey = "fqJfdzGDvfwbedsKSUGty3VZ9taXxMVw";
  private static Cipher cipher;
  private static Key key = new SecretKeySpec(secretKey.getBytes(), "AES");
  private static byte[] encryptedData;
  private static String decryptedData;

  /**
   * Questo metodo cripta la password.
   * 
   * @param message (la password)
   * @return encryptedData (password criptata)
   */
  public static String encrypt(String message) {
    cipher = null;
    try {
      cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, key);
      encryptedData = cipher.doFinal(message.getBytes("UTF-8"));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    }

    return Base64.getEncoder().encodeToString(encryptedData);
  }

  /**
   * Questo metodo decripta la password.
   * 
   * @param cipherText (la password criptata)
   * @return decryptedData (password decriptata)
   */
  public static String decrypt(String cipherText) {
    cipher = null;
    try {
      cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.DECRYPT_MODE, key);
      // byte[] decode = Base64.decode(cipherText, Base64.DEFAULT);
      byte[] decode = Base64.getDecoder().decode(cipherText);
      decryptedData = new String(cipher.doFinal(decode), "UTF-8");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    }
    return decryptedData;
  }
}