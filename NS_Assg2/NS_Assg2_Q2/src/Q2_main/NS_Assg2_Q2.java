package Q2_main;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import sun.misc.BASE64Encoder;

/**
 *
 * @author fawad jawaid k112116
 */
public class NS_Assg2_Q2  {

    public static void main(String[] args) {
                String strDataToEncrypt = new String();
		String strCipherText = new String();
		String strDecryptedText = new String();
		
		try{
		    
                System.out.println("       Encrypting and Decrypting using DES");
		System.out.println();
                
		//Generating a DES key using KeyGenerator 
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		SecretKey secretKey = keyGen.generateKey();
                System.out.println("Cipher key generated: " + secretKey);
		
		
		//Creating a Cipher by specifying the following parameters Algorithm name (DES), Mode (CBC) and Padding (PKC55Padding)
		Cipher desCipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); 
		
		//Encrypting the Data using DES
		desCipher.init(Cipher.ENCRYPT_MODE,secretKey);
		
		strDataToEncrypt = "My name is Fawad Jawaid ";
                System.out.println("Original Text Message: " +strDataToEncrypt);
		byte[] byteDataToEncrypt = strDataToEncrypt.getBytes();
		byte[] byteCipherText = desCipher.doFinal(byteDataToEncrypt); 
		strCipherText = new BASE64Encoder().encode(byteCipherText);
		System.out.println("Cipher Text generated using DES: " +strCipherText);
		
		//Decrypting the data using DES
		desCipher.init(Cipher.DECRYPT_MODE,secretKey,desCipher.getParameters());
		byte[] byteDecryptedText = desCipher.doFinal(byteCipherText);
		strDecryptedText = new String(byteDecryptedText);
		System.out.println("Decrypted Text message is: " +strDecryptedText);
		}
		
		catch (NoSuchAlgorithmException noSuchAlgo)
		{
			System.out.println(" No Such Algorithm exists " + noSuchAlgo);
		}
		
			catch (NoSuchPaddingException noSuchPad)
			{
				System.out.println(" No Such Padding exists " + noSuchPad);
			}
		
				catch (InvalidKeyException invalidKey)
				{
					System.out.println(" Invalid Key " + invalidKey);
				}
				
				catch (BadPaddingException badPadding)
				{
					System.out.println(" Bad Padding " + badPadding);
				}
				
				catch (IllegalBlockSizeException illegalBlockSize)
				{
					System.out.println(" Illegal Block Size " + illegalBlockSize);
				}
				
				catch (InvalidAlgorithmParameterException invalidParam)
				{
					System.out.println(" Invalid Parameter " + invalidParam);
				} 
    }
}
