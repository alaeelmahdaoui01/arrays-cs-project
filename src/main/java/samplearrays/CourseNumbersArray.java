package samplearrays;

public class CourseNumbersArray {

    public static void main(String[] args) {

        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};



        // creates a new larger by 1 array
        int[] updatedCourses = new int[registeredCourses.length + 1] ;
        // we copy the elements of the initial array in the newly created array
        for (int i=0 ; i<registeredCourses.length  ; i++){
            updatedCourses[i]=registeredCourses[i] ;
        }
        // new course that we add to the new array as its last element
        int newCourse = 2200 ;
        updatedCourses[updatedCourses.length -1] = newCourse ;




        // printing the contents of updatedCourses
        for (int course :updatedCourses){
            System.out.println(course);
        }



        // specific course number we want to check if updatedCourses contains
        int checkCourse = 1010;
        int containsCourse = 0 ; // variable that indicates whether the array contains the course or not
        for (int course: updatedCourses){
            if (course == checkCourse){
                containsCourse = 1 ; // once we find the course in the array, we quit the loop
                break ;
            }
        } // printing the message
        if (containsCourse == 0){
            System.out.println("Course not found");
        }
        else {System.out.println("Registered courses contains course") ; }

    }
}
