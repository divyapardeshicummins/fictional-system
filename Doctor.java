package trail2;

import java.util.HashMap;
import java.util.Map;

public class Doctor {
    private String name;
    private int age;
    private String specialization;
    public Map<String, Integer> illness;
     PriorityQueue patientQueue;

    public Doctor(String name, int age, String specialization) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
        this.illness = new HashMap<String, Integer>();
        this.patientQueue=new PriorityQueue();
    }
//    public void assignDoctor(Patient patient) {
//        for (Doctor doctor : doctors) {
//            if (doctor.illness).containsKey(patient.getIllness())) {
//                doctor.insert(patient); // Assign the patient to the doctor
//                return; // Return immediately to prevent multiple assignments
//            }
//        }
//    }
    // Getter and Setter methods for name, age, specialization

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Methods to work with the illness map

    public void addIllness(String illnessName, int patientsCount) {
        illness.put(illnessName, patientsCount);
    }

    public int getPatientsCountForIllness(String illnessName) {
        return illness.getOrDefault(illnessName, 0);
    }

//    public Map<String, Integer> getIllness() {
//        return illness;
//    }
//
//    public void setIllness(Map<String, Integer> illness) {
//        this.illness = illness;
//    }

   
}
