package java2.Task3EmployeeHierarchy.util;

import java2.Task3EmployeeHierarchy.Company;
import java2.Task3EmployeeHierarchy.Department;
import java2.Task3EmployeeHierarchy.Employee;

import java.util.ArrayList;
import java.util.List;

public class Companies {

	public static <T> T findEmployee(Company company, T result, Expression<T> func) {
		T res = result;
		List<Department> departments = new ArrayList<>();
		departments.add(company.getDepartment());
		while (departments.size() != 0) {
			departments.forEach((Department department) -> {
				department.getEmployeeSet().forEach(employee -> func.isEqual(employee, res));
			});
			departments = moveDeeper(departments);
		}
		return res;
	}

	private static List<Department> moveDeeper(List<Department> departments) {
		List<Department> subDepartments = new ArrayList<>();
		departments.forEach((dep) -> {
			if (dep.getSubDepartments() != null) {
				subDepartments.addAll(dep.getSubDepartments());
			}
		});
		return subDepartments;
	}

	public interface Expression<T> {
		void isEqual(Employee employee, T expectedType);
	}

//	public static List<Employee> findEmployee(Company company, Expression func) {
//		List<Employee> employees = new LinkedList<>();
//
//		List<Department> departments = new ArrayList<>();
//		departments.add(company.getDepartment());
//		while (departments.size() != 0) {
//			departments.forEach((Department department) -> {
//				department.getEmployeeSet().forEach(employee -> {
//					if (func.isEqual(employee, employees)) {
//						employees.add(employee);
//					}
//				});
//			});
//			departments = moveDeeper(departments);
//		}
//		return employees;
//	}
//
//	private static List<Department> moveDeeper(List<Department> departments) {
//		List<Department> subDepartments = new ArrayList<>();
//		departments.forEach((dep) -> {
//			if (dep.getSubDepartments() != null) {
//				subDepartments.addAll(dep.getSubDepartments());
//			}
//		});
//		return subDepartments;
//	}
//
//	public interface Expression {
//		boolean isEqual(Employee employee, List<Employee> selectedEmployeeList);
//	}
}
