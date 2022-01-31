import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/*
 * Name: Can
 * Surname: Gok
 * id: 150118014
 * Gets inputs from inputs.txt file,
 * Creates classes in object Arraylist
 * updates product and project for updating objects
 * static object variables are used inside foreach loops of object ArrayList
 * after creating objects from input.txt file, updates the objects
 * writes objects to output.txt
 */

public class Test {
	
	static ArrayList<Object> object = new ArrayList<Object>();
	
	static ArrayList<Product> product = new ArrayList<Product>();
	
	static ArrayList<Project> project = new ArrayList<Project>();
	
	static Department departmentOfEmployee;
	
	static int objectIndex = 0;
	
	static double salesPrice = 0;
	
	static double topSales = 0;
	
	static int topIndex = 0;

	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			
			ArrayList<String> inputArray = new ArrayList<>();
			
			String[] inputStringArray;
			
			File file = new File("input.txt");
			
			Scanner input = new Scanner(file);
			
			while(input.hasNext()) {
				
				inputArray.clear();
				
				inputStringArray = input.nextLine().split(" ");
				
				for(int i = 0; i < inputStringArray.length; i++) {
					
					inputArray.add(inputStringArray[i]);
					
				}
				
				object.add(createClass(inputArray));
				
			}
			
			updateManagers();
			
			updateEmployees();
			
			print();
			
