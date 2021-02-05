package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.Cookie;

public class AgentBean {

	String firstName, lastName, email, password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validate(String loginPassword) {
		return loginPassword.equals("password");

	}
	
	public void showPath() {
		System.out.println(new File("userData.text").getAbsolutePath());
	}
	
	

	// create a file to store usersdata in
	/*
	 * 
	 * public void createFile() { System.out.println(new
	 * File(".").getAbsolutePath()); try {
	 * 
	 * 
	 * File userData = new
	 * File("\\Documents\\workspace\\travelingAgents\\Java Resources\\userData\\userData.txt"
	 * ); if (userData.createNewFile()) { System.out.println("File created: " +
	 * userData.getName()); } else { System.out.println("File already exists."); } }
	 * catch (IOException e) { System.out.println("An error occurred.");
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 */
	
	
	public void writeToFile() {
		// members\\userData\\

		try {
			
			//FileWriter myWriter = new FileWriter((new File("").getAbsoluteFile())+"/Dokuments/workspace/travelingAgents/userData/userdata.txt");
			FileWriter myWriter = new FileWriter("/home/daniel/Documents/workspace/travelingAgents/userData/userdata.txt");
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	
}