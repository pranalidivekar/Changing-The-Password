import java.util.*;
import java.io.*;

/*
 * PasswordWrite.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This class writes the password onto a file. 
 * 
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */

public class PasswordWrite {
	public static void main(String[] args) {

		String passwordString = "ABCD";
		String hashedPassword = (new PasswordWrite()).hashFunction(passwordString);
		
		Password passwordObject = new Password(passwordString, hashedPassword);

		try (
			FileOutputStream ostream = new FileOutputStream(args[0], false);
			ObjectOutputStream p = new ObjectOutputStream(ostream);
		) {
			p.writeObject(passwordObject);

			p.flush();
		}
		catch ( IOException e)	{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	/**
	* This method is a custom confidential hash function that hashes passwordString
	*
	*
	* @param       passwordString    	Stores the password
    *              
	*
	* @return      String
	*
	*/

	String hashFunction(String passwordString){
		String hashedPassword = "";

		for(char c: passwordString.toCharArray()){
			hashedPassword+= ""+(int)c;
		}

		System.out.println(hashedPassword);

		return hashedPassword;

	}


}