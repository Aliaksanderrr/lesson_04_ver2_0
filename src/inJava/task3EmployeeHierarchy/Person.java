package inJava.task3EmployeeHierarchy;

public class Person {
	private final String firstName;
	private final String lastName;
	private final int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + "(" + age + " лет)";
	}
}
