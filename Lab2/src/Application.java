/*
 * Application.java
 * Lab02
 * Said Rahmani
 * Yaseen Rashid
 * July 9,2024
 */
import java.util.*;

public class Application {

	
	private static Scanner scanner = new Scanner(System.in);
	private static List<Client> clients = new ArrayList<>();
	private static List<Employee> employees = new ArrayList<>();
	private static List<Pet> pets = new ArrayList<>();
	private static Map<Integer, Booking> bookings = new HashMap<>();
	private static List<Invoice> invoices = new ArrayList<>();
	private static List<DeathCertificate> deathCertificates = new ArrayList<>();

	
	public static void main(String[] args) {
		
		
		clients.add(new Client("John", "Doe", "4035678232", "42 Ave"));
        clients.add(new Client("Jane", "Doe", "4039038132", "45 Ave"));
        
        Employee supervisor = new Employee("Jack", "James", 1, new int[]{2, 3});
        Employee employee1 = new Employee("Alen", "Smith", 2, 1);
        Employee employee2 = new Employee("Jane", "Johnson", 3, 1);
        employees.add(supervisor);
        employees.add(employee1);
        employees.add(employee2);

        
        
        String[] meds1 = {"pills", "Flea prevention"};
        CareProfile joeCare = new CareProfile("No chocolate", meds1, "Give medications daily.");
        
     
        String[] meds2 = {"Antibiotics"};
        CareProfile samCare = new CareProfile("No dairy", meds2, "Finish pill bottle");
        
        Pet pet1 = new Pet("Joe", "Dog", "Brown", "Labrador",joeCare);
        Pet pet2 = new Pet("Sam", "Cat", "White", "Persian", samCare);
        pet1.setOwner(clients.get(0));
        pet2.setOwner(clients.get(1));
        
        pets.add(pet1);
        pets.add(pet2);
        
      
        
        Booking booking1 = new Booking("2024-07-09", "1 day", employee1, pet1);
        Booking booking2 = new Booking("2024-07-10", "2 days", employee2, pet2);
        
        Invoice outstandingInvoice = new Invoice(clients.get(0), "2024-07-01", booking1, false);
        
        invoices.add(outstandingInvoice);
        clients.get(0).setInvoices(invoices);
        
        bookings.put(booking1.getBookingID(), booking1);
        bookings.put(booking2.getBookingID(), booking2);
        
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Manage Clients");
            System.out.println("2. Manage Pets");
            System.out.println("3. View Bookings");
            System.out.println("4. Manage Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    manageClient();
                    break;
                case 2:
                    managePet();
                    break;
                case 3:
                    viewBooking();
                    break;
                case 4:
                    manageEmployee();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

	
	
	private static void manageClient() {
	    System.out.println("\nManage Clients:");
	    System.out.println("1. Add Client");
	    System.out.println("2. View Clients");
	    System.out.println("3. Edit Client Details");
	    System.out.println("4. Back to Main Menu");
	    System.out.print("Choose an option: ");

	    int choice = scanner.nextInt();
	    scanner.nextLine();  

	    switch (choice) {
	        case 1:
	            
	            System.out.print("Enter first name: ");
	            String firstName = scanner.nextLine();
	            System.out.print("Enter last name: ");
	            String lastName = scanner.nextLine();
	            System.out.print("Enter phone number: ");
	            String phoneNumber = scanner.nextLine();
	            System.out.print("Enter address: ");
	            String address = scanner.nextLine();

	            Client newClient = new Client(firstName, lastName, phoneNumber, address);
	            clients.add(newClient);
	            System.out.println("Client added successfully!");
	            break;
	        case 2:
	            
	            System.out.println("List of Clients:");
	            for (int i = 0; i < clients.size(); i++) {
	                System.out.println((i + 1) + ". " + clients.get(i).getFirstName() + " " + clients.get(i).getLastName());
	            }
	            
	            
	            System.out.print("Choose a client to edit (enter number) or 0 to go back: ");
	            int clientChoice = scanner.nextInt();
	            scanner.nextLine();  
	            
	            if (clientChoice > 0 && clientChoice <= clients.size()) {
	                Client selectedClient = clients.get(clientChoice - 1);
	                editClientDetails(selectedClient);
	            } else if (clientChoice == 0) {
	                
	                break;
	            } else {
	                System.out.println("Invalid client choice. Please try again.");
	            }
	            break;
	        case 3:
	            
	            System.out.print("Enter client's first name to edit details: ");
	            String editFirstName = scanner.nextLine();
	            Client editClient = null;
	            for (Client client : clients) {
	                if (client.getFirstName().equalsIgnoreCase(editFirstName)) {
	                    editClient = client;
	                    break;
	                }
	            }
	            
	            if (editClient != null) {
	                editClientDetails(editClient);
	            } else {
	                System.out.println("Client not found. Please try again.");
	            }
	            break;
	        case 4:
	            
	            break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	    }
	}

	private static void editClientDetails(Client client) {
	    System.out.println("\nEditing Client Details for " + client.getFirstName() + " " + client.getLastName() + ":");

	    System.out.println("1. Edit Phone Number (Current: " + client.getPhoneNum() + ")");
	    System.out.println("2. Edit Address (Current: " + client.getAddress() + ")");
	    System.out.println("3. View Outstanding Invoices");
	    System.out.println("4. Back to Manage Clients");
	    System.out.print("Choose an option: ");

	    int choice = scanner.nextInt();
	    scanner.nextLine();  
	    switch (choice) {
	        case 1:
	            System.out.print("Enter new phone number: ");
	            String newPhoneNumber = scanner.nextLine();
	            client.setPhoneNum(newPhoneNumber);
	            System.out.println("Phone number updated successfully.");
	            break;
	        case 2:
	            System.out.print("Enter new address: ");
	            String newAddress = scanner.nextLine();
	            client.setAddress(newAddress);
	            System.out.println("Address updated successfully.");
	            break;
	        case 3:
	            viewOutstandingInvoices(client);
	            break;
	        case 4:
	            
	            break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	    }
	}


	private static void viewOutstandingInvoices(Client client) {
	
	    List<Invoice> clientInvoices = client.getInvoice();

	    if (clientInvoices.isEmpty()) {
	        System.out.println("No outstanding invoices for " + client.getFirstName() + " " + client.getLastName());
	    } else {
	        System.out.println("Outstanding Invoices for " + client.getFirstName() + " " + client.getLastName() + ":");
	        for (Invoice invoice : clientInvoices) {
	            if (!invoice.getStatusPaid()) {
	                System.out.println(", Date: " + invoice.getDate() +
	                                   ", Booking ID: " + invoice.getBooking().getBookingID() +
	                                   ", Paid: " + (invoice.getStatusPaid() ? "Yes" : "No"));
	            }
	        }
	    }
	}

	private static void manageEmployee() {
	    System.out.println("\nManage Employees:");

	    
	    Employee selectedEmployee = selectEmployee();
	    System.out.println("Logged in as: " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName());

	    
	    if (selectedEmployee.getSupervisorID() == 0) {
	        
	        manageSupervisor(selectedEmployee);
	    } else {
	        
	        manageRegularEmployee(selectedEmployee);
	    }
	}

	
	private static void manageSupervisor(Employee supervisor) {
	    System.out.println("\nSupervisor Management Options:");
	    System.out.println("1. Add New Employee");
	    System.out.println("2. Remove Employee");
	    System.out.println("3. View Current Employees");
	    System.out.println("4. Back to Main Menu");
	    System.out.print("Choose an option: ");

	    int option = scanner.nextInt();
	    scanner.nextLine(); 

	    switch (option) {
	        case 1:
	            addNewEmployee(supervisor);
	            break;
	        case 2:
	            removeEmployee(supervisor);
	            break;
	        case 3:
	            viewEmployees(supervisor);
	            break;
	        case 4:
	          
	            break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	    }
	}


	private static void manageRegularEmployee(Employee employee) {
	    System.out.println("\nRegular Employee Management Options:");
	    System.out.println("1. Edit Supervisor ID");
	    System.out.println("2. View Current Supervisor");
	    System.out.println("3. Back to Main Menu");
	    System.out.print("Choose an option: ");

	    int option = scanner.nextInt();
	    scanner.nextLine(); 

	    switch (option) {
	        case 1:
	            editSupervisorID(employee);
	            break;
	        case 2:
	            viewCurrentSupervisor(employee);
	            break;
	        case 3:
	          
	            break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	    }
	}

	
	private static void addNewEmployee(Employee supervisor) {
	    System.out.println("\nAdding New Employee:");

	    
	    System.out.println("Current Employees under " + supervisor.getFirstName() + " " + supervisor.getLastName() + ":");
	    for (int employeeID : supervisor.getEmployeeList()) {
	        Employee employee = findEmployeeByID(employeeID);
	        if (employee != null) {
	            System.out.println("- " + employee.getFirstName() + " " + employee.getLastName());
	        }
	    }

	   
	    System.out.print("Enter new employee's first name: ");
	    String firstName = scanner.nextLine();
	    System.out.print("Enter new employee's last name: ");
	    String lastName = scanner.nextLine();

	    
	    Employee newEmployee = new Employee(firstName, lastName, employees.size(), supervisor.getIDNum());
	    employees.add(newEmployee);
	    supervisor.addNewEmployee(newEmployee.getIDNum());

	    System.out.println("Employee added successfully.");
	}

	
	private static void removeEmployee(Employee supervisor) {
	    System.out.println("\nRemoving Employee:");

	 
	    System.out.println("Current Employees under " + supervisor.getFirstName() + " " + supervisor.getLastName() + ":");
	    for (int employeeID : supervisor.getEmployeeList()) {
	        Employee employee = findEmployeeByID(employeeID);
	        if (employee != null) {
	            System.out.println("- " + employee.getFirstName() + " " + employee.getLastName());
	        }
	    }

	   
	    System.out.print("Enter employee's first name to remove: ");
	    String firstName = scanner.nextLine();
	    System.out.print("Enter employee's last name to remove: ");
	    String lastName = scanner.nextLine();

	   
	    boolean removed = false;
	    for (int i = 0; i < supervisor.getEmployeeList().length; i++) {
	        int employeeID = supervisor.getEmployeeList()[i];
	        Employee employee = findEmployeeByID(employeeID);
	        if (employee != null && employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
	            supervisor.getEmployeeList()[i] = 0; 
	            removed = true;
	            break;
	        }
	    }

	    if (removed) {
	        System.out.println("Employee removed successfully.");
	    } else {
	        System.out.println("Employee not found under this supervisor.");
	    }
	}

	
	private static void viewEmployees(Employee supervisor) {
	    System.out.println("\nCurrent Employees under " + supervisor.getFirstName() + " " + supervisor.getLastName() + ":");
	    for (int employeeID : supervisor.getEmployeeList()) {
	        Employee employee = findEmployeeByID(employeeID);
	        if (employee != null) {
	            System.out.println("- " + employee.getFirstName() + " " + employee.getLastName());
	        }
	    }
	}

	
	private static void editSupervisorID(Employee employee) {
	    System.out.println("\nEdit Supervisor ID:");

	   
	    Employee supervisor = findEmployeeByID(employee.getSupervisorID());
	    if (supervisor != null) {
	        System.out.println("Current Supervisor: " + supervisor.getFirstName() + " " + supervisor.getLastName());
	    } else {
	        System.out.println("No supervisor assigned currently.");
	    }

	
	    System.out.print("Enter new supervisor ID: ");
	    int newSupervisorID = scanner.nextInt();
	    scanner.nextLine(); 

	    employee.setSupervisorID(newSupervisorID);
	    System.out.println("Supervisor ID updated successfully.");
	}

	
	private static void viewCurrentSupervisor(Employee employee) {
	    System.out.println("\nView Current Supervisor:");

	    
	    Employee supervisor = findEmployeeByID(employee.getSupervisorID());
	    if (supervisor != null) {
	        System.out.println("Current Supervisor: " + supervisor.getFirstName() + " " + supervisor.getLastName());
	    } else {
	        System.out.println("No supervisor assigned currently.");
	    }
	}
	
	private static Employee findEmployeeByID(int id) {
	    for (Employee employee : employees) {
	        if (employee.getIDNum() == id) {
	            return employee; 
	            
	        }
	    }
	    return null; 
	}

	
	private static void managePet() {
	    System.out.println("\nManage Pets:");
	    System.out.println("1. Add Pet");
	    System.out.println("2. View Pets");
	    System.out.print("Choose an option: ");

	    int choice = scanner.nextInt();
	    scanner.nextLine();

	    switch (choice) {
	        case 1:
	            System.out.print("Enter pet name: ");
	            String name = scanner.nextLine();
	            System.out.print("Enter species: ");
	            String species = scanner.nextLine();
	            System.out.print("Enter color: ");
	            String color = scanner.nextLine();
	            System.out.print("Enter breed: ");
	            String breed = scanner.nextLine();

	            System.out.print("Enter dietary restrictions: ");
	            String diet = scanner.nextLine();
	            System.out.print("Enter medication list (comma separated): ");
	            String[] medList = scanner.nextLine().split(",");
	            System.out.print("Enter medication instructions: ");
	            String instructions = scanner.nextLine();

	            CareProfile care = new CareProfile(diet, medList, instructions);
	            Pet newPet = new Pet(name, species, color, breed, care);

	            System.out.print("Enter owner's first name: ");
	            String ownerFirstName = scanner.nextLine();
	            Client owner = null;
	            for (Client client : clients) {
	                if (client.getFirstName().equalsIgnoreCase(ownerFirstName)) {
	                    owner = client;
	                    break;
	                }
	            }

	            if (owner != null) {
	                newPet.setOwner(owner);
	                pets.add(newPet);
	                System.out.println("Pet added successfully!");
	            } else {
	                System.out.println("Owner not found. Please add the owner as a client first.");
	            }
	            break;

	        case 2:
	            if (pets.isEmpty()) {
	                System.out.println("No pets available.");
	                break;
	            }

	            System.out.println("List of Pets:");
	            for (int i = 0; i < pets.size(); i++) {
	                Pet pet = pets.get(i);
	                String assignedTo = (pet.getEmployee() != null) ? " (Assigned to: " + pet.getEmployee().getFirstName() + ")" : "";
	                System.out.println((i + 1) + ". " + pet.getName() + assignedTo);
	            }

	            System.out.print("Choose a pet to manage: ");
	            int petChoice = scanner.nextInt();
	            scanner.nextLine();

	            if (petChoice > 0 && petChoice <= pets.size()) {
	                Pet selectedPet = pets.get(petChoice - 1);
	                System.out.println("Managing Pet: " + selectedPet.getName());

	                boolean petExit = false;
	                while (!petExit) {
	                    System.out.println("\nPet Management Options:");
	                    System.out.println("1. Remove Pet");
	                    System.out.println("2. Create Death Certificate");
	                    System.out.println("3. Edit Care Profile");
	                    System.out.println("4. Assign Pet to Employee");
	                    System.out.println("5. Enter New Treatment");
	                    System.out.println("6. Back to Main Menu");
	                    System.out.print("Choose an option: ");

	                    int petOption = scanner.nextInt();
	                    scanner.nextLine();

	                    switch (petOption) {
	                        case 1:
	                            pets.remove(selectedPet);
	                            System.out.println("Pet removed successfully!");
	                            petExit = true;
	                            break;
	                        case 2:
	                            System.out.print("Enter date of death: ");
	                            String dateOfDeath = scanner.nextLine();
	                            System.out.print("Enter cause of death: ");
	                            String causeOfDeath = scanner.nextLine();
	                            DeathCertificate deathCertificate = new DeathCertificate(selectedPet, dateOfDeath, causeOfDeath);
	                            deathCertificates.add(deathCertificate);
	                            System.out.println("Death Certificate created: " + deathCertificate);
	                            petExit = true;
	                            break;
	                        case 3:
	                            System.out.print("Enter new dietary restrictions: ");
	                            String newDiet = scanner.nextLine();
	                            System.out.print("Enter new medication list (comma separated): ");
	                            String[] newMedList = scanner.nextLine().split(",");
	                            System.out.print("Enter new medication instructions: ");
	                            String newInstructions = scanner.nextLine();

	                            CareProfile newCare = new CareProfile(newDiet, newMedList, newInstructions);
	                            selectedPet.setCare(newCare);
	                            System.out.println("Care Profile updated successfully!");
	                            petExit = true;
	                            break;
	                        case 4:
	                            System.out.print("Enter employee's first name: ");
	                            String empFirstName = scanner.nextLine();

	                            Employee assignedEmployee = null;
	                            for (Employee employee : employees) {
	                                if (employee.getFirstName().equalsIgnoreCase(empFirstName)) {
	                                    assignedEmployee = employee;
	                                    break;
	                                }
	                            }

	                            if (assignedEmployee != null) {
	                                selectedPet.setEmployee(assignedEmployee);
	                                System.out.println("Pet assigned to: " + assignedEmployee.getFirstName());
	                            } else {
	                                System.out.println("Employee not found. Pet assignment not changed.");
	                            }
	                            break;
	                        case 5:
	                            System.out.print("Enter treatment details: ");
	                            String treatmentDetails = scanner.nextLine();
	                            System.out.print("Enter treatment date: ");
	                            String treatmentDate = scanner.nextLine();
	                            System.out.print("Enter employee's first name: ");
	                            String treatmentEmpFirstName = scanner.nextLine();

	                            Employee treatmentEmployee = null;
	                            for (Employee employee : employees) {
	                                if (employee.getFirstName().equalsIgnoreCase(treatmentEmpFirstName)) {
	                                    treatmentEmployee = employee;
	                                    break;
	                                }
	                            }

	                            if (treatmentEmployee != null) {
	                                Treatment newTreatment = new Treatment(selectedPet, treatmentDetails, treatmentDate, treatmentEmployee);
	                                selectedPet.getTreatments().add(newTreatment);
	                                System.out.println("Treatment added successfully!");
	                            } else {
	                                System.out.println("Employee not found. Treatment not added.");
	                            }
	                            break;
	                        case 6:
	                            petExit = true;
	                            break;
	                        default:
	                            System.out.println("Invalid choice. Please try again.");
	                    }
	                }
	            } else {
	                System.out.println("Invalid pet choice. Please try again.");
	            }
	            break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	    }
	}



	private static void viewBooking() {
	    System.out.println("List of Bookings:");
	    for (Booking booking : bookings.values()) {
	        System.out.println("Booking ID: " + booking.getBookingID() +
	                           ", Pet: " + booking.getPet().getName() +
	                           ", Date: " + booking.getDate() +
	                           ", Length: " + booking.getLength() +
	                           ", Employee: " + booking.getEmp().getFirstName());
	    }

	    System.out.println("\nOptions:");
	    System.out.println("1. Add a new booking");
	    System.out.println("2. Generate Report for a booking");
	    System.out.println("3. Back to main menu");
	    System.out.print("Choose an option: ");

	    int choice = scanner.nextInt();
	    scanner.nextLine();   

	    switch (choice) {
	        case 1:
	            addNewBooking();
	            break;
	        case 2:
	            generateReportForBooking();
	            break;
	        case 3:
	        	break;
	        default:
	            System.out.println("Invalid choice. Returning to main menu.");
	    }
	}

	private static void generateReportForBooking() {
	    System.out.print("Enter Booking ID to generate report: ");
	    int bookingId = scanner.nextInt();
	    scanner.nextLine();

	    Booking booking = bookings.get(bookingId);
	    if (booking != null) {
	        GenerateReport reportGenerator = new GenerateReport();
	        reportGenerator.setReport(booking);
	        System.out.println("Report generated for Booking ID: " + booking.getBookingID());
	        
	    } else {
	        System.out.println("Booking not found.");
	    }
	}



private static void addNewBooking() {
    System.out.print("Enter pet name: ");
    String name = scanner.nextLine();
    System.out.print("Enter species: ");
    String species = scanner.nextLine();
    System.out.print("Enter color: ");
    String color = scanner.nextLine();
    System.out.print("Enter breed: ");
    String breed = scanner.nextLine();

    
    Pet pet = findPet(name, species, color, breed);

    if (pet == null) {
        System.out.println("Pet not found. Cannot create booking.");
        return;
    }

   
    Client owner = pet.getOwner();
    if (hasOutstandingInvoice(owner)) {
        System.out.println("Cannot create booking. Owner has outstanding invoices.");
        return;
    }

    
    Employee emp = selectEmployee();

    System.out.print("Enter booking date (YYYY-MM-DD): ");
    String date = scanner.nextLine();
    System.out.print("Enter booking length: ");
    String length = scanner.nextLine();

    Booking newBooking = new Booking(date, length, emp, pet);
    bookings.put(newBooking.getBookingID(), newBooking);

    System.out.println("New booking created successfully.");
}

private static boolean hasOutstandingInvoice(Client client) {
    
    for (Invoice invoice : client.getInvoice()) {
        if (!invoice.getStatusPaid()) {
            return true;
        }
    }
    return false;
}

private static Employee selectEmployee() {
   
    System.out.println("Available Employees:");
    for (Employee emp : employees) {
        System.out.println(emp.getIDNum() + ". " + emp.getFirstName() + " " + emp.getLastName());
    }

    
    System.out.print("Select an Employee by ID: ");
    int selectedId = scanner.nextInt();
    scanner.nextLine(); 

    
    for (Employee emp : employees) {
        if (emp.getIDNum() == selectedId) {
            return emp;
        }
    }
    return null;
}

private static Pet findPet(String name, String species, String color, String breed) {
    for (Pet pet : pets) {
        if (pet.getName().equalsIgnoreCase(name) &&
            pet.getSpecies().equalsIgnoreCase(species) &&
            pet.getColor().equalsIgnoreCase(color) &&
            pet.getBreed().equalsIgnoreCase(breed)) {
            return pet;
        }
    }
    return null; 
}
}


	