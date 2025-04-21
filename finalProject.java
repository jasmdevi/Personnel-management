/*Jasmine Narayan
 * My partner for this assignment is Christian Costa
 * Final Project
 */

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;  


public class finalProject {
	
	public static boolean checkIdFormat(String id) {
		if(id.length() != 6) {
			return true;
		}
		else if(((int)id.charAt(0) < 65 || (int)id.charAt(0) > 122) || ((int)id.charAt(1) < 65 || (int)id.charAt(1) > 122)) {
			return true;
		}
		
		for(int i = 2; i < 6; i++) {
			if((int)id.charAt(i) < 48 && (int)id.charAt(i) > 57) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("report.txt");
		PersonList pl = new PersonList();
		boolean goAgain = true;
		int creditHours = 0, selection = 0, sortType = 0;
		double gpa = 0;
		String name = "", id = "", rank = "", department = "", status = "", quit ="";
		
		Scanner scan = new Scanner(System.in);
		
		//Welcome message
		System.out.println("\t\tWelcome to my Personal Management Program\n\n");
		
		while(goAgain) {
			//menu while loop
			while(goAgain) {
				while(goAgain) {
					try {
						//Menu options
						System.out.println("Choose one of the options: ");
						System.out.println("1- Enter the information of a Faculty");
						System.out.println("2- Enter the information of a Student");
						System.out.println("3- Print tuition invoice for a student");
						System.out.println("4- Print Faculty information");
						System.out.println("5- Enter the information of a staff member");
						System.out.println("6- Print the information of a staff member");
						System.out.println("7- Delete a person");
						System.out.println("8- Exit Program");
						
						System.out.println("\tEnter your selection: ");
						selection = scan.nextInt();
						scan.nextLine();
						
						if(1 <= selection && selection <= 8) {
							goAgain = false;
						}
						else {
							goAgain = true;
						}
					}//End try
					catch(Exception e) {
						System.out.println("\nInvalid entry- please try again");
					}//End catch
				}//End menu while loop
				
				//Check what the user selected
				if(selection == 1) {
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("Enter the faculty info: ");
							System.out.println("\tName of the Faculty: ");
							name = scan.nextLine();
							goAgain = false;
						}//end try
						catch(Exception e) {
							System.out.println("\tInvalid input. Try again...\n");
							goAgain = true;
						}//end catch
					}//End Name while loop
					
					//Reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tID: ");
							id = scan.nextLine();
							
							if(checkIdFormat(id)) {
								goAgain = true;
								throw new Exception();
							}
							else if(pl.checkId(id)) {
								goAgain = true;
								throw new NullPointerException();
							}
							else {
								goAgain = false;
							}
						}
						catch(NullPointerException e) {
							System.out.println("\tID alreay exists\n");
						}
						catch(Exception e) {
							System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit\n");
						}
					}//End ID while loop
					
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tRank: ");
							rank = scan.nextLine();
							
							if(rank.compareToIgnoreCase("professor") != 0 && rank.compareToIgnoreCase("adjunct") != 0) {
								throw new Exception();
							}
							else {
								goAgain = false;
							}
						}
						catch(Exception e) {
							System.out.println("\t\"" + rank + "\" is invalid\n");
						}
					}//End TITLE while loop
					
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tDepartment: ");
							department = scan.nextLine();
							
							if(department.compareToIgnoreCase("mathematics") != 0 && department.compareToIgnoreCase("engineering") != 0 && department.compareToIgnoreCase("english") != 0) {
								throw new Exception();
							}
							else {
								goAgain = false;
							}
						}
						catch(Exception e) {
							System.out.println("\tInvalid department. Please enter mathematics, engineering, or english.\n");
						}
					}//End Department while loop
					
					//Create Faculty and add to list
					Faculty f = new Faculty(id, name, department, rank);
					pl.hire(f);
					System.out.println("Faculty added!\n\n");
					
					//reset variable
					goAgain = true;
				}//end option 1
				else if(selection == 2) {
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("Enter the student info: ");
							System.out.println("\tName of Student: ");
							name = scan.nextLine();
							goAgain = false;
						}//end try
						catch(Exception e) {
							System.out.println("\tInvalid input. Try again...\n");
							goAgain = true;
						}//end catch
					}//End Name while loop
					
					//Reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tID: ");
							id = scan.nextLine();
							
							if(checkIdFormat(id)) {
								goAgain = true;
								throw new Exception();
							}
							else if(pl.checkId(id)) {
								goAgain = true;
								throw new NullPointerException();
							}
							else {
								goAgain = false;
							}
						}
						catch(NullPointerException e) {
							System.out.println("\tID alreay exists\n");
						}
						catch(Exception e) {
							System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit\n");
						}
					}//End ID while loop
					
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tGpa: ");
							gpa = scan.nextDouble();
							scan.nextLine();
							if(gpa < 0.0 || gpa > 4.0) {
								goAgain = true;
								throw new Exception();
							}
							goAgain = false;
						}
						catch(Exception e){
							System.out.println("\tInvalid Gpa. Must be between 0.0 and 4.0\n");
						}
					}//End GPA while loop
					
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tCredit hours: ");
							creditHours = scan.nextInt();
							scan.nextLine();
							if(creditHours < 0) {
								throw  new Exception();
							}
							goAgain = false;
						}
						catch(Exception e) {
							System.out.println("\tInvalid Credit hours\n");
						}
					}//End Credit Hours while loop
					
					//Create Student and add to list
					Student s = new Student(id, name, gpa, creditHours);
					pl.hire(s);
					System.out.println("Student added!\n\n");
					//reset variable
					goAgain = true;
				}//end option 2
				else if(selection == 3) {
						try {
							System.out.println("Enter the student's id: ");
							id = scan.nextLine();
							
							if(pl.printPeople(id)) {
								throw new Exception();
							}
						}
						catch(Exception e) {
							System.out.println("No student matched!");
						}
						//reset variable
						goAgain = true;
				}//end option 3
				else if(selection == 4) {
						try {
							System.out.println("Enter the faculty's id: ");
							id = scan.nextLine();
							
							if(pl.printPeople(id)) {
								throw new Exception();
							}
						}
						catch(Exception e) {
							System.out.println("No faculty matched!");
						}
						//reset variable
						goAgain = true;
				}//end option 4
				else if(selection == 5) {
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("Enter the staff member's info: ");
							System.out.println("\tName of the staff member: ");
							name = scan.nextLine();
							goAgain = false;
						}//end try
						catch(Exception e) {
							System.out.println("\tInvalid input. Try again...\n");
							goAgain = true;
						}//end catch
					}//End Name while loop
					
					//Reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tEnter the id: ");
							id = scan.nextLine();
							
							if(checkIdFormat(id)) {
								goAgain = true;
								throw new Exception();
							}
							else if(pl.checkId(id)) {
								goAgain = true;
								throw new NullPointerException();
							}
							else {
								goAgain = false;
							}
						}
						catch(NullPointerException e) {
							System.out.println("\tID alreay exists\n");
						}
						catch(Exception e) {
							System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit\n");
						}
					}//End ID while loop
					
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tDepartment: ");
							department = scan.nextLine();
							
							if(department.compareToIgnoreCase("mathematics") != 0 && department.compareToIgnoreCase("engineering") != 0 && department.compareToIgnoreCase("english") != 0) {
								throw new Exception();
							}
							else {
								goAgain = false;
							}
						}
						catch(Exception e) {
							System.out.println("\tInvalid department. Please enter mathematics, engineering, or english.\n");
						}
					}//End Department while loop
					
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("\tStatus, Enter P for Part Time, or F for Full Time: ");
							status = scan.nextLine();
							if(status.compareToIgnoreCase("p") != 0 && status.compareToIgnoreCase("f") != 0) {
								throw new Exception();
							}
							else {
								if(status.compareToIgnoreCase("p") == 0) {
									status = "part-time";
								}
								else {
									status = "full-time";
								}
								goAgain = false;
							}
						}
						catch(Exception e) {
							System.out.println("\tInvalid Status. Please enter P or F\n");
						}
					}//end status while loop
					
					//Create Faculty and add to list
					Staff st = new Staff(id, name, department, status);
					pl.hire(st);
					System.out.println("Staff member added!\n\n");
					//reset variable
					goAgain = true;
				}//end option 5
				else if(selection == 6) {
						try {
							System.out.println("Enter the staff's id: ");
							id = scan.nextLine();
							
							if(pl.printPeople(id)) {
								throw new Exception();
							}
						}
						catch(Exception e) {
							System.out.println("No staff member matched!");
						}
						//reset variable
						goAgain = true;
				}//end option 6
				else if(selection == 7) {
						try {
							System.out.println("Enter the id of the person to delete: ");
							id = scan.nextLine();
							
							if(pl.delete(id)) {
								throw new Exception();
							}
							else {
								System.out.println("Delete successful!");
							}
						}
						catch(Exception e) {
							System.out.println("Sorry no such person exists.");
						}
						//reset variable
						goAgain = true;
				}//end option 7
				else if(selection == 8) {
					//reset variable
					goAgain = true;
					while(goAgain) {
						try {
							System.out.println("Would you like to cretate a report? (y/n): ");
							quit = scan.nextLine();
							if(quit.compareToIgnoreCase("y") != 0 && quit.compareToIgnoreCase("n") != 0) {
								throw new Exception();
							}
							goAgain = false;
						}
						catch(Exception e) {
							System.out.println("Invalid input...");
						}	
					}//end report while loop
					if(quit.compareToIgnoreCase("n") == 0) {
						goAgain = false;
						System.out.println("Goodbye!");
					}
					else {
						//reset  variable
						goAgain = true;
						while(goAgain) {
							try {
								System.out.println("Would you like to sort your students by decending gpa or name (1 for gpa, 2 for name): ");
								sortType = scan.nextInt();
								scan.nextLine();
								if(sortType != 1 && sortType != 2) {
									throw new Exception();
								}
								goAgain = false;
							}
							catch(Exception e) {
								System.out.println("Invalid input...");
							}
						}//end Sort while loop
						
						//sort by gpa
						if(sortType == 1) {
							int counter = 0;
							writer.println("Faculty Members");
							writer.println("-------------------------");
							
							for(int index = 0; index < pl.getListSize(); index++) {
								if(pl.getList().get(index) instanceof Faculty) {
									counter++;
									writer.println((counter) + ". " + pl.getList().get(index).getName());
									writer.println("\tID: " + pl.getList().get(index).getId());
									writer.println(pl.getList().get(index));
								}
							}
							
							//reset counter
							counter = 0;
							
							writer.println("\n\nStaff Members");
							writer.println("-------------------------");
							for(int index = 0; index < pl.getListSize(); index++) {
								if(pl.getList().get(index) instanceof Staff) {
									counter++;
									writer.println((counter) + ". " + pl.getList().get(index).getName());
									writer.println("\tID: " + pl.getList().get(index).getId());
									writer.println(pl.getList().get(index));
								}
							}
							
							//reset counter
							counter = 0;
							
							//sort by gpa
							ArrayList<Person> studentsByGpa = new ArrayList<>();
							for(int index = 0; index < pl.getListSize(); index++) {
								if(pl.getList().get(index) instanceof Student) {
									studentsByGpa.add(pl.getList().get(index));
								}
							}
							
							Collections.sort(studentsByGpa, new Sortbyroll());
							
							counter = 0;
							writer.println("\n\nStudents");
							writer.println("-------------------------");
							for(int index = 0; index < studentsByGpa.size(); index++) {
									counter++;
									writer.println((counter) + ". " + studentsByGpa.get(index).getName());
									writer.println("\tID: " + studentsByGpa.get(index).getId());
									writer.println(studentsByGpa.get(index));
							}
							//Done writing to file
							writer.close();
							System.out.println("Goodbye!");
						}
						//sort by name
						else {
							int counter = 0;
							writer.println("Faculty Members");
							writer.println("-------------------------");
							
							for(int index = 0; index < pl.getListSize(); index++) {
								if(pl.getList().get(index) instanceof Faculty) {
									counter++;
									writer.println((counter) + ". " + pl.getList().get(index).getName());
									writer.println("\tID: " + pl.getList().get(index).getId());
									writer.println(pl.getList().get(index));
								}
							}
							
							//reset counter
							counter = 0;
							
							writer.println("\n\nStaff Members");
							writer.println("-------------------------");
							for(int index = 0; index < pl.getListSize(); index++) {
								if(pl.getList().get(index) instanceof Staff) {
									counter++;
									writer.println((counter) + ". " + pl.getList().get(index).getName());
									writer.println("\tID: " + pl.getList().get(index).getId());
									writer.println(pl.getList().get(index));
								}
							}
							
							//reset counter
							counter = 0;
							
							//sort by name
							Collections.sort(pl.getList(), new Sortbyname());
							writer.println("\n\nStudents");
							writer.println("-------------------------");
							for(int index = 0; index < pl.getListSize(); index++) {
								if(pl.getList().get(index) instanceof Student) {
									counter++;
									writer.println((counter) + ". " + pl.getList().get(index).getName());
									writer.println("\tID: " + pl.getList().get(index).getId());
									writer.println(pl.getList().get(index));
								}
							}
							//Done writing to file
							writer.close();
							System.out.println("Goodbye!");
						}
					}//end report
				}//end option 8
			}//End menu while loop
		}//End main while loop
	}//End main 
}//end finalProject class

