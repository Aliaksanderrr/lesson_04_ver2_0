package java2.Task3EmployeeHierarchy;

public class Employee {
	private Person person;
	private Department post;

	public Employee(Person person, Department post) {
		this.person = person;
		this.post = post;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Department getPost() {
		return post;
	}

	public void setPost(Department post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return post.getName() + " - " + person.toString();
	}
}
