package ConstructorPerson;

import java.awt.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Worker extends Person implements AbleToCalculatePension {
    private int minSalary;
    private int maxSalary;
    private final static double PENSION_COEFFICIENT = 0.25;
    private final static double ADDITIONAL_COEFFICIENT = 0.05;
    private final static double COUNT_OF_PROFS = 3;
    private Set<Profession>professions;


    public Worker(String name, int age, double height, double weight, int money, int years, Gender gender, Person dad, int minSalary, int maxSalary) {
        super(name, age, height, weight, money, years, gender, dad);
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;

    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Set<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(Set<Profession> professions) {
        this.professions = professions;
    }

    @Override
    public void die() {
        System.out.println("Этот человек не дожил до пенсии.");
    }


    @Override
    public void die(int age) {
        System.out.println("Этот человек не доживет до пенсии и умрет через " + age + " лет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return minSalary == worker.minSalary && maxSalary == worker.maxSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minSalary, maxSalary);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }

    @Override
    public double calculatePension() {

        Gender gender = getGender();

        if (gender == null) {
            return 0.0;
        }

        double averageSalary;

        if (gender.equals(Gender.MALE)) {
            averageSalary = CalculatorUtils.calculateAverage(minSalary, maxSalary);
        } else {
            averageSalary = CalculatorUtils.calculateAverage(minSalary / 2, maxSalary * 2);
        }
        double additionalMoney = 0.00;
        if(professions != null){
            int coutProfession = professions.size();
            additionalMoney = 1 + coutProfession / COUNT_OF_PROFS * ADDITIONAL_COEFFICIENT;
        }
//      return averageSalary * PENSION_COEFFICIENT + (averageSalary * PENSION_COEFFICIENT * additionalMoney);
        return averageSalary * PENSION_COEFFICIENT * (1 + additionalMoney);
    }



}





