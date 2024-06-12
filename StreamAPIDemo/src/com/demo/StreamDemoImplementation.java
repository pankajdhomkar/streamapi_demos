package com.demo;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamDemoImplementation {
	
//	How many male and female employees are there in the organization?
	public void countEmployee(List<Employee> employeeList) {
		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Count of Male and Female employee "+ noOfMaleAndFemaleEmployees);
	}
	
//	Print the name of all departments in the organization?
	public void nameDeptAll(List<Employee> employeeList) {
		System.out.print("Name of all Department ");
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
	}
	
//	What is the average age of male and female employees?
	public void avgAgeAll(List<Employee> employeeList) {
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgAgeOfMaleAndFemaleEmployees);
	}

	//	Get the details of highest paid employee in the organization?
	public void highPayEmp(List<Employee> employeeList) {
		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();

		System.out.println("Details Of Highest Paid Employee : ");

		System.out.println("==================================");

		System.out.println("ID : " + highestPaidEmployee.getId());

		System.out.println("Name : " + highestPaidEmployee.getName());

		System.out.println("Age : " + highestPaidEmployee.getAge());

		System.out.println("Gender : " + highestPaidEmployee.getGender());

		System.out.println("Department : " + highestPaidEmployee.getDepartment());

		System.out.println("Year Of Joining : " + highestPaidEmployee.getYearOfJoining());

		System.out.println("Salary : " + highestPaidEmployee.getSalary());

	}

	//	Get the names of all employees who have joined after 2015?
	public void empDateJoin(List<Employee> employeeList) {
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
		.forEach(System.out::println);
	}

	//	Count the number of employees in each department?
	public void emplDept(List<Employee> employeeList) {
		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

		for (Entry<String, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	//	What is the average salary of each department?
	public void avgSalPerDept(List<Employee> employeeList) {
		Map<String, Double> avgSalDept = employeeList.stream().collect(Collectors.groupingBy(Employee:: getDepartment, Collectors.averagingDouble(Employee :: getSalary)));
		Set<Entry<String,Double>> entrySet = avgSalDept.entrySet();
		for (Entry<String, Double> entry : entrySet) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}

	//	 Get the details of youngest male employee in the product development department?

	public void getYoungestProdDevDept(List<Employee> employeeList) {
		Optional<Employee> youngestEmp = employeeList.stream().filter(e-> e.getGender() == "Male" && e.getDepartment() == "Product Development").min(Comparator.comparingInt(Employee::getAge));
		Employee youngEmp = youngestEmp.get();
		System.out.println("----------------------------------------------");

		System.out.println("ID : "+youngEmp.getId());

		System.out.println("Name : "+youngEmp.getName());

		System.out.println("Age : "+youngEmp.getAge());

		System.out.println("Year Of Joinging : "+youngEmp.getYearOfJoining());

		System.out.println("Salary : "+youngEmp.getSalary());
	}

	//	Who has the most working experience in the organization?
	public void getWorkExp(List<Employee> employeeList) {
		Optional<Employee> workExpEmp = employeeList.stream().sorted(Comparator.comparingInt(Employee :: getYearOfJoining)).findFirst();
		Employee getWorkYear = workExpEmp.get();
		System.out.println("Senior Most Employee Details :");

		System.out.println("----------------------------");

		System.out.println("ID : "+getWorkYear.getId());

		System.out.println("Name : "+getWorkYear.getName());

		System.out.println("Age : "+getWorkYear.getAge());

		System.out.println("Gender : "+getWorkYear.getGender());

		System.out.println("Age : "+getWorkYear.getDepartment());

		System.out.println("Year Of Joinging : "+getWorkYear.getYearOfJoining());

		System.out.println("Salary : "+getWorkYear.getSalary());
	}

	//	How many male and female employees are there in the sales and marketing team?

	public void countEmployeeSalesMarket(List<Employee> employeeList) {
		Map<String, Long> countFMinSale = employeeList.stream().filter(e -> e.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee:: getGender, Collectors.counting()));
		System.out.println("Count of male and Female " + countFMinSale);
	}

	//	What is the average salary of male and female employees?
	public void avgSalMAF(List<Employee> employeeList) {
		Map<String, Double> avgSalMF = employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee :: getSalary)));
		System.out.println("AVg Salary of male and Female " + avgSalMF);
	}

	//	List down the names of all employees in each department?
	public void nameAllEmployeeinDept(List<Employee> employeeList) {
		Map<String, List<Employee>> employeeListDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String,List<Employee>>> entryset = employeeListDepartment.entrySet();
		for (Entry<String, List<Employee>> entry : entryset) {
			System.out.println("--------------------------------------");

			System.out.println("Employees In "+entry.getKey() + " : ");

			System.out.println("--------------------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) 
			{
				System.out.println(e.getName());
			}
		}
	}

	//	What is the average salary and total salary of the whole organization?
	public void statsSal(List<Employee> employeeList) {
		DoubleSummaryStatistics stats = employeeList.stream().collect(Collectors.summarizingDouble(Employee:: getSalary));
		System.out.println("Avg Salary " + stats.getAverage());
		System.out.println("Total Salary " + stats.getSum());
	}

	//	 Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
	public void partitionByAge(List<Employee> employees) {
		Map<Boolean, List<Employee>> partitionByAge = employees.stream().collect(Collectors.partitioningBy(e-> e.getAge() > 25));
		Set<Entry<Boolean, List<Employee>>> entrySet = partitionByAge.entrySet();
		for(Entry<Boolean, List<Employee>> en : entrySet) {
			System.out.println("----------------------------");

			if (en.getKey()) {
				System.out.println("Employees older than 25 years :");
			}
			else{
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = en.getValue();

			for (Employee e : list){
				System.out.println(e.getName());
			}
		}
	}

	//	Who is the oldest employee in the organization? What is his age and which department he belongs to?
	public void oldestEmp(List<Employee> employees) {
		Optional<Employee> oldEmpl = employees.stream().max(Comparator.comparingInt(Employee :: getAge));
		Employee emp = oldEmpl.get();
		System.out.println("Name " + emp.getName());
		System.out.println("Age " + emp.getAge());
		System.out.println("Department " + emp.getDepartment());
	}

	//	Sort the list based on salary and date of joining asending orger
	public void sortEmp(List<Employee> employees) {
		List<Employee> sortedEmployee = employees.stream().sorted(Comparator.comparing(Employee:: getYearOfJoining).thenComparing(Employee :: getSalary)).collect(Collectors.toList());
		sortedEmployee.forEach(System.out::println);
	}

	//	Sort the list based on salary and date of joining desending order
	public void sortEmpReverse(List<Employee> employees) {
		List<Employee> sortedEmployee = employees.stream().sorted(Comparator.comparing(Employee:: getYearOfJoining, Comparator.reverseOrder()).thenComparing(Employee :: getSalary, Comparator.reverseOrder())).collect(Collectors.toList());
		sortedEmployee.forEach(System.out::println);
	}

	public Character getNonReptingChar(String input) {  
		return input.chars()          // IntStream
				.mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))  // convert to lowercase & then to Character object Stream
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
				.entrySet().stream()                       // EntrySet stream
				.filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
				.map(entry -> entry.getKey())              // get the keys of EntrySet
				.findFirst().get();    
	}
	
