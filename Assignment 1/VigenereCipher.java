/*
* Name: Victor Sun
* ID: V00894734
* Date: Jan 27, 2018
* Filename: VigenereCipher.java
* Details: CSC 115 Assignment 1
*/

public class VigenereCipher implements Cipher{
	
	private String theKey;
	
	public VigenereCipher(String key){
		theKey = key;
	}
	
	/*
	Prints out the specified text, followed immediately by the (comma-delimited) contents of the array.
	@param the array that is going to be printed
	@param the text that is printed before the array
	*/
	
	private void dumpArray(int[] array, String text){
		System.out.print(text);
		System.out.print(" ");
		for(int i = 0; i < array.length; i++){
			if(i > 0){
                System.out.print(", ");
            }
			System.out.print(array[i]);
		}
	}
	
	/*
	Converts a string into an int array where the values are within the range 0...25. 
	The values are matched, in order, to the characters in the string. For example, 
	the integer 0 is matched to the letter 'a' and 25 is matched to and 'z'.
	@param the text that is printed before the array
	@return The array of integers created from the string array
	*/
	
	private int[] stringToIntArray(String text){
		int[] stringToInt = new int[text.length()];
		for(int i = 0; i < text.length(); i++){
			stringToInt[i] = text.charAt(i) - 97;
		}
		return stringToInt;
	}
	
	/*
	Converts an array of integers with values in the range 0...25 
	into a string with characters in the range a...z. The individual 
	letters are ordered exactly as the corresponding integer values. 
	For example, the value 0 in index position i of the array, matches 
	an 'a' as the first letter in the string.
	@param encodedText is the text that is going to be converted
	@return String created from the integer array
	*/
	
	private String intArrayToString(int[] encodedText){
		char[] intToString = new char[encodedText.length];
		for(int i = 0; i < encodedText.length; i++){
			intToString[i] = (char) (encodedText[i] + 97);
		}
		String encodedString = new String(intToString);
		return encodedString;
	}
	
	/*
	Encrypts a string using a simplified Vigenere cipher. All text is limited 
	to lower-case ASCII letters a...z
	@param plaintext is the text that is going to be encrypted
	@return the encrypted text
	*/
	
	public String encrypt(String plaintext){
		int p = 0;
		StringBuilder x = new StringBuilder();
		for(int i = 0; i < plaintext.length(); i++){
			x.append(theKey.charAt(p));
			p++;
			if(p > (theKey.length() - 1)){
				p = 0;
			}
		}
		
		String expandedKey = x.toString();
		int[] inputtedArray = stringToIntArray(plaintext);
		int[] keyArray = stringToIntArray(expandedKey);
		
		int[] combinedArray = new int[plaintext.length()];
		for(int i = 0; i < plaintext.length(); i++){
			combinedArray[i] = ((inputtedArray[i] + keyArray[i]) % 26);
		}
		
		String encryptedString = intArrayToString(combinedArray);
		return encryptedString;
		
	}
	
	/*
	Decrypts a string using a modified Vigenere cipher. All text is limited 
	to lower-case ASCII letters a...z
	@param ciphertext is the text to be decrypted
	@return the decrypted text
	*/
	
	public String decrypt(String ciphertext){
        int p = 0;
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++){
            x.append(theKey.charAt(p));
            p++;
            if (p > (theKey.length() - 1)){
                p = 0;
            }
        }
		
        String expandedKey = x.toString();
        int[] inputtedArray = stringToIntArray(ciphertext);
        int[] keyArray = stringToIntArray(expandedKey);
        
        int[] combinedArray = new int[ciphertext.length()];
        for (int i = 0; i < ciphertext.length(); i++){
            combinedArray[i] = ((26 + inputtedArray[i] - keyArray[i]) % 26);
        }
        
        String decryptedString = intArrayToString(combinedArray);
        return decryptedString;
    }
	
	/*
	Sets the key for a simplified Vigenere cipher. All text is limited 
	to lower-case ASCII letters a...z
	@param the key in plaintext
	*/
	
	public void setKey(String key){
		theKey = key;
	}
	
	public static void main(String[] args){
		VigenereCipher vg = new VigenereCipher("abc");

		int[] a = {};
		int[] b = {0};
		int[] c = {0,1,2,3,4,5,6,7};
		String A = "";
		String B = "testing";
		String C = "moretesting";
		String D = "keyone";
		String E = "twokey";
		String F = "abcdef";

		System.out.println(vg.encrypt(E));

		vg.setKey("Pokemon");

		System.out.println(vg.encrypt(E));
		
		System.out.println(vg.decrypt(vg.encrypt(E)));

		//for(int i: vg.stringToIntArray(D)) {
		//	System.out.print(i+" ");
		//}

		//System.out.println();

		//for(char i: vg.intArrayToString(c).toCharArray()) {
		//	System.out.print(i+" ");
		//}

		//vg.dumpArray(c,"result: ");

		//System.out.println(vg.intArrayToString(c));

		//vg.dumpArray(a, "result:");
		
	}
}