import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Student Name: Can Gok, id: 150118014
 * Person class of the program
 * This class contains the variables and methods of super class of everyone
 * Features are same type of features in every person
 */

public class Person {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private byte gender;
	
	private Calendar birthDate;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private byte maritalStatus;
	
	private boolean hasDriverLicense;
	
	//Constructor for person class
	
	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense) throws Exception {
		
		//initialize the variables
		
		this.setId(id);

		this.setFirstName(firstName);
		
		this.setLastName(lastName);
		
		this.setGender(gender);
		
		this.setMaritalStatus(maritalStatus);
		
		this.setBirthDate(birthDate);
		
		this.setHasDriverLicense(hasDriverLicense);
		
	}
	
	//toString method for Person object

	@Override
	public String toString() {
		return "Person Info [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", birthDate=" + dateFormat.format(birthDate.getTime()) + ", maritalStatus=" + ((this.maritalStatus == 1) ? "Single" : "Married") + ", hasDriverLicense="
				+ ((hasDriverLicense) ? "Yes" : "No") + "]";
	}
	
	//Getters and setters for variables of Person

	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		if(id < 0) {
			throw new Exception("id cannot be lower than zero"); // Throw new exception
		}
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		if(firstName.length() < 3) {
			throw new Exception("string cannot be lower than 3 bytes"); // Throw new exception
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws Exception {
		if(lastName.length() < 3) {
			throw new Exception("string cannot be lower than 3 bytes"); // Throw new exception
		}
		this.lastName = lastName;
	}

	public String getGender() {
		if(gender == 1) {
			return "Woman";
		} else if(gender == 2) {
			return "Man";
		} else {
			//Throw exception
		}
		return null;
	}

	public void setGender(String gender) throws Exception {
		if(gender.equals("Woman")) {
			this.gender = 1;
		} else if(gender.equals("Man")) {
			this.gender = 2;
		} else {
			throw new Exception("gender can only be woman or man"); // Throw new exception
		}
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus(){
		if(maritalStatus == 1) {
			return "Single";
		} else if(maritalStatus == 2) {
			return "Married";
		} else {
			//Throw exception
		}
		return null;
	}

	public void setMaritalStatus(String maritalStatus) throws Exception {
		if(maritalStatus.equals("Single")) {
			this.maritalStatus = 1;
		} else if(maritalStatus.equals("Married")) {
			this.maritalStatus = 2;
		} else {
			throw new Exception("marital status can be single or married"); // Throw new exception
		}
	}

	public String getHasDriverLicense() {
		if(hasDriverLicense == true) {
			return "Yes";
		} else if(hasDriverLicense == false) {
			return "No";
		} else {
			//Throw exception
		}
		return null;
	}

	public void setHasDriverLicense(String hasDriverLicense) throws Exception {
		if(hasDriverLicense.equals("Yes")) {
			this.hasDriverLicense = true;
		} else if(hasDriverLicense.equals("No")) {
			this.hasDriverLicense = false;
		} else {
			throw new Exception("string can be yes or no"); // Throw new exception
		}
	}
	

}