//_________________________
abstract class Person{
	private String Id;
	private String name;
	
	public String getId() {
		return Id;
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	Person(){
		Id = null;
		name = null;
	}
	
	Person(String Id, String name){
		this.Id = Id;
		this.name = name;
	}
	
	public abstract void print();
}

//________________________
class Student extends Person{
	private double gpa;
	private int creditHours;
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	Student(){
		gpa = 0.0;
		creditHours = 0;
	}
	
	Student(double gpa, int creditHours){
		this.gpa = gpa;
		this.creditHours = creditHours;
	}
	
	Student(String Id, String name, double gpa, int creditHours){
		super(Id, name);
		this.gpa = gpa;
		this.creditHours = creditHours;
	}
	
	public double getTotal() {
		if(gpa >= 3.85) {
			return ((236.45 * creditHours) + 52) * 0.75;
		}
		return ((236.45 * creditHours) + 52);
	}
	
	public double getSavings() {
		if(gpa >= 3.85) {
			return ((236.45 * creditHours) + 52) * 0.25;
		}
		return 0;
	}
	
	public void print() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(getName() + "\t\t\t" + getId());
		System.out.println("Credit Hours: " + creditHours + " ($236.45/credit hour)");
		System.out.println("Fees: $52");
		System.out.printf("%s%.2f%s%.2f%s", "Total payment (after discount): $", getTotal(), "\t($", getSavings(), " discount applied)");
		System.out.println("\n---------------------------------------------------------------------------");
	}
	
