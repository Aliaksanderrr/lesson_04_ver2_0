package java2.Task3EmployeeHierarchy;

public class Employee {
	private Person person;
	private Department post;
	private int wage;

	public Employee(Person person, Department post, int wage) {
		this.person = person;
		this.post = post;
		this.wage = wage;
	}

	public Person getPerson() {
		return person;
	}

	public Department getPost() {
		return post;
	}

	public int getWage() {
		return wage;
	}

	public void setPost(Department post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return post.getName() + "(зарплата: " + wage + ") - " + person.toString();
	}
}
