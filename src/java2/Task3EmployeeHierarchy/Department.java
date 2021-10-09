package java2.Task3EmployeeHierarchy;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private final String name;
	private final Set<Employee> employeeSet = new HashSet<>();
	private final Set<Department> subDepartments;

	public Department(String name, Set<Department> subDepartments) {
		this.name = name;
		this.subDepartments = subDepartments;
	}

	public Department(String name) {
		this(name, new HashSet<>());
	}

	public String getName() {
		return name;
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
