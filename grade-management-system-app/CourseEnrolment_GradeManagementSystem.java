




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Student class representing a student in the system
class Student {
    private String name;
    private String id;
    private List<Course> enrolledCourses; // List to store enrolled courses

    // Constructor to initialize student with name and id
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>(); // Initialize the list
    }

    // Getter methods for name and id
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    // Setter methods for name and id to update student information
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter method for enrolled courses
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll student in a course
    public void enrollCourse(Course course) {
        enrolledCourses.add(course); // Add course to enrolled courses list
    }

    // Method to assign grade to student for a course
    public void assignGrade(Course course, int grade) {
        // Find the course in the enrolled courses list
        for (Course enrolledCourse : enrolledCourses) {
            if (enrolledCourse.equals(course)) {
                enrolledCourse.setGrade(this, grade); // Call setGrade method of Course class
                return;
            }
        }
        System.out.println("Student is not enrolled in this course.");
    }
}

// Course class representing a course in the system
class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private int enrolledStudents = 0;
    private Map<String, List<Integer>> studentGradesById; // Map to store grades by student ID
    private static int totalEnrolledStudents = 0; // Static variable to track total enrolled students

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.studentGradesById = new HashMap<>(); // Initialize the map
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    // Static method to retrieve total enrolled students
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void setGrade(Student student, int grade) {
        String studentId = student.getId(); // Get student ID
        if (!studentGradesById.containsKey(studentId)) {
            studentGradesById.put(studentId, new ArrayList<>());
        }
        studentGradesById.get(studentId).add(grade);
        System.out.println("Grade assigned to student: " + student.getName() + " for course: " + name);
    }

    public List<Integer> getGrades(Student student) {
        String studentId = student.getId(); // Get student ID
        return studentGradesById.get(studentId);
    }
}

class CourseManagement {
    private static List<Course> courses = new ArrayList<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course newCourse = new Course(courseCode, name, maxCapacity);
        courses.add(newCourse);
    }

    public static Course getCourse(int index) {
        if (index >= 0 && index < courses.size()) {
            return courses.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid course index");
        }
    }

    public static void updateCourse(int index, String courseCode, String name, int maxCapacity) {
        if (index >= 0 && index < courses.size()) {
            Course course = courses.get(index);
            course.setCourseCode(courseCode);
            course.setName(name);
            course.setMaxCapacity(maxCapacity);
        } else {
            throw new IndexOutOfBoundsException("Invalid course index");
        }
    }

    public static void removeCourse(int index) {
        if (index >= 0 && index < courses.size()) {
            courses.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid course index");
        }
    }

    public static void enrollStudent(Student student, Course course) {
        if (course.getEnrolledStudents() < course.getMaxCapacity()) {
            student.enrollCourse(course);
            course.enrollStudent();
            System.out.println("Student " + student.getName() + " enrolled in course " + course.getName());
        } else {
            System.out.println("Course " + course.getName() + " has reached its maximum capacity.");
        }
    }

    public static void assignGrade(Student student, Course course, int grade) {
        course.setGrade(student, grade);
    }

    public static void calculateAverageCourseGrade(Student student) {
        System.out.println("Enrolled courses:");
        for (int i = 0; i < student.getEnrolledCourses().size(); i++) {
            Course course = student.getEnrolledCourses().get(i);
            System.out.println(i + ". " + course.getName() + " (" + course.getCourseCode() + ")");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course index to calculate average grade: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int courseIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        Course course = student.getEnrolledCourses().get(courseIndex);
        List<Integer> grades = course.getGrades(student);
        if (grades == null || grades.isEmpty()) {
            System.out.println("No grades available for student: " + student.getName() + " in course: " + course.getName());
        } else {
            double averageGrade = calculateAverageGrade(grades);
            System.out.println("Average grade for student " + student.getName() + " in course " + course.getName() + " is: " + averageGrade);
        }
    }

    public static void calculateOverallGrade(Student student) {
        List<Course> enrolledCourses = student.getEnrolledCourses();
        if (enrolledCourses.isEmpty()) {
            System.out.println("Student " + student.getName() + " is not enrolled in any courses.");
            return;
        }

        double totalGrade = 0;
        int totalCourses = 0;

        for (Course course : enrolledCourses) {
            List<Integer> grades = course.getGrades(student);
            if (grades != null && !grades.isEmpty()) {
                double courseAverageGrade = calculateAverageGrade(grades);
                totalGrade += courseAverageGrade;
                totalCourses++;
            }
        }

        if (totalCourses == 0) {
            System.out.println("No grades available for student: " + student.getName());
        } else {
            double overallGrade = totalGrade / totalCourses;
            System.out.println("Overall grade for student " + student.getName() + " across all courses is: " + overallGrade);
        }
    }

    private static double calculateAverageGrade(List<Integer> grades) {
        double total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }

    public static void listCourses() {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println(i + ". " + course.getName() + " (" + course.getCourseCode() + ")");
        }
    }
}

public class CourseEnrolment_GradeManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateAverageCourseGrade();
                    break;
                case 5:
                    calculateOverallGrade();
                    break;
                case 6:
                    updateStudentInfo();
                    break;
                case 7:
                    updateCourse();
                    break;
                case 8:
                    removeCourse();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Course Enrollment and Grade Management System ---");
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll a student in a course");
        System.out.println("3. Assign grade to a student");
        System.out.println("4. Calculate average course grade for a student");
        System.out.println("5. Calculate overall grade for student across all courses");
        System.out.println("6. Update student information");
        System.out.println("7. Update a course");
        System.out.println("8. Remove a course");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        return choice;
    }

    private static void addNewCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter maximum capacity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int maxCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        CourseManagement.addCourse(courseCode, name, maxCapacity);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);
        if (student == null) {
            student = new Student(studentName, studentId);
            students.add(student);
        }

        System.out.println("Available courses:");
        CourseManagement.listCourses();
        System.out.print("Enter the course index to enroll in: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int courseIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        Course course = CourseManagement.getCourse(courseIndex);
        CourseManagement.enrollStudent(student, course);
    }

    private static void assignGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Enrolled courses:");
        for (int i = 0; i < student.getEnrolledCourses().size(); i++) {
            Course course = student.getEnrolledCourses().get(i);
            System.out.println(i + ". " + course.getName() + " (" + course.getCourseCode() + ")");
        }
        System.out.print("Enter the course index to assign grade: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int courseIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        Course course = student.getEnrolledCourses().get(courseIndex);
        System.out.print("Enter grade: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int grade = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        CourseManagement.assignGrade(student, course, grade);
    }

    private static void calculateAverageCourseGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        CourseManagement.calculateAverageCourseGrade(student);
    }

    private static void calculateOverallGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        CourseManagement.calculateOverallGrade(student);
    }

    private static void updateStudentInfo() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new student name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new student ID: ");
        String newId = scanner.nextLine();
        student.setName(newName);
        student.setId(newId);
        System.out.println("Student information updated successfully.");
    }

    private static void updateCourse() {
        System.out.println("Available courses:");
        CourseManagement.listCourses();
        System.out.print("Enter the course index to update: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int courseIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        System.out.print("Enter new course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter new course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new maximum capacity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int maxCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        CourseManagement.updateCourse(courseIndex, courseCode, name, maxCapacity);
        System.out.println("Course updated successfully.");
    }

    private static void removeCourse() {
        System.out.println("Available courses:");
        CourseManagement.listCourses();
        System.out.print("Enter the course index to remove: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume invalid input
        }
        int courseIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the new line character
        CourseManagement.removeCourse(courseIndex);
        System.out.println("Course removed successfully.");
    }

    private static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}
