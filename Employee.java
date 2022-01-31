import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Student Name: Can Gok, id: 150118014
 * Employee class of the program
 * This class contains the variables and methods of super class of every employee
 * Features are same type of features in every employee
 */

public class Employee extends Person{
	
	//salary is a double value, salary of the employee
	//dateformat is being used for converting string to calendar
	//department is the department of the employee
	
	private double salary;
	
	private Calendar hireDate;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private Department department;
	
	public static int numberOfEmployees;
	
	//Initialize the employee
	
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
		this.setSalary(salary);
		this.setHireDate(hireDate);
		this.setDepartment(department);
		Employee.numberOfEmployees++;
	}
	
	public Employee(Person person, double salary, Calendar hireDate, Department department) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicense());
		this.setSalary(salary);
		this.setHireDate(hireDate);
		this.setDepartment(department);
		Employee.numberOfEmployees++;
	}
	
	//Methods for printing, setting and updating the variables of the employee
	
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", hireDate=" + dateFormat.format(hireDate.getTime()) + ", department=" + department + "]";
	}

	public double raiseSalary(double percent) throws Exception {
		if(percent < 0) {
			throw new Exception("percent cannot be lower than zero"); // Throw new exception
		}
		this.salary += (this.salary) * percent;
		return this.salary;
	}
	
	public double raiseSalary(int amount) throws Exception {
		if(amount < 0) {
			throw new Exception("amount cannot be lower than zero"); // Throw new exception
		}
		this.salary += amount;
		return this.salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws Exception {
		if(salary < 0) {
			throw new Exception("salary cannot be lower than zero"); // Throw new exception
		}
		this.salary = salary;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public static int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public static void setNumberOfEmployees(int numberOfEmployees) throws Exception {
		if(numberOfEmployees < 0) {
			throw new Exception("number of employees cannot be lower than zero"); // Throw new exception
		}
		Employee.numberOfEmployees = numberOfEmployees;
	}

}
