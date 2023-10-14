package com.classes;

import java.util.ArrayList;

public class StudentRecords {

    // set student records
    private String name;
    private int age;
    private String course;
    private int stdNo;

    // set arrayLists to store the records
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<Integer> ages = new ArrayList<Integer>();
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<Integer> stdNos = new ArrayList<Integer>();

    // set student name
    public void setName(String name) {
        this.name = name;
    }

    // get student name
    public String getName() {
        return name;
    }

    // set student age
    public void setAge(int age) {
        this.age = age;
    }

    // get student age
    public int getAge() {
        return age;
    }

    // set student course
    public void setCourse(String course) {
        this.course = course;
    }

    // get student course
    public String getCourse() {
        return course;
    }

    // set student number
    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    // get student number
    public int getStdNo() {
        return stdNo;
    }

    public void setGenerics(String name, int age, String course, int stdNo) {
        // if passed argument name is not null
        if (name != null) {
            // add name to names array
            names.add(name);
        }
        // if passed argument age is not null
        if (age != 0) {
            // add age to ages array
            ages.add(age);
        }
        // if passed argument course is not null
        if (course != null) {
            // add course to courses array
            courses.add(course);
        }
        // if passed argument stdNo is not null
        if (stdNo != 0) {
            // add stdNo to stdNos array
            stdNos.add(stdNo);
        }

    }

    // return arraylist for names
    public ArrayList<String> getNames() {
        return names;
    }

    // return arraylist for ages
    public ArrayList<Integer> getAges() {
        return ages;
    }

    // return arraylist for courses
    public ArrayList<String> getCourses() {
        return courses;
    }

    // return arraylist for stdNos
    public ArrayList<Integer> getStdNos() {
        return stdNos;
    }

    public void searchStudent(int stdNo2) {
        Boolean found = false;
        int index = -1;
        // search on student number list and return the index
        for (int i = 0; i < stdNos.size(); i++) {
            if (stdNos.get(i) == stdNo2) {
                found = true;
                index = i;
                break;
            } else {
                found = false;
            }
        }

        // if loop finished without finding the student number
        if (found) {
            System.out.println("Student Name: " + names.get(index));
            System.out.println("Student Age: " + ages.get(index));
            System.out.println("Student Course: " + courses.get(index));
            System.out.println("Student Number: " + stdNos.get(index));
        } else {
            System.out.println("There is not Student with that Number!\n");
        }
    }

}