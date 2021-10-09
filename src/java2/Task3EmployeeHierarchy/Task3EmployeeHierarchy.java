package java2.Task3EmployeeHierarchy;

import java2.Task3EmployeeHierarchy.util.Companies;

import java.util.List;

public class Task3EmployeeHierarchy {

	public static void main(String[] args) {
		Company company = createCompany();

		//TASK3_1
		System.out.println("Task3_1");
		Companies.Expression selectAll = ((employee, selectedEmployeeList) -> true);

		printEmployees(Companies.findEmployee(company, selectAll));

		//TASK3_2
		System.out.println("Task3_2");
		Companies.Expression minAge = ((employee, selectedEmployeeList) -> {
			if (selectedEmployeeList.isEmpty()) {
				return true;
			} else if (employee.getPerson().getAge() < selectedEmployeeList.get(0).getPerson().getAge()) {
				selectedEmployeeList.clear();
				return true;
			} else return employee.getPerson().getAge() == selectedEmployeeList.get(0).getPerson().getAge();
		});

		printEmployees(Companies.findEmployee(company, minAge));

		//TASK3_3
		System.out.println("Task3_3");
		Companies.Expression maxAge = ((employee, selectedEmployeeList) -> {
			if (selectedEmployeeList.isEmpty()) {
				return true;
			} else if (employee.getPerson().getAge() > selectedEmployeeList.get(0).getPerson().getAge()) {
				selectedEmployeeList.clear();
				return true;
			} else return employee.getPerson().getAge() == selectedEmployeeList.get(0).getPerson().getAge();
		});
		printEmployees(Companies.findEmployee(company, maxAge));

		//TASK3_4
		System.out.println("Task3_4");


	}

	private static Company createCompany() {
		Employee ivanov = new Employee(new Person("Василий", "Иванов", 45), null, 100500);
		Employee malisheva = new Employee(new Person("Ольга", "Малышева", 62), null, 1050);
		Employee zaisev = new Employee(new Person("Петр", "Зайцев", 62), null, 2500);
		Employee soteinik = new Employee(new Person("Николай", "Сотейник", 34), null, 999);
		Employee velesov = new Employee(new Person("Иван", "Велесов", 62), null, 888);
		Employee fontik = new Employee(new Person("Евгений", "Фотник", 28), null, 777);
		Employee mozaikina = new Employee(new Person("Екатерина", "Мозайкина", 28), null, 666);
		Employee petrov = new Employee(new Person("Иван", "Петров", 18), null, 555);
		Employee dolgorukiy = new Employee(new Person("Александр", "Долгорукий", 22), null, 444);
		Employee vodianov = new Employee(new Person("Дмитрий", "Водянов", 37), null, 333);
		Employee gubin = new Employee(new Person("Андрей", "Губин", 18), null, 222);
		Employee zverev = new Employee(new Person("Сергей", "Зверев", 42), null, 100);
		Employee utkina = new Employee(new Person("Наталья", "Уткина", 18), null, 100);

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

	private static void printEmployees(List<Employee> employeeList){
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
}
