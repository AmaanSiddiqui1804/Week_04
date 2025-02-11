/*3. Multi-Level University Course Management System
Concepts: Generic Classes, Wildcards, Bounded Type Parameters
Problem Statement:
Develop a university course management system where different departments offer courses with
different evaluation types (e.g., Exam-Based, Assignment-Based, Research-Based).
Hints:
Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).
Implement a generic class Course<T extends CourseType> to manage different courses.
Use wildcards (List<? extends CourseType>) to handle any type of course dynamically.
 */
package com.university_course_management_system;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    protected String courseName ;
    protected String instructor ;
    protected double duration ; //in months

    public CourseType(String courseName, String instructor, double duration){
        this.courseName = courseName;
        this.instructor = instructor;
        this.duration = duration;
    }

    public abstract String getEvaluationMethod();
    public String getCourseDetails(){
        return "Course: " + courseName + ", Instructor: " + instructor + ", Evaluation: " + getEvaluationMethod();
    }
}
class ExamCourse extends CourseType {
    private int examWeightage;

    public ExamCourse(String courseName, String instructor, double duration, int examWeightage){
        super(courseName, instructor, duration);
        this.examWeightage = examWeightage;
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based (Weightage: " + examWeightage + "%)";
    }
}
class Assignment extends CourseType {
    private int assignmentCount ;

    public Assignment(String courseName, String instructor, double duration, int assignmentCount){
        super(courseName, instructor, duration);
        this.assignmentCount = assignmentCount;
    }
    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based (Total Assignments: " + assignmentCount +")";
    }
}
class ResearchCourse extends CourseType {
    private String researchTopic ;

    public ResearchCourse(String courseName, String instructor, double duration, String researchTopic){
        super(courseName, instructor, duration);
        this.researchTopic = researchTopic;
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based (Topic: " + researchTopic + ")";
    }
}
class Course<T extends CourseType> {
    private List<T> courses;

    public Course(){
        this.courses = new ArrayList<>();
    }
    //Method to add course
    public void addCourse(T course) {
        courses.add(course);
    }

    //Method to remove courses
    public void removeCourse(T course){
        courses.remove(course);
    }

    //Method to display details
    public void displayCourses() {
        for (T course : courses) {
            System.out.println(course.getCourseDetails());
        }
    }
}
//Class to access dynamically
class CourseUtil {
    public static void displayAllCourses(List<? extends CourseType> courses){
        for(CourseType course: courses){
            System.out.println(course.getCourseDetails());
        }
    }
}
public class MultilevelCourseManagement {
    public static void main(String[] args) {
        // Create different course objects
        ExamCourse cloudExam = new ExamCourse("Advanced Mathematics", "Prof. H.O.D", 6, 70);
        Assignment javaAssignments = new Assignment("Programming in Java", "Prof. Hemant Vyas", 4, 5);
        ResearchCourse aiResearch = new ResearchCourse("Artificial Intelligence", "Dr. Banner", 18,"Deep Learning");

        // Create separate course lists
        Course<ExamCourse> examCourses = new Course<>();
        Course<Assignment> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        // Add courses to respective lists
        examCourses.addCourse(cloudExam);
        assignmentCourses.addCourse(javaAssignments);
        researchCourses.addCourse(aiResearch);

        // Display each course type separately
        System.out.println("Exam-Based Courses:");
        examCourses.displayCourses();

        System.out.println("\nAssignment-Based Courses:");
        assignmentCourses.displayCourses();

        System.out.println("\nResearch-Based Courses:");
        researchCourses.displayCourses();

        // Use wildcard method to display all courses dynamically
        System.out.println("\nDisplaying All Courses Using Wildcards:");
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(cloudExam);
        allCourses.add(javaAssignments);
        allCourses.add(aiResearch);

        CourseUtil.displayAllCourses(allCourses);
    }
}
