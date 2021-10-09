package java2.Task3EmployeeHierarchy;

public class Company {
	private String name;
	private Department departmentSet;

	public Company(String name, Department departmentSet) {
		this.name = name;
		this.departmentSet = departmentSet;
	}

	public String getName() {
		return name;
	}

	public Department getDepartmentSet() {
		return departmentSet;
	}
}
