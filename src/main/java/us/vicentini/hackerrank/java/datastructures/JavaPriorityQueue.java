package us.vicentini.hackerrank.java.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class JavaPriorityQueue {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final Priorities priorities = new Priorities();
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }


    private static class Priorities {
        private final PriorityQueue<Student> studentsPriority;


        public Priorities() {
            this.studentsPriority = new PriorityQueue<>();
        }


        public List<Student> getStudents(List<String> events) {

            for (String event : events) {
                String[] tokens = event.split(" ");
                if ("SERVED".equals(tokens[0])) {
                    studentsPriority.poll();
                } else if ("ENTER".equals(tokens[0])) {
                    int id = Integer.parseInt(tokens[3]);
                    String name = tokens[1];
                    double cgpa = Double.parseDouble(tokens[2]);
                    Student student = new Student(id, name, cgpa);
                    studentsPriority.add(student);
                }
            }
            List<Student> result = new LinkedList<>();
            while (!studentsPriority.isEmpty()) {
                result.add(studentsPriority.poll());
            }
            return result;
        }
    }


    private static class Student implements Comparable<Student> {

        private final int id;
        private final double cgpa;
        private final String name;


        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }


        public int getId() {
            return id;
        }


        public double getCGPA() {
            return cgpa;
        }


        public String getName() {
            return name;
        }


        @Override
        public int compareTo(Student o) {
            int cgpaIdx = Double.compare(this.getCGPA(), o.getCGPA());
            if (cgpaIdx != 0) {
                return -cgpaIdx;
            }
            int nameIdx = this.getName().compareTo(o.getName());
            if (nameIdx != 0) {
                return nameIdx;
            }
            return Integer.compare(this.getId(), o.getId());
        }
    }
}

