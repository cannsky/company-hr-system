import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Student Name: Can Gok, id: 150118014
 * Regular Employee class of the program
 */

public class RegularEmployee extends Employee{
	
	private double performanceScore;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private double bonus;
	
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department, double performanceScore) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department);
		this.performanceScore = performanceScore;
	}
	
	public RegularEmployee(Employee employee, double perfScore) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicense(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		this.performanceScore = perfScore;
	}
	
	@Override
	public String toString() {
		return "Regular Employee" + "\n\t\t\t" + "Person Info [id=" + super.getId() + ", firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + ", gender=" + super.getGender() + "\n\t\t\t" + "Employee Info [salary=" + super.getSalary() + ", hireDate=" + dateFormat.format(super.getHireDate().getTime()) + "]" + "\n\t\t\t" + "Regular Employee Info [performanceScore=" + getPerformanceScore() + ", bonus=" + getBonus() + "]";
	}

	public double getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(double performanceScore) throws Exception {
		if(performanceScore < 0) {
			throw new Exception("performance score cannot be lower than 0"); // Throw new exception
		}
		this.performanceScore = performanceScore;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) throws Exception {
		if(bonus < 0) {
			throw new Exception("bonus cannot be lower than 0"); // Throw new exception
		}
		this.bonus = bonus;
	}
	
}
