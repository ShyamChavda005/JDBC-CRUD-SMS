package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stud sd = new Stud();
        Scanner sc = new Scanner(System.in);
        int ch = 0;

        try {
            while (ch != 6) {
                System.out.println("1 - Add Student");
                System.out.println("2 - Update Student");
                System.out.println("3 - Delete Student");
                System.out.println("4 - View Student");
                System.out.println("5 - Search Student");
                System.out.println("6 - Exit");

                System.out.print("Enter your Choice: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        sd.addStudent();
                        break;

                    case 2:
                        sd.updateStudent();
                        break;

                    case 3:
                        sd.deleteStudent();
                        break;

                    case 4:
                        sd.viewStudent();
                        break;

                    case 5:
                        sd.searchStudent();
                        break;

                    case 6:
                        System.out.println("Exited..");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}