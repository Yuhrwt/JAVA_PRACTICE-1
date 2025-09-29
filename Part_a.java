package practice1;
import java.util.ArrayList;
import java.util.Scanner;

public class Part_a {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            // ---------------- Approach 1: Store Strings ----------------
            System.out.println("Enter the size of array list (for String approach):");
            int n1 = sc.nextInt();
            sc.nextLine(); // consume newline
    
            ArrayList<String> stringList = new ArrayList<>();
            int sum1 = 0;
    
            System.out.println("Enter the elements (String approach):");
            for (int i = 0; i < n1; i++) {
                String val = sc.nextLine();
                stringList.add(val);
            }
    
            for (String val : stringList) {
                try {
                    sum1 += Integer.parseInt(val);
                } catch (NumberFormatException e) {
                    System.out.println(val + " is not a valid integer. Skipping it.");
                }
            }
            System.out.println("Sum (String approach) = " + sum1);
    
            // ---------------- Approach 2: Store Integers ----------------
            System.out.println("\nEnter the size of array list (for Integer approach):");
            int n2 = sc.nextInt();
            sc.nextLine(); // consume newline
    
            ArrayList<Integer> intList = new ArrayList<>();
            int sum2 = 0;
    
            System.out.println("Enter the elements (Integer approach):");
            for (int i = 0; i < n2; i++) {
                String val = sc.nextLine();
                try {
                    Integer num = Integer.parseInt(val); // parse to int, autoboxing
                    intList.add(num);
                } catch (NumberFormatException e) {
                    System.out.println(val + " is not a valid integer. Skipping it.");
                }
            }
    
            for (Integer num : intList) {
                sum2 += num; // unboxing
            }
            System.out.println("Sum (Integer approach) = " + sum2);
    
            sc.close();
        }
    
    
}
