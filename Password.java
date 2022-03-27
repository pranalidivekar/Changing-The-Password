import java.io.*;
/*
 * Password.java
 *
 * Version:
 *     1
 *
 * Revisions:
 *     1
 */

/**
 * This class implements serializable and instantiates the password constructor. 
 * 
 * @author      Sharvai Patil (sp4479@g.rit.edu)
 * @author      Pranali Divekar (pd1267@g.rit.edu)
 */

public class Password implements Serializable {

	String passwordString;
	String hashedPassword;

	Password(String passwordString, String hashedPassword){
		this.passwordString = passwordString;
		this.hashedPassword = hashedPassword;
	}

	public static void main(String[] args) {
		
	}
}