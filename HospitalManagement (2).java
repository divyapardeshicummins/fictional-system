package trail2;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Date;
public class HospitalManagement {
	static int TotalHospitalMoney = 37000000;
	public Doctor[] doctors = new Doctor[10];
	
	
	public void hiredDoctors() {
	    // Create 5 Doctor objects with different specializations
	    doctors[0] = new Doctor("Dr. Smith", 40, "Cardiologist");
	    doctors[1] = new Doctor("Dr. Johnson", 35, "Dermatologist");
	    doctors[2] = new Doctor("Dr. Brown", 45, "Orthopedic");
	    doctors[3] = new Doctor("Dr. Williams", 50, "Pediatrician");
	    doctors[4] = new Doctor("Dr. Davis", 38, "Neurologist");

	    // Associate illnesses with unique priorities for each doctor based on specialization
	    doctors[0].addIllness("Heart Disease", 10);
	    doctors[0].addIllness("Arrhythmia", 8);
	    doctors[0].addIllness("Hypertension", 6);
	    doctors[0].addIllness("Coronary Artery Disease", 9);
	    doctors[0].addIllness("Heart Failure", 7);
	    doctors[0].addIllness("Myocardial Infarction", 11);
	    doctors[0].addIllness("Atrial Fibrillation", 5);
	    doctors[0].addIllness("High Cholesterol", 4);
	    doctors[0].addIllness("Valvular Heart Disease", 8);
	    doctors[0].addIllness("Peripheral Artery Disease", 7);
	    doctors[0].addIllness("Cardiomyopathy", 9);
	    doctors[0].addIllness("Angina", 6);
	    doctors[0].addIllness("Congenital Heart Disease", 12);

	    doctors[1].addIllness("Acne", 4);
	    doctors[1].addIllness("Eczema", 3);
	    doctors[1].addIllness("Psoriasis", 5);
	    doctors[1].addIllness("Skin Cancer", 9);
	    doctors[1].addIllness("Rosacea", 6);
	    doctors[1].addIllness("Warts", 2);
	    doctors[1].addIllness("Moles", 1);
	    doctors[1].addIllness("Hives", 3);
	    doctors[1].addIllness("Fungal Infections", 2);
	    doctors[1].addIllness("Alopecia", 7);
	    doctors[1].addIllness("Vitiligo", 5);
	    doctors[1].addIllness("Scabies", 4);
	    doctors[1].addIllness("Cellulitis", 6);

	    doctors[2].addIllness("Fracture", 11);
	    doctors[2].addIllness("Arthritis", 9);
	    doctors[2].addIllness("Back Pain", 8);
	    doctors[2].addIllness("Tendonitis", 9);
	    doctors[2].addIllness("Osteoporosis", 10);
	    doctors[2].addIllness("Ligament Sprain", 7);
	    doctors[2].addIllness("Carpal Tunnel Syndrome", 7);
	    doctors[2].addIllness("Herniated Disc", 10);
	    doctors[2].addIllness("Plantar Fasciitis", 8);
	    doctors[2].addIllness("Frozen Shoulder", 9);
	    doctors[2].addIllness("Scoliosis", 10);
	    doctors[2].addIllness("Bursitis", 8);
	    doctors[2].addIllness("Osteoarthritis", 9);

	    doctors[3].addIllness("Childhood Infections", 5);
	    doctors[3].addIllness("Vaccination", 3);
	    doctors[3].addIllness("Asthma in Children", 6);
	    doctors[3].addIllness("Ear Infections", 4);
	    doctors[3].addIllness("Croup", 5);
	    doctors[3].addIllness("Stomach Flu", 4);
	    doctors[3].addIllness("Bronchiolitis", 7);
	    doctors[3].addIllness("Allergies in Children", 6);
	    doctors[3].addIllness("Growth Problems", 3);
	    doctors[3].addIllness("Bedwetting", 2);
	    doctors[3].addIllness("Chickenpox", 4);
	    doctors[3].addIllness("Measles", 5);
	    doctors[3].addIllness("Childhood Obesity", 7);

	    doctors[4].addIllness("Migraine", 7);
	    doctors[4].addIllness("Alzheimer's Disease", 12);
	    doctors[4].addIllness("Epilepsy", 10);
	    doctors[4].addIllness("Multiple Sclerosis", 11);
	    doctors[4].addIllness("Parkinson's Disease", 11);
	    doctors[4].addIllness("Stroke", 13);
	    doctors[4].addIllness("Neuropathy", 10);
	    doctors[4].addIllness("Cerebral Palsy", 9);
	    doctors[4].addIllness("Huntington's Disease", 12);
	    doctors[4].addIllness("Amyotrophic Lateral Sclerosis", 13);
	    doctors[4].addIllness("Neurofibromatosis", 8);
	    doctors[4].addIllness("Tourette Syndrome", 9);
	    doctors[4].addIllness("Restless Legs Syndrome", 8);
	}
	

