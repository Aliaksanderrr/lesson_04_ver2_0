package inJava.task3EmployeeHierarchy.util;

import inJava.task3EmployeeHierarchy.Company;
import inJava.task3EmployeeHierarchy.Department;
import inJava.task3EmployeeHierarchy.Employee;

import java.util.ArrayList;
import java.util.List;

public class Companies {

	public static <T> T findEmployee(Company company, T result, Expression<T> func) {
		List<Department> departments = new ArrayList<>();
		departments.add(company.getDepartment());
		while (departments.size() != 0) {
			departments.forEach((Department department) ->
					department.getEmployeeSet().forEach(employee -> func.isEqual(employee, result)));
			departments = moveDeeper(departments);
		}
		return result;
	}

	private static List<Department> moveDeeper(List<Department> departments) {
		List<Department> subDepartments = new ArrayList<>();
		departments.forEach((dep) -> {
			if (dep.getSubDepartmentSet() != null) {
				subDepartments.addAll(dep.getSubDepartmentSet());
			}
		});
		return subDepartments;
	}

	public interface Expression<T> {
		void isEqual(Employee employee, T expectedType);
	}
}
