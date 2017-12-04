package inheritance;

public class Manager extends Employee{
	public String department;
	public Manager(String name, double salary, String department) {
		super(name, salary);
		this.department = department;
	}
	public String toString() {
		return name + salary + department;
	}
}