	public String toString() {
		return "\tGpa: " + gpa +"\n" + "\tCredit hours: " + creditHours;
	}
}

//________________________
abstract class Employee extends Person{
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if(department == null) this.department = department;
		else {
			department = department.toLowerCase();
			String s = department.substring(0, 1).toUpperCase();
			this.department = s + department.substring(1);
		}
	}

	Employee(){
		department = null;
	}
	
	Employee(String department){
		if(department == null) this.department = department;
		else {
			department = department.toLowerCase();
			String s = department.substring(0, 1).toUpperCase();
			this.department = s + department.substring(1);
		}
	}
	Employee(String Id, String name, String department){
		super(Id, name);
		if(department == null) this.department = department;
		else {
			department = department.toLowerCase();
			String s = department.substring(0, 1).toUpperCase();
			this.department = s + department.substring(1);
		}
	}
	
}

//________________________
class Staff extends Employee{
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	Staff(){
		status = null;
	}
	
	Staff(String status){
		this.status = status;
	}
	
	Staff(String department, String status){
		super(department);
		this.status = status;
	}
	
	Staff(String Id, String name, String department, String status){
		super(Id, name, department);
		this.status = status;
	}
	
	public void print() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(getName() + "\t\t\t" + getId());
		System.out.println(getDepartment() + " Department, " + getStatus());
		System.out.println("---------------------------------------------------------------------------");
	}
	
	public String toString() {
		return "\t" + getDepartment() + ", " + status;
	}
}

