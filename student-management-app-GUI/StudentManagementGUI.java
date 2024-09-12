import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Student class
class Student {
    private String name;
    private String id;
    private List<Course> enrolledCourses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void assignGrade(Course course, int grade) {
        for (Course enrolledCourse : enrolledCourses) {
            if (enrolledCourse.equals(course)) {
                enrolledCourse.setGrade(this, grade);
                return;
            }
        }
        System.out.println("Student is not enrolled in this course.");
    }

    @Override
    public String toString() {
        return name;
    }
}

// Course class
class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private int enrolledStudents = 0;
    private Map<String, List<Integer>> studentGradesById;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.studentGradesById = new HashMap<>();
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
        String studentId = student.getId();
        if (!studentGradesById.containsKey(studentId)) {
            studentGradesById.put(studentId, new ArrayList<>());
        }
        studentGradesById.get(studentId).add(grade);
        System.out.println("Grade assigned to student: " + student.getName() + " for course: " + name);
    }

    public List<Integer> getGrades(Student student) {
        String studentId = student.getId();
        return studentGradesById.get(studentId);
    }

    @Override
    public String toString() {
        return name;
    }
}

// CourseManagement class
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

    public static void calculateAverageCourseGrade(Student student, int courseIndex) {
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

    public static List<Course> getCourses() {
        return courses;
    }
}

// Main Application
public class StudentManagementGUI extends Application {
    private ObservableList<Student> students;
    private ObservableList<Course> courses;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        students = FXCollections.observableArrayList();
        courses = FXCollections.observableArrayList(CourseManagement.getCourses());

        primaryStage.setTitle("Student Management System");

        TabPane tabPane = new TabPane();

        Tab studentTab = new Tab("Student Management");
        studentTab.setContent(createStudentManagementPane());
        studentTab.setClosable(false);

        Tab courseTab = new Tab("Course Management");
        courseTab.setContent(createCourseManagementPane());
        courseTab.setClosable(false);

        tabPane.getTabs().addAll(studentTab, courseTab);

        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createStudentManagementPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        ListView<Student> studentListView = new ListView<>(students);
        grid.add(studentListView, 0, 0, 2, 1);

