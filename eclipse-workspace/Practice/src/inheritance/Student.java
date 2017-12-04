package inheritance;

public class Student extends Person{
	private String major;
	public Student(String name, String yearOfBirth, String major) {
		super(name, yearOfBirth);
		this.major = major;
	}
	public String toString() {
		return name + " " + yearOfBirth + " "+ major;
	}
}
