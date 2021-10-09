package java2.Task3EmployeeHierarchy;

import java.util.ArrayList;
import java.util.List;

public class Task3EmployeeHierarchy {

	public static void main(String[] args) {
		Company company = createCompany();

		//TASK3_1
		System.out.println("Task3_1");
		System.out.println(treeWidth(company));

		//TASK3_2


	}

	private static Company createCompany() {
		Employee ivanov = new Employee(new Person("Василий", "Иванов"), null);
		Employee malisheva = new Employee(new Person("Ольга", "Малышева"), null);
		Employee zaisev = new Employee(new Person("Ольга", "Малышева"), null);
		Employee soteinik = new Employee(new Person("Николай", "Сотейник"), null);
		Employee velesov = new Employee(new Person("Иван", "Велесов"), null);
		Employee fontik = new Employee(new Person("Евгений", "Фотник"), null);
		Employee mozaikina = new Employee(new Person("Екатерина", "Мозайкина"), null);
		Employee petrov = new Employee(new Person("Иван", "Петров"), null);
		Employee dolgorukiy = new Employee(new Person("Александр", "Долгорукий"), null);
		Employee vodianov = new Employee(new Person("Дмитрий", "Водянов"), null);
		Employee gubin = new Employee(new Person("Андрей", "Губин"), null);
		Employee zverev = new Employee(new Person("Сергей", "Зверев"), null);
		Employee utkina = new Employee(new Person("Наталья", "Уткина"), null);

		Department directorate = new Department("Директорат");
		directorate.addEmployee(ivanov);

		Department bookkeeping = new Department("Бухгалтерия");
		bookkeeping.addEmployee(malisheva);
		bookkeeping.addEmployee(zaisev);

		Department management = new Department("Управление");
		management.addEmployee(soteinik);
		management.addEmployee(velesov);

		Department developmentManagement = new Department("Управление разработкой");
		developmentManagement.addEmployee(fontik);

		Department testManagement = new Department("Управление тестированием");
		testManagement.addEmployee(mozaikina);

		Department softwareDevelopment = new Department("Разработка ПО");
		softwareDevelopment.addEmployee(petrov);
		softwareDevelopment.addEmployee(dolgorukiy);

		Department mobileDevelopment = new Department("Мобильная разработка");
		mobileDevelopment.addEmployee(vodianov);

		Department functionalTesting = new Department("Функциональное тестирование");
		functionalTesting.addEmployee(gubin);

		Department qualityTesting = new Department("Тестирование качества");
		qualityTesting.addEmployee(zverev);
		qualityTesting.addEmployee(utkina);

		directorate.addSubDepartment(bookkeeping);
		directorate.addSubDepartment(management);
		management.addSubDepartment(developmentManagement);
		management.addSubDepartment(testManagement);
		developmentManagement.addSubDepartment(softwareDevelopment);
		developmentManagement.addSubDepartment(mobileDevelopment);
		testManagement.addSubDepartment(functionalTesting);
		testManagement.addSubDepartment(qualityTesting);

		return new Company("Фирма", directorate);
	}

	//Обход по дереву в ширину
	private static String treeWidth(Company company) {
		StringBuilder sb = new StringBuilder();
		List<Department> departments = new ArrayList<>();
		departments.add(company.getDepartmentSet());

		while (departments.size() != 0) {
			departments.forEach(department -> department.getEmployeeSet().forEach((Employee employee) -> {
				sb.append(employee.toString());
				sb.append("\n");
			}));
			departments = moveDeeper(departments);
		}
		return sb.toString();
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
}
