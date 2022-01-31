import java.util.ArrayList;
import java.util.Calendar;

/*
 * Student Name: Can Gok, id: 150118014
 * Manager class of the program
 */

public class Manager extends Employee {
	
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
	
	private double bonusBudget;
	
	private double unit;
	
	private double unitMultipler;
	
	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department, double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department);
		this.bonusBudget = bonusBudget;
	}
	
	public Manager(Employee employee, double bonusBudget) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicense(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		this.bonusBudget = bonusBudget;
	}
	
	@Override
	public String toString() {
		return "Manager [id:" + super.getId() + ", " + super.getFirstName() + " " + super.getLastName() + " # of employees: " + regularEmployees.size() + "]";
	}

	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}
	
	public void distrubiteBonusBudget() {
		regularEmployees.forEach( (e) -> unitMultipler += e.getSalary() * e.getPerformanceScore());
		unit = bonusBudget / unitMultipler;
		regularEmployees.forEach( (e) -> {
			try{
				e.setBonus(e.getSalary() * e.getPerformanceScore() * unit);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		});
	}

	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	public double getBonusBudget() {
		return bonusBudget;
	}

	public void setBonusBudget(double bonusBudget) {
		this.bonusBudget = bonusBudget;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public double getUnitMultipler() {
		return unitMultipler;
	}

	public void setUnitMultipler(double unitMultipler) {
		this.unitMultipler = unitMultipler;
	}
	
	
}
