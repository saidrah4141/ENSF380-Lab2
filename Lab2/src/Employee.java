/*
 * Employee.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
public class Employee {
    private String firstName;
    private String lastName;
    private int idNumber;
    private int supervisorID;
    private int[] employees;

    public Employee(String firstName, String lastName, int idNumber, int[] employees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.employees = employees;
        this.supervisorID=0;
    }

    public Employee(String firstName, String lastName, int idNumber, int supervisorID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.supervisorID = supervisorID;
    }

    public void setIDNum(int idNum) {
        this.idNumber = idNum;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIDNum() {
        return this.idNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    public int getSupervisorID() {
        return this.supervisorID;
    }

    public void setSupervisorID(int id) {
        this.supervisorID = id;
    }

    public void addNewEmployee(int id) {
        int[] newEmployees = new int[this.employees.length + 1];
        System.arraycopy(this.employees, 0, newEmployees, 0, this.employees.length);
        newEmployees[this.employees.length] = id;
        this.employees = newEmployees;
    }

    public int[] getEmployeeList() {
        return this.employees;
    }
}
