package us.vicentini.hackerrank.java.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String fname;
    private double cgpa;


    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }


    public int getId() {
        return id;
    }


    public String getFname() {
        return fname;
    }


    public double getCgpa() {
        return cgpa;
    }
}


//Complete the code
public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort((o1, o2) -> {
            int score = Double.compare(o1.getCgpa(), o2.getCgpa());
            if (score == 0) {
                int name = o1.getFname().compareTo(o2.getFname());
                if (name == 0) {
                    return Integer.compare(o1.getId(), o2.getId());
                }
                return name;
            }
            return -score;
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
