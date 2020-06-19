package bankapp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clerk implements Serializable{

	private String firstName;
	private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
               
	public Clerk(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
	}  
	
	@Override
	public String toString() {
		return "\nCustomer Information\n" + "\n" +
				"First Name: " + firstName + "\n" +
				"Last Name: " + lastName + "\n";
	}
	
	public String getBasicInfo() {
		return "First Name: " + firstName +
				" Last Name: " + lastName;
	}

   
}