        studentListView.setCellFactory(param -> new ListCell<Student>() {
            @Override
            protected void updateItem(Student student, boolean empty) {
                super.updateItem(student, empty);
                if (empty || student == null || student.getName() == null) {
                    setText(null);
                } else {
                    setText(student.getName());
                }
            }
        });

        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 0, 1);
        TextField nameField = new TextField();
        grid.add(nameField, 1, 1);

        Label idLabel = new Label("ID:");
        grid.add(idLabel, 0, 2);
        TextField idField = new TextField();
        grid.add(idField, 1, 2);

        studentListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nameField.setText(newValue.getName());
                idField.setText(newValue.getId());
            }
        });

        Button addButton = new Button("Add Student");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            if (validateStudentInput(name, id)) {
                students.add(new Student(name, id));
                nameField.clear();
                idField.clear();
            }
        });

        Button updateButton = new Button("Update Student");
        updateButton.setOnAction(e -> {
            Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null && validateStudentInput(nameField.getText(), idField.getText())) {
                selectedStudent.setName(nameField.getText());
                selectedStudent.setId(idField.getText());
                studentListView.refresh();
            }
        });

        Button deleteButton = new Button("Delete Student");
        deleteButton.setOnAction(e -> {
            Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                students.remove(selectedStudent);
            }
        });

        HBox buttonBox = new HBox(10, addButton, updateButton, deleteButton);
        grid.add(buttonBox, 1, 3);

        // Enroll student section
        Label enrollCourseLabel = new Label("Enroll in Course:");
        grid.add(enrollCourseLabel, 0, 4);
        ComboBox<Course> enrollCourseComboBox = new ComboBox<>(courses);
        grid.add(enrollCourseComboBox, 1, 4);

        Button enrollButton = new Button("Enroll");
        enrollButton.setOnAction(e -> {
            Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
            Course selectedCourse = enrollCourseComboBox.getSelectionModel().getSelectedItem();
            if (selectedStudent != null && selectedCourse != null) {
                CourseManagement.enrollStudent(selectedStudent, selectedCourse);
            }
        });
        grid.add(enrollButton, 1, 5);

        // Assign grade section
        Label assignGradeLabel = new Label("Assign Grade:");
        grid.add(assignGradeLabel, 0, 6);
        ComboBox<Course> assignGradeCourseComboBox = new ComboBox<>(courses);
        grid.add(assignGradeCourseComboBox, 1, 6);

        Label gradeLabel = new Label("Grade:");
        grid.add(gradeLabel, 0, 7);
        TextField gradeField = new TextField();
        grid.add(gradeField, 1, 7);

        Button assignGradeButton = new Button("Assign Grade");
        assignGradeButton.setOnAction(e -> {
            Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
            Course selectedCourse = assignGradeCourseComboBox.getSelectionModel().getSelectedItem();
            if (selectedStudent != null && selectedCourse != null && validateGradeInput(gradeField.getText())) {
                int grade = Integer.parseInt(gradeField.getText());
                CourseManagement.assignGrade(selectedStudent, selectedCourse, grade);
                gradeField.clear();
            }
        });
        grid.add(assignGradeButton, 1, 8);

        // Calculate average grade per course
        Button calculateAverageGradeButton = new Button("Calculate Average Grade");
        calculateAverageGradeButton.setOnAction(e -> {
            Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
            Course selectedCourse = enrollCourseComboBox.getSelectionModel().getSelectedItem();
            if (selectedStudent != null && selectedCourse != null) {
                int courseIndex = selectedStudent.getEnrolledCourses().indexOf(selectedCourse);
                CourseManagement.calculateAverageCourseGrade(selectedStudent, courseIndex);
            }
        });
        grid.add(calculateAverageGradeButton, 1, 9);

        // Calculate overall grade
        Button calculateOverallGradeButton = new Button("Calculate Overall Grade");
        calculateOverallGradeButton.setOnAction(e -> {
            Student selectedStudent = studentListView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                CourseManagement.calculateOverallGrade(selectedStudent);
            }
        });
        grid.add(calculateOverallGradeButton, 1, 10);

        return grid;
    }

    private GridPane createCourseManagementPane() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        ListView<Course> courseListView = new ListView<>(courses);
        grid.add(courseListView, 0, 0, 2, 1);

        courseListView.setCellFactory(param -> new ListCell<Course>() {
            @Override
            protected void updateItem(Course course, boolean empty) {
                super.updateItem(course, empty);
                if (empty || course == null || course.getName() == null) {
                    setText(null);
                } else {
                    setText(course.getName());
                }
            }
        });

        Label codeLabel = new Label("Course Code:");
        grid.add(codeLabel, 0, 1);
        TextField codeField = new TextField();
        grid.add(codeField, 1, 1);

        Label nameLabel = new Label("Course Name:");
        grid.add(nameLabel, 0, 2);
        TextField nameField = new TextField();
        grid.add(nameField, 1, 2);

        Label capacityLabel = new Label("Max Capacity:");
        grid.add(capacityLabel, 0, 3);
        TextField capacityField = new TextField();
        grid.add(capacityField, 1, 3);

        courseListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                codeField.setText(newValue.getCourseCode());
                nameField.setText(newValue.getName());
                capacityField.setText(String.valueOf(newValue.getMaxCapacity()));
            }
        });

        Button addButton = new Button("Add Course");
        addButton.setOnAction(e -> {
            String courseCode = codeField.getText();
            String courseName = nameField.getText();
            String maxCapacityText = capacityField.getText();
            if (validateCourseInput(courseCode, courseName, maxCapacityText)) {
                int maxCapacity = Integer.parseInt(maxCapacityText);
                Course newCourse = new Course(courseCode, courseName, maxCapacity);
                courses.add(newCourse);
                CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                codeField.clear();
                nameField.clear();
                capacityField.clear();
            }
        });

        Button updateButton = new Button("Update Course");
        updateButton.setOnAction(e -> {
            Course selectedCourse = courseListView.getSelectionModel().getSelectedItem();
            if (selectedCourse != null && validateCourseInput(codeField.getText(), nameField.getText(), capacityField.getText())) {
                selectedCourse.setCourseCode(codeField.getText());
                selectedCourse.setName(nameField.getText());
                selectedCourse.setMaxCapacity(Integer.parseInt(capacityField.getText()));
                courseListView.refresh();
            }
        });

        Button deleteButton = new Button("Delete Course");
        deleteButton.setOnAction(e -> {
            Course selectedCourse = courseListView.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                courses.remove(selectedCourse);
                CourseManagement.removeCourse(courses.indexOf(selectedCourse));
            }
        });

        HBox buttonBox = new HBox(10, addButton, updateButton, deleteButton);
        grid.add(buttonBox, 1, 4);

        return grid;
    }

    private boolean validateStudentInput(String name, String id) {
        if (name == null || name.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid student name.");
            return false;
        }
        if (id == null || id.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid student ID.");
            return false;
        }
        return true;
    }

    private boolean validateCourseInput(String courseCode, String courseName, String maxCapacityText) {
        if (courseCode == null || courseCode.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid course code.");
            return false;
        }
        if (courseName == null || courseName.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid course name.");
            return false;
        }
        if (maxCapacityText == null || maxCapacityText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid maximum capacity.");
            return false;
        }
        try {
            int maxCapacity = Integer.parseInt(maxCapacityText);
            if (maxCapacity <= 0) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Maximum capacity must be a positive number.");
                return false;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Maximum capacity must be a number.");
            return false;
        }
        return true;
    }

    private boolean validateGradeInput(String gradeText) {
        if (gradeText == null || gradeText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please enter a valid grade.");
            return false;
        }
        try {
            int grade = Integer.parseInt(gradeText);
            if (grade < 0 || grade > 100) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Grade must be between 0 and 100.");
                return false;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Grade must be a number.");
            return false;
        }
        return true;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
