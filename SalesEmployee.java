import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * Student Name: Can Gok, id: 150118014
 * Sales Employee class of the program
 */

public class SalesEmployee extends RegularEmployee {
	
	private ArrayList<Product> sales = new ArrayList<Product>();
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public static int numberOfSalesEmployees; 
	
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Product> s) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department, pScore);
		for(int i = 0; i < s.size(); i++) {
			this.sales.add(s.get(i));
		}
		SalesEmployee.numberOfSalesEmployees++;
	}
	
	public SalesEmployee(RegularEmployee regularEmployee, ArrayList<Product> s) throws Exception {
		super(regularEmployee.getId(), regularEmployee.getFirstName(), regularEmployee.getLastName(), regularEmployee.getGender(), regularEmployee.getBirthDate(), regularEmployee.getMaritalStatus(), regularEmployee.getHasDriverLicense(), regularEmployee.getSalary(), regularEmployee.getHireDate(), regularEmployee.getDepartment(), regularEmployee.getPerformanceScore());
		for(int i = 0; i < s.size(); i++) {
			this.sales.add(s.get(i));
		}
		SalesEmployee.numberOfSalesEmployees++;
	}
	
	@Override
	public String toString() {
		return "Sales Employee" + "\n\t\t\t" + "Person Info [id=" + super.getId() + ", firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + ", gender=" + super.getGender() + "\n\t\t\t" + "Employee Info [salary=" + super.getSalary() + ", hireDate=" + dateFormat.format(super.getHireDate().getTime()) + "]" + "\n\t\t\t" + "Regular Employee Info [performanceScore=" + super.getPerformanceScore() + ", bonus=" + super.getBonus() + "]" + "\n\t\t\t" + sales;
	}

	public boolean addSale(Product s) {
		try {
			sales.add(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean removeSale(Product s) {
		try {
			sales.remove(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}

	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees;
	}

	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
	}

}
