package practice1;
import java.io.*;
import java.util.Scanner;
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // optional, for version control
    int id;
    String name;
    double grade;

    Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}
public class Part_b {
    static String filename = "student_data.ser"; // serialized file

    public static void main(String[] args) {
        Student s = addStudent();
        serializeStudent(s);    // save to file
        Student deserialized = deserializeStudent(); // read from file
        System.out.println("Deserialized Student: " + deserialized);
    }

    // Method to read input from user and create Student object
    static Student addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Grade: ");
        double grade = sc.nextDouble();

        return new Student(id, name, grade);
    }

    // Serialize student object to file
    static void serializeStudent(Student s) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(s);
            System.out.println("Student object has been serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize student object from file
    static Student deserializeStudent() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Student) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
