
import java.util.Scanner;

// Person class
 class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}


// Class Student java
 class Student extends Person {
    private int number;
    private int score;
    private String major;

    public Student(String name, int age, int number, int score, String major) {
        super(name, age);
        this.number = number;
        this.score = score;
        this.major = major;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number: " + number);
        System.out.println("Score: " + score);
        System.out.println("Major: " + major);
    }
}


// Class Teacher java
 class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }
}
//Class FullTimeTeacher
class FullTimeTeacher extends Teacher{
    private String subject;
    private double annualSalary;
    private String unit;

    public FullTimeTeacher(String name, int age, String subject, double annualSalary, String unit) {
        super(name, age);
        this.subject = subject;
        this.annualSalary = annualSalary;
        this.unit = unit;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject : "+subject);
        System.out.println("Annual Salary: " + annualSalary);
        System.out.println("Unit: " + unit);
    }
}
// Class PartTimeTeacher java
 class PartTimeTeacher extends Teacher {
    private String subject;
    private int totalWorkHours;
    private double salary;

    public PartTimeTeacher(String name, int age, String subject, int totalWorkHours) {
        super(name, age);
        this.subject = subject;
        this.totalWorkHours = totalWorkHours;
        this.salary = calculateSalary();
    }

    // Calculate salary method
    private double calculateSalary() {
        return totalWorkHours * 4 * 20000;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
        System.out.println("Total Work Hours: " + totalWorkHours + " hours/week");
        System.out.println("Salary: Rp " + salary);
    }
}
//Class Main java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;

        while (repeat) {
            // Main menu
            System.out.println("Choose one:");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Student Input
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("Age: ");
                int age = scanner.nextInt();
                System.out.println("Number: ");
                int number = scanner.nextInt();
                System.out.println("Score: ");
                int score = scanner.nextInt();
                System.out.println("Major: ");
                String major = scanner.next();

                // Create Student object and display details
                Student student = new Student(name, age, number, score, major);
                System.out.println("\nStudent Details:");
                student.displayDetails();
                
            } else if (choice == 2) {
                // Teacher menu
                System.out.println("Choose:");
                System.out.println("1. Full-time Teacher");
                System.out.println("2. Part-time Teacher");
                int teacherType = scanner.nextInt();

                if (teacherType == 1) {
                    // Full-time Teacher Input
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.println("Age: ");
                    int age = scanner.nextInt();
                    System.out.println("Subject: ");
                    String subject = scanner.next();
                    System.out.println("Annual Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.println("Unit: ");
                    String unit = scanner.next();

                    // Create FullTimeTeacher object and display details
                    FullTimeTeacher fullTimeTeacher = new FullTimeTeacher(name, age, subject, salary, unit);
                    System.out.println("\nFull-time Teacher Details:");
                    fullTimeTeacher.displayDetails();
                } else if (teacherType == 2) {
                    // Part-time Teacher Input
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.println("Age: ");
                    int age = scanner.nextInt();
                    System.out.println("Subject: ");
                    String subject = scanner.next();
                    System.out.println("Total Work Hours: ");
                    int totalWork = scanner.nextInt();

                    // Create PartTimeTeacher object and display details
                    PartTimeTeacher partTimeTeacher = new PartTimeTeacher(name, age, subject, totalWork);
                    System.out.println("\nPart-time Teacher Details:");
                    partTimeTeacher.displayDetails();
                } else {
                    System.out.println("Invalid choice for teacher type.");
                }
            } else {
                System.out.println("Invalid choice, please restart the program.");
            }

            // Ask user if they want to repeat the process
            System.out.println("\nWould you like to choose again? (yes/no)");
            String response = scanner.next().toLowerCase();
            repeat = response.equals("yes");
        }

        scanner.close();
        System.out.println("Program ended.");
    }
}
