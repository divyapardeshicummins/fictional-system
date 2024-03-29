package trail2;

//package hospitalmanagement;

import java.util.*;

public class trial {
	static int TotalHospitalMoney = 37000000;
    public static void main(String[] args) {
    	
        HospitalManagement hospital = new HospitalManagement();
        hospital.hiredDoctors();
        
        VaccineDepartment vaccineDepartment = new VaccineDepartment();
        vaccineDepartment.initializeVaccines();
        
        Scanner scanner = new Scanner(System.in);
        
        //List<String> keyList = new ArrayList<>(vaccineDepartment.availableVaccines.keySet());

        // Generate a random index within the range of the list size
        int randomIndex ;//= new Random().nextInt(keyList.size());
                Timer timer = new Timer();

                TimerTask task = new TimerTask() {
                	//randomIndex = new Random().nextInt(keyList.size());
                	@Override
                    public void run() {
                        vaccineDepartment.Vaccinate("COVID-19");
                    }
                };

                // Set the time delay in milliseconds (e.g., 5000 ms for 5 seconds)
                long delay = 300000;

                // Schedule the task to run after the specified delay
                timer.scheduleAtFixedRate(task, 0, delay);
            
        
        while (true) {
            System.out.println("Hospital Management System Menu:");
            System.out.println("1. Add a new patient");
            System.out.println("2. Vaccinate a patient");
            System.out.println("3.View current Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter patient illness: ");
                    String patientIllness = scanner.nextLine().trim();
                    Patient newPatient = new Patient(patientName, patientAge, patientIllness);
                    
                    try {
                    	Doctor assindoc=hospital.assignDoctor(newPatient);
//                            newPatient.priority = assindoc.illness.get(patientIllness);
//                            //assindoc = hospital.assignDoctor(newPatient);
//                    	if(assindoc.patientQueue.arrqueue[2]!=null) {
//                	        System.out.println("patient 2 timing: " + assindoc.patientQueue.arrqueue[2].dateAndTime.getHours()+" ");}
                    } catch (NullPointerException e) {
                        System.out.print("An error occurred: " + e.getMessage());
                        System.out.print("we apologize for the inconvenience, \n but the doctor is currently unavailable at the moment. ");
                    }
                    

                    
                    break;
                case 2:
                    System.out.print("Enter the vaccine name to administer: ");
                    String vaccineName = scanner.nextLine();
                    vaccineDepartment.Vaccinate(vaccineName);
                    
                    break;
                case 3:
                	for(Doctor d: hospital.doctors) {
                		if(d==null) {
                			return;
                		}
                		if(d.patientQueue.peek()!=null) {
                		System.out.printf(d.getName()+"is currently attending to a patient "+ d.patientQueue.peek().getName()+"    Timing     "+d.patientQueue.peek().getDateAndTime().getHours()+":"+d.patientQueue.peek().getDateAndTime().getMinutes()+"\n");}
                		if(d.patientQueue.arrqueue[1]!=null) {
                	        System.out.println("patient 2 timing: " + d.patientQueue.arrqueue[1].dateAndTime.getHours()+" "+ d.patientQueue.arrqueue[1].dateAndTime.getMinutes());}
                		else {
                			System.out.printf(d.getName()+"is currently attending no patient yet "+"\n");
                		}
                	}
                	System.out.print(" ");
                	
                	
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