//________________________
class Faculty extends Employee{
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	Faculty(){
		title = null;
	}
	
	Faculty(String title){
		this.title = title;
	}
	
	Faculty(String department, String title){
		super(department);
		this.title = title;
	}
	
	Faculty(String Id, String name, String department, String title){
		super(Id, name, department);
		this.title = title;
	}
	
	public void print() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(getName() + "\t\t\t" + getId());
		System.out.println(getDepartment() + " Department, " + getTitle());
		System.out.println("---------------------------------------------------------------------------");
	}
	
	public String toString() {
		return "\t" + title + ", " + getDepartment();
	}
}

class Sortbyroll implements Comparator {
	 
    // Method
    // Sorting in descending order of gpa
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return (int)((((Student)o1).getGpa() * 100) - (((Student)o2).getGpa() * 100));
	}
}

class Sortbyname implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return ((Person) o1).getName().compareTo(((Person)o2).getName());
	}
}

class PersonList{
	private ArrayList<Person> list;
	private int listSize;
	
	
	public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		this.list = list;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public PersonList() {
		list = new ArrayList<>();
	}
	
	//returns true if the id already exists
	public boolean checkId(String id) {
		int index;

		for(index = 0;index < list.size(); index++) {
			if(id.compareTo(list.get(index).getId()) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hire( Person person ) {
		//Add to the ArrayList
		list.add(person);
		listSize++;
		return true;
	}
	
	public boolean delete(String id) {
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getId().compareTo(id) == 0) {
				list.remove(index);
				listSize--;
				return false;
			}
		}
		return true;
	}
	
	public boolean printPeople(String id){
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getId().compareTo(id) == 0 && list.get(index) instanceof Faculty) {
				((Faculty)list.get(index)).print();
				return false;
			}
			else if(list.get(index).getId().compareTo(id) == 0 && list.get(index) instanceof Staff) {
				((Staff)list.get(index)).print();
				return false;
			}
			else if(list.get(index).getId().compareTo(id) == 0 && list.get(index) instanceof Student) {
				((Student)list.get(index)).print();
				return false;
			}
		}
		return true;
	}
}