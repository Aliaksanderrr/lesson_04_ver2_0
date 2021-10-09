package java2.Task3EmployeeHierarchy;

public class Company {
	private final String name;
	private final Department department;

	public Company(String name, Department departmentSet) {
		this.name = name;
		this.department = departmentSet;
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}
}