//	Find the second or n largest number 
	public void secondLargest(List<Integer> listNumber) {
		
		Optional<Integer> secondLargest = listNumber.stream()
                .distinct() // Remove duplicates
                .sorted(Comparator.reverseOrder()) // Sort the stream in descending order
                .skip(2) // Skip the largest number
                .findFirst(); // Find the second largest number
		secondLargest.ifPresent(number -> System.out.println("Second Largest Number: " + number));

        // Displaying the second largest number
		int no = listNumber.stream()
        .distinct() // remove duplicates
        .sorted(Comparator.reverseOrder()) // sort in descending order
        .skip(2) // skip the first two elements
        .findFirst() // get the first element remaining, which is the third highest
        .orElseThrow(() -> new RuntimeException("List is too short")); // handle empty list
		
		System.out.println("Second Largest Number :: " + no);
        
		
	}
	
	//Insert the space after the n character
	public String insertSpaceAfterThreeChars(String text) {
		return text.chars()
				.mapToObj(c -> (char) c)
				.limit(4)
				.map(Object :: toString)
				.collect(Collectors.joining()) + " " + text.substring(4);
	}
	
	//Check the string is palindrom or not
	public boolean isPalindromeUsingStream(String text) {
		String temp = text.replaceAll("\\s+", "").toLowerCase();
		return IntStream.range(0, temp.length() / 2).noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
	}
	
	//Each word count in the string
	public Map<String, Long> wordCount(List<String> wordList){
		return wordList.stream().sorted()
	            .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
		
	}

	
	
}
