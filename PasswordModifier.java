import java.io.*;
import java.util.*;

/*
 * PasswordModifier.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This class enables you to modify the password.

 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */

public class PasswordModifier {
	public static void main(String[] args) {

		String filename = args[0];
		PasswordModifier ob = new PasswordModifier();
		ob.readPassword(filename);
	}
	
	/**
	* This method enables you to modify the password.
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
			String passwordString = passwordObject.passwordString;
			String hashedPassword = passwordObject.hashedPassword;

			System.out.println(passwordString);
			System.out.println(hashedPassword);

			writeNewPassword(filename, passwordString, hashedPassword);
		}
		catch ( IOException e)	{
			System.out.println(e.getMessage());
		}
		catch ( ClassNotFoundException e)	{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	* This method overwrites the old password with the new one.
	*
	*
	* @param       filename    		Name of file which is to be read
	*			   passwordString	Stores actual password
	*			   hashedPassword	Stores hashed password
    *              
	*
	* @return      void
	*
	*/

	void writeNewPassword(String filename, String passwordString, String hashedPassword){
		try (
			FileOutputStream ostream = new FileOutputStream(filename, false);
			ObjectOutputStream p = new ObjectOutputStream(ostream);
		) {
			Password passwordObject = new Password("changedPassword", hashedPassword);

			p.writeObject(passwordObject);

			p.flush();
		}
		catch ( IOException e)	{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