			input.close();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		

	}
	
	public static void updateEmployees() {
		
		object.forEach( (manager) -> {
			
			if(manager instanceof Manager) {
				
				((Manager) manager).distrubiteBonusBudget();
				
				try{
					((Manager) manager).raiseSalary(0.2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		object.forEach( (regularEmployee) -> {
			
			if(regularEmployee instanceof RegularEmployee) {
				
				try {
					((RegularEmployee) regularEmployee).raiseSalary(0.3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		object.forEach( (developer) -> {
			
			if(developer instanceof Developer) {
				
				try{
					((Developer) developer).raiseSalary(0.23);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		Test.objectIndex = 0;
		
		object.forEach( (salesEmployee) -> {
			
			if(salesEmployee instanceof SalesEmployee) {
				
				try{
					((SalesEmployee) salesEmployee).raiseSalary(0.18);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				((SalesEmployee) salesEmployee).getSales().forEach( (sale) -> {
					
					Test.salesPrice += sale.getPrice();
					
					if(Test.topSales < Test.salesPrice) {
						
						Test.topSales = Test.salesPrice;
						
						Test.topIndex = Test.objectIndex;
					}
					
				});
				
			}
			
			Test.objectIndex++;
			
		});
		
		if(object.get(topIndex) instanceof SalesEmployee) {
			
			try{
				((Employee) object.get(topIndex)).raiseSalary(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void updateManagers() {
		
		Test.objectIndex = 0;
		
		object.forEach( (manager) -> {
			
			if(manager instanceof Manager) {
				
				final Department department = ((Manager) manager).getDepartment();
				
				Test.object.forEach( (regularEmployee) -> {
					
					if(regularEmployee instanceof RegularEmployee) {
					
						if(((RegularEmployee) regularEmployee).getDepartment().equals(department)) {
							
							((Manager) manager).addEmployee((RegularEmployee) regularEmployee);
							
						}
					
					}
					
					Test.objectIndex++;
					
				});

			}
			
		});
		
	}
	
	public static void print() throws FileNotFoundException {
		
		File file = new File("output.txt");
		
		PrintWriter printWriter = new PrintWriter(file);
		
		object.forEach( (department) -> {
			
			if(department instanceof Department) {
				
				printWriter.println("***********************************");
				
				printWriter.println(department);
				
				printWriter.print("\t");
				
				Test.object.forEach( (manager) -> {
					
					if(manager instanceof Manager) {
						
						if(((Manager) manager).getDepartment().equals(department)) {
							
							printWriter.println(manager);
							
							Test.objectIndex = 0;
							
							((Manager) manager).getRegularEmployees().forEach( (regularEmployee) -> {
								
								Test.objectIndex++;
								
								printWriter.println("\t\t" + objectIndex + ". " + regularEmployee);
								
							});
							
						}
						
					}
					
				});
				
			}
			
		});
		
		printWriter.println("*****************CUSTOMERS******************");
		
		object.forEach( (customer) -> {
			
			if(customer instanceof Customer) {
				
				printWriter.println(customer);
				
			}
			
		});
		
		printWriter.println("*****************PEOPLE******************");
		
		object.forEach( (person) -> {
			
			if(person instanceof Person) {
				
				if(!((person instanceof Customer) || (person instanceof Employee))) {
					
					printWriter.println(person);
				}
				
			}
			
		});
		
		printWriter.close();
		
	}
	
	public static Object createClass(ArrayList<String> inputArray) throws Exception {
		
		String className = inputArray.get(0);
		
		Test.objectIndex = 0;
		
		Test.product.clear();
		
		Test.project.clear();
		
		if(className.equals("Department")) {
			
			int departmentId = Integer.parseInt(inputArray.get(1));
			
			String departmentName = inputArray.get(2);
			
			return new Department(departmentId, departmentName);
			
		} else if (className.equals("Project")) {
			
			String projectName = inputArray.get(1);
			
			String projectDateString[] = inputArray.get(2).split("/");
			
			Calendar projectDate = Calendar.getInstance();
			
			projectDate.set(Integer.parseInt(projectDateString[2]), Integer.parseInt(projectDateString[0]), Integer.parseInt(projectDateString[1]));
			
			String projectState = inputArray.get(3);
			
			return new Project(projectName, projectDate, projectState);
			
		} else if (className.equals("Product")) {
			
			String productName = inputArray.get(1);
			
			String productDateString[] = inputArray.get(2).split("/");
			
			Calendar productDate = Calendar.getInstance();
			
			productDate.set(Integer.parseInt(productDateString[2]), Integer.parseInt(productDateString[0]), Integer.parseInt(productDateString[1]));
			
			double price = Double.parseDouble(inputArray.get(3));
			
			return new Product(productName, productDate, price);
			
		} else if (className.equals("Person")) {
			
			String firstName = inputArray.get(1);
			
			String lastName = inputArray.get(2);
			
			int id = Integer.parseInt(inputArray.get(3));
			
			String gender = inputArray.get(4);
			
			String birthDateString[] = inputArray.get(5).split("/");
			
			Calendar birthDate = Calendar.getInstance();
			
			birthDate.set(Integer.parseInt(birthDateString[2]), Integer.parseInt(birthDateString[0]), Integer.parseInt(birthDateString[1]));
			
			String martialStatus = inputArray.get(6);
			
			String hasDriverLicense = inputArray.get(7);
			
			return new Person(id, firstName, lastName, gender, birthDate, martialStatus, hasDriverLicense);
			
		} else if (className.equals("Employee")) {
			
			int id = Integer.parseInt(inputArray.get(1));
			
			double salary = Double.parseDouble(inputArray.get(2));
			
			String hireDateString[] = inputArray.get(3).split("/");
			
			Calendar hireDate = Calendar.getInstance();
			
			hireDate.set(Integer.parseInt(hireDateString[2]), Integer.parseInt(hireDateString[0]), Integer.parseInt(hireDateString[1]));
			
			String departmentName = inputArray.get(4);
			
			object.forEach( (object) -> {
				
				if(object instanceof Department) {
					
					if(((Department)object).getDepartmentName().equals(departmentName)) {
						
						Test.departmentOfEmployee = (Department) object;
						
					}
					
				}
				
			});
			
			object.forEach( (object) -> {
				
				if(object instanceof Person) {
					
					if(((Person)object).getId() == id) {
						
						try{
							object = new Employee((Person)object, salary, hireDate, Test.departmentOfEmployee);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						Test.object.set(Test.objectIndex, object);
					
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
		} else if (className.equals("Manager")) {
			
			int id = Integer.parseInt(inputArray.get(1));
			
			double bonusBudget = Double.parseDouble(inputArray.get(2));
			
			object.forEach( (object) -> {
				
				if(object instanceof Employee) {
					
					if(((Employee)object).getId() == id) {
						
						try {
							object = new Manager((Employee)object, bonusBudget);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						Test.object.set(Test.objectIndex, object);
					
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
		} else if (className.equals("RegularEmployee")) {
			
			int id = Integer.parseInt(inputArray.get(1));
			
			double performanceScore = Double.parseDouble(inputArray.get(2));
			
			object.forEach( (object) -> {
				
				if(object instanceof Employee) {
					
					if(((Employee)object).getId() == id) {
						
						try {
							object = new RegularEmployee((Employee)object, performanceScore);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						Test.object.set(Test.objectIndex, object);
					
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
		} else if (className.equals("SalesEmployee")) {
			
			int id = Integer.parseInt(inputArray.get(1));
			
			object.forEach( (object) -> {
				
				if(object instanceof Product) {
					
					for(int i = 1; i < inputArray.size(); i++) {
						
						if(inputArray.get(i).equals(((Product) object).getProductName())) {
							
							Test.product.add((Product)object);
							
						}
						
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
			Test.objectIndex = 0;
			
			object.forEach( (object) -> {
				
				if(object instanceof RegularEmployee) {
					
					if(((RegularEmployee)object).getId() == id) {
						
						try {
							object = new SalesEmployee((RegularEmployee)object, Test.product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						Test.object.set(Test.objectIndex, object);
					
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
		} else if (className.equals("Developer")) {
			
			int id = Integer.parseInt(inputArray.get(1));
			
			object.forEach( (object) -> {
				
				if(object instanceof Project) {
					
					for(int i = 1; i < inputArray.size(); i++) {
						
						if(inputArray.get(i).equals(((Project) object).getProjectName())) {
							
							Test.project.add((Project)object);
							
						}
						
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
			Test.objectIndex = 0;
			
			object.forEach( (object) -> {
				
				if(object instanceof RegularEmployee) {
					
					if(((RegularEmployee)object).getId() == id) {
						
						try {
							object = new Developer((RegularEmployee)object, Test.project);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						Test.object.set(Test.objectIndex, object);
					
					}
					
				}
				
				Test.objectIndex++;
				
			});

		} else if (className.equals("Customer")) {
			
			int id = Integer.parseInt(inputArray.get(1));
			
			object.forEach( (object) -> {
				
				if(object instanceof Product) {
					
					for(int i = 1; i < inputArray.size(); i++) {
						
						if(inputArray.get(i).equals(((Product) object).getProductName())) {
							
							Test.product.add((Product)object);
							
						}
						
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
			Test.objectIndex = 0;
			
			object.forEach( (object) -> {
				
				if(object instanceof Person) {
					
					if(((Person)object).getId() == id) {
						
						try {
						object = new Customer((Person)object, Test.product);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						Test.object.set(Test.objectIndex, object);
					
					}
					
				}
				
				Test.objectIndex++;
				
			});
			
		}
		
		return null;
		
	}

}
