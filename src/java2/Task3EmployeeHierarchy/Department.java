package java2.Task3EmployeeHierarchy;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private String name;
	private Set<Employee> employeeSet = new HashSet<>();
	private Set<Department> subDepartments;

	public Department(String name, Set<Department> subDepartments) {
		this.name = name;
		this.subDepartments = subDepartments;
	}

	public Department(String name) {
		this(name, new HashSet<Department>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public Set<Department> getSubDepartments() {
		return subDepartments;
	}

	public void addSubDepartment(Department department) {
		subDepartments.add(department);
	}

	public void addEmployee(Employee employee) {
		employeeSet.add(employee);
		employee.setPost(this);
	}

}
