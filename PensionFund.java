package ConstructorPerson;

import java.awt.*;
import java.util.Date;
import java.util.Objects;
import java.util.List;

public class PensionFund {
    private String fundName;
    private boolean isGovernmental;
    private Date creationDate;
    private List<Worker> persons;
    //    private int participantCount;
    private String name;
    private int age;



    public PensionFund(String fundName, boolean isGovernmental, Date creationDate, List<Worker> persons, String name, int age, RenderingHints professionsWorked, double basePension) {
        this.fundName = fundName;
        this.isGovernmental = isGovernmental;
        this.creationDate = creationDate;
        this.persons = persons;
        this.name = name;
        this.age = age;

    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public boolean isGovernmental() {
        return isGovernmental;
    }

    public void setGovernmental(boolean governmental) {
        isGovernmental = governmental;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Worker> getPersons() {
        return persons;
    }

    public void setPersons(List<Worker> persons) {
        this.persons = persons;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PensionFund that = (PensionFund) o;
        return isGovernmental == that.isGovernmental && age == that.age && Objects.equals(fundName, that.fundName) && Objects.equals(creationDate, that.creationDate) && Objects.equals(persons, that.persons) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fundName, isGovernmental, creationDate, persons, name, age);
    }

    @Override
    public String toString() {
        return "PensionFund{" +
                "fundName='" + fundName + '\'' +
                ", isGovernmental=" + isGovernmental +
                ", creationDate=" + creationDate +
                ", persons=" + persons +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void info() {
        if (persons == null) {
            return;
        }
        if (isGovernmental) {
            System.out.println("Государственный фонд, используется " + persons.size() / 1000 + " тысяч человек.");
        } else {
            System.out.println("Негосударственный фонд, используется " + persons.size() + " не тысяч человек.");
        }
    }

    public double calculatePensionFor(AbleToCalculatePension obj) {
        if (isGovernmental) {
            return obj.calculatePension();
        } else {
            return 0; // Деньги из фонда украли
        }

    }

    public double calculateMedianPension() {
        if (persons == null || persons.size() == 0) {
            return 0.0;
        }
        double sum = 0.0;

        for (Worker worker : persons) {
            sum += calculatePensionFor(worker);

        }
        return sum / persons.size();
    }
}


