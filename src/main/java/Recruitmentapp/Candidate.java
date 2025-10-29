package Recruitmentapp;

public class Candidate {

    private String name;
    private int age;
    private int id;
    private String industry;
    private int yearsOfExperience;

    public Candidate(String industry, String name, int age, int yearsOfExperience) {
        this.industry = industry;
        this.name = name;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Namn: %s | Ålder: %d | Bransch: %s | Erfarenhet: %d år",
                id, name, age, industry, yearsOfExperience);
    }

}
