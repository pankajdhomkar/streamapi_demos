package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamApiMain {
	
	public static void main(String[] args) {
		StreamDemoImplementation objS = new StreamDemoImplementation();
		
		List<Employee> employeeList = setValues();
		
		objS.countEmployee(employeeList);
		objS.nameDeptAll(employeeList);
		objS.avgAgeAll(employeeList);
		objS.highPayEmp(employeeList);
		objS.avgSalPerDept(employeeList);
		objS.getYoungestProdDevDept(employeeList);
		objS.getWorkExp(employeeList);
		objS.countEmployeeSalesMarket(employeeList);
		objS.avgSalMAF(employeeList);
		objS.nameAllEmployeeinDept(employeeList);
		objS.statsSal(employeeList);
		objS.partitionByAge(employeeList);
		objS.oldestEmp(employeeList);
		objS.sortEmp(employeeList);
		objS.sortEmpReverse(employeeList);
		List<Integer> list = Arrays.asList(1, 3, 4, 5, 6, 6, 7, 2);
		objS.secondLargest(list);
		System.out.println("----------------------------------------------");
		char cc = objS.getNonReptingChar("Hello Hi");
		System.out.println(cc);
		System.out.println("Given string is palindrome ? : "+ objS.isPalindromeUsingStream("ABCddCBA"));
		System.out.println("Given any string, insert a space after the first three characters using the Streams API :" + objS.insertSpaceAfterThreeChars("LoveHimachal"));
		
		List<String> wordList = Arrays.asList("AA", "BB", "CC", "AA", "BB");
		System.out.println("Wrod count is : "+objS.wordCount(wordList));
	}
	
	public static List<Employee> setValues() {
		
		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		return employeeList;
	}
}
