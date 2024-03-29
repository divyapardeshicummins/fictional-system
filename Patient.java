package trail2;

import java.time.LocalDateTime;
import java.util.Date;

public class Patient {
    private String name;
    private int age;
    private String illness;
     Date dateAndTime=null;
     public int reminder;
	public int priority;

    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }
    public Patient(String name, int age, String illness, int reminder) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.reminder=reminder;
    }

    // Getter and Setter methods for name, age, illness, and dateAndTime

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

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date currentDate) {
        this.dateAndTime = currentDate;
    }
}

