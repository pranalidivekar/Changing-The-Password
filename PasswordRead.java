import java.io.*;
import java.util.*;

/*
 * PasswordRead.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This class writes the password onto a file. 

 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */

public class PasswordRead {
	public static void main(String[] args) {
		
		String filename = args[0];
		PasswordRead ob = new PasswordRead();

		ob.readPassword(filename);

	}
	
	/**
	* This method reads the password from the file.
	*
	*
	* @param       filename    	Name of file which is to be read
    *              
	*
	* @return      void
	*
	*/

	void readPassword(String filename){
		try (
			FileInputStream istream = new FileInputStream(filename);
			ObjectInputStream p = new ObjectInputStream(istream);
		) {			
			Password passwordObject = (Password)p.readObject();

			System.out.print("The password is = ");

			if(passwordObject.hashedPassword.equals(hashFunction(passwordObject.passwordString)))
				System.out.println(passwordObject.passwordString);

		}
		catch ( IOException e)	{
			System.out.println(e.getMessage());
		}
		catch ( ClassNotFoundException e)	{
			System.out.println(e.getMessage());
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

		return hashedPassword;

	}
}
