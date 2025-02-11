/* 5. AI-Driven Resume Screening System
Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards
Problem Statement:
Develop an AI-Driven Resume Screening System that can process resumes for different
job roles like Software Engineer, Data Scientist, and Product Manager while ensuring type safety.
Hints:
Create an abstract class JobRole (SoftwareEngineer, DataScientist, ProductManager).
Implement a generic class Resume<T extends JobRole> to process resumes dynamically.
Use a wildcard method (List<? extends JobRole>) to handle multiple job roles in the
screening pipeline.
 */
package com.ai_driven_resume_screening_system;

import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    protected String candidateName;
    protected int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public abstract String getJobDetails();

    public String getCandidateSummary() {
        return "Candidate: " + candidateName + ", Experience: " + experienceYears + " years, Role: " + getJobDetails();
    }
}
class SoftwareEngineer extends JobRole {
    private String programmingLanguage ;

    public SoftwareEngineer(String candidateName, int experienceYears, String programmingLanguage) {
        super(candidateName, experienceYears);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String getJobDetails() {
        return "\n\tSoftware Engineer \nProgramming Language: " + programmingLanguage;
    }
}
class DataScientist extends JobRole {
    private String specialization;

    public DataScientist(String candidateName, int experienceYears, String specialization) {
        super(candidateName, experienceYears);
        this.specialization = specialization;
    }

    @Override
    public String getJobDetails() {
        return "\n\tData Scientist \nSpecialization: " + specialization;
    }
}
class ProductManager extends JobRole {
    private int numberOfProjects;

    public ProductManager(String candidateName, int experienceYears, int numberOfProjects) {
        super(candidateName, experienceYears);
        this.numberOfProjects= numberOfProjects;
    }

    @Override
    public String getJobDetails() {
        return "\n\tProduct Manager \nNumber of Projects worked involved: " + numberOfProjects;
    }
}
class Resume<T extends JobRole> {
    private List<T> resumes;

    public Resume() {
        this.resumes = new ArrayList<>();
    }

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public void removeResume(T resume) {
        resumes.remove(resume);
    }

    public void displayResumes() {
        for (T resume : resumes) {
            System.out.println(resume.getCandidateSummary());
        }
    }
}
class ResumeUtil {
    public static void screenResumes(List<? extends JobRole> resumes) {
        System.out.println("Screening resumes...");
        for (JobRole resume : resumes) {
            System.out.println(resume.getCandidateSummary());
        }
    }
}
public class AiDrivenScreeningSystem {
    public static void main(String[] args) {

    // Creating different job role resume objects
    SoftwareEngineer seResume = new SoftwareEngineer("Amaan", 4, "Java");
    DataScientist dsResume = new DataScientist("Nishank", 1, "Deep Learning");
    ProductManager pmResume = new ProductManager("Abhay", 5, 10);

    // Creating separate resume lists for each job role
    Resume<SoftwareEngineer> softwareResumes = new Resume<>();
    Resume<DataScientist> dataResumes = new Resume<>();
    Resume<ProductManager> productResumes = new Resume<>();

    // Adding resumes to their respective lists
        softwareResumes.addResume(seResume);
        dataResumes.addResume(dsResume);
        productResumes.addResume(pmResume);

    // Displaying each job role's resumes separately
        System.out.println("Software Engineer Resumes:");
        softwareResumes.displayResumes();

        System.out.println("\nData Scientist Resumes:");
        dataResumes.displayResumes();

        System.out.println("\nProduct Manager Resumes:");
        productResumes.displayResumes();

    // Using wildcard method to screen all resumes dynamically
        System.out.println("\nScreening All Resumes:");
    List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(seResume);
        allResumes.add(dsResume);
        allResumes.add(pmResume);

        ResumeUtil.screenResumes(allResumes);
    }
}