	@SuppressWarnings("deprecation")
	

	public Doctor assignDoctor(Patient patient) {
		
	    Doctor assignedDoctor = null;

	    for (Doctor doctor : doctors) {
	    	if(doctor!=null) {
	        if (doctor.illness.keySet().contains(patient.getIllness())) {
	        	 assignedDoctor = doctor;
	        	 patient.priority=doctor.illness.get(patient.getIllness());
	        }
	        else {
	        	continue;
	        }
	    

	    //if (assignedDoctor != null) {
	        // Check if the doctor's PriorityQueue is empty
	        if (assignedDoctor.patientQueue.isEmpty()) {
	            // Set the date and time to 11:00 am today
	            Date currentDate = new Date();
	            currentDate.setHours(11);
	            currentDate.setMinutes(0);
	            currentDate.setSeconds(0);
	            patient.setDateAndTime(currentDate);
	        } else {
	            // Calculate the new date and time as the top patient's date and time plus 1800000 milliseconds
	            Date topPatientTime = assignedDoctor.patientQueue.bottom().getDateAndTime();
	            Date newDateAndTime = new Date(topPatientTime.getTime() + 1800000);
	            //if(patient.dateAndTime ==null) {
	            patient.setDateAndTime(newDateAndTime);
	        }
	        assignedDoctor.patientQueue.insert(patient);
//	        if(assignedDoctor.patientQueue.arrqueue[2]!=null) {
//	        System.out.println("patient 2 timing: " + assignedDoctor.patientQueue.arrqueue[2].dateAndTime.getHours()+" ");}
	        System.out.println("Assigned Doctor: " + assignedDoctor.getName());
	        System.out.println("Patient: " + patient.getName());
	        System.out.println("Timing: " + patient.getDateAndTime().getHours()+":"+ patient.getDateAndTime().getMinutes());
	        // Add the patient to the doctor's PriorityQueue
	        
	        
	//    }
	    return assignedDoctor;
	        }
	    
	}
	    	
	    
		return assignedDoctor;
	}


}
class VaccineDepartment extends HospitalManagement {
     Map<String, Integer> availableVaccines = new HashMap<>();
    private int TotalPatientVaccinated = 0;

    public void initializeVaccines() {
    	availableVaccines.put("COVID-19", 1000);
        availableVaccines.put("Flu Vaccine", 500);
        availableVaccines.put("Pneumococcal Vaccine", 300);
        availableVaccines.put("Hepatitis B Vaccine", 400);
        availableVaccines.put("Measles, Mumps, and Rubella (MMR) Vaccine", 600);
        availableVaccines.put("Tetanus, Diphtheria, and Pertussis (Tdap) Vaccine", 200);
        availableVaccines.put("Varicella (Chickenpox) Vaccine", 300);
        availableVaccines.put("Hepatitis A Vaccine", 250);
        availableVaccines.put("HPV (Human Papillomavirus) Vaccine", 350);
    }

    public void Vaccinate(String vaccine) {
        if (availableVaccines.containsKey(vaccine) && availableVaccines.get(vaccine) > 0) {
            // Vaccine is available, so "vaccinate" the patient
            System.out.println("Patient Vaccinated");
            // Decrease the available count of the vaccine by one
            availableVaccines.put(vaccine, availableVaccines.get(vaccine) - 1);
            // Increment the total vaccinated patients
            TotalPatientVaccinated++;
        } else {
            System.out.println("Sorry, the vaccine " + vaccine + " is not available at the moment.");
        }
    }
    public void checkAndReplenishVaccines() {
        for (Map.Entry<String, Integer> entry : availableVaccines.entrySet()) {
            String vaccineName = entry.getKey();
            int availableCount = entry.getValue();
            
            if (availableCount < 50) {
                // Replenish with 200 more vaccines
                availableVaccines.put(vaccineName, availableCount + 200);
                System.out.println("Replenished " + vaccineName + " with 200 more vaccines.");
                TotalHospitalMoney =TotalHospitalMoney -5000;
                
            }
        }
    }
}
