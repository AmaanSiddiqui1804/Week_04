/* Group Objects by Property
Given a list of Employee objects, group them by their department using a Map<Department, List<Employee>>.
Example:
Employees: [Alice (HR), Bob (IT), Carol (HR)] → Output: HR: [Alice, Carol], IT: [Bob].
 */
package com.map_interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee{
    private String employeeName ;
    private String employeeDepartment ;

    public Employee(String employeeName, String employeeDepartment) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    @Override
    public String toString() {
        return employeeName;
    }
}
class AddEmployee {
    ArrayList<Employee> employees ;

    public AddEmployee() {
        employees = new ArrayList<>();
    }

    //Adding employees to Arraylist
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    //Method to group employees by department
    public Map<String, List<Employee>> groupByDepartment() {
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        for (Employee emp : employees) {
            if (!departmentMap.containsKey(emp.getEmployeeDepartment())){
                departmentMap.put(emp.getEmployeeDepartment(), new ArrayList<>());
            }
            departmentMap.get(emp.getEmployeeDepartment()).add(emp);
        }
        return departmentMap;
    }

    // Method to display grouped employees
    public void displayGroupedEmployees() {
        Map<String, List<Employee>> groupedEmployees = groupByDepartment();
        for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
public class GroupObjects {
    public static void main(String[] args) {

        AddEmployee employee1 = new AddEmployee();

        //Adding employees
        employee1.addEmployee(new Employee("Amaan", "HR"));
        employee1.addEmployee(new Employee("Nishank", "HR"));
        employee1.addEmployee(new Employee("Abhay", "IT"));
        employee1.addEmployee(new Employee("Sonu", "IT"));
        employee1.addEmployee(new Employee("Tikesh", "Mechanical"));

        //Displaying employee details
        employee1.displayGroupedEmployees();

    }
}
