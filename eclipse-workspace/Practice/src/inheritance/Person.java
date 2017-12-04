package inheritance;

public abstract class Person {
	protected String name;
	protected String yearOfBirth;
	public Person(String name, String yearOfBirth) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
	}
	public abstract String toString();
}
