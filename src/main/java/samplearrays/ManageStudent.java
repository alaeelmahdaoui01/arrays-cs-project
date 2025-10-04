package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students.length == 0){return null;}

        Student oldest = students[0] ;
        for (Student student : students){
            int studentAge = student.getAge() ;
            int maxAge = oldest.getAge() ;
            if(studentAge>maxAge){ oldest = student ;}
        }

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int countA = 0 ;
        for (Student student : students){
            if(student.isAdult()){ countA++; }
        }
        return countA ;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double sumGrades = 0 ;
        for (Student student : students){
            int studentGrade = student.getGrade() ;
            sumGrades +=  studentGrade ;
        }
        double averageG = sumGrades/ students.length ;
        return averageG ;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student : students){
            if (student.getName()==name ){  // or i could use .equals()
                return student ;
            }
        }
        Student unknown = new Student(0, "unknown", 0);
        return  unknown;
    }

    // 6) Sort Students by Grade (descending)
    // i used selection sort for this sorting function
    public static void sortByGradeDesc(Student[] students) {
        for (int i=0 ;i < students.length - 1; i++ ){
            int maxGradeAtIndex = i ;

            for (int j=i+1 ; j <students.length ; j++){
                int currentstudentGrade = students[j].getGrade() ;
                int maxGrade = students[maxGradeAtIndex].getGrade() ;
                if (currentstudentGrade > maxGrade){
                    maxGradeAtIndex = j ;
                }
            }

            // we swap de sorte à avoir the student with highest grade from indexes i to n-1, at position i
            if (maxGradeAtIndex != i){
                Student temp = students[i] ;
                students[i] = students[maxGradeAtIndex] ;
                students[maxGradeAtIndex]= temp ;
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student student : students){
            int studentGrade = student.getGrade() ;
            if(studentGrade>=15){ System.out.println(student.getName()); }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student student: students){
            if (student.getId() == id){
                student.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length-1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName() == students[j].getName()) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i]; // copy old students
        }
        newStudents[students.length] = newStudent; // add new student
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] students = {
                new Student(1, "Alae", 19, 14),
                new Student(2, "Farah", 19, 17),
                new Student(3, "Hiba", 20, 12),
                new Student(4, "Aya", 20, 11),
                new Student(5, "Nour", 20, 10)
        };

        // Print all
        System.out.println("Student: ");
        for (Student student : students) {System.out.println(student); }


        // 2) Oldest
        System.out.println("Oldest student: " + findOldest(students));

        // 3) Count adults
        System.out.println("Adults number: " + countAdults(students));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(students));


        // 5) Find by name
        System.out.println(findStudentByName(students, "Hiba"));
        System.out.println(findStudentByName(students, "Salma"));

        // 6) Sort by grade desc
        sortByGradeDesc(students);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : students) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by id
        boolean updated = updateGrade(students , 1, 18) ;
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(students, "Alae"));

        // 9) Duplicate names
        System.out.println("Duplicates? " + hasDuplicateNames(students));

        // 10) Append new student
        Student newStudent = new Student(6, "Salma", 20, 17);
        students = appendStudent(students , newStudent);
        System.out.println("All students names: ");
        for (Student student : students) {System.out.println(student.toString()) ; }
    }
}

