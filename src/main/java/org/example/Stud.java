package org.example;

import javax.sound.midi.SysexMessage;
import java.sql.*;
import java.util.*;

class Stud {
    final Connection conn = DBConnect.getConnection();
    Scanner sc = new Scanner(System.in);

    // Student add
    public void addStudent() throws Exception {
        if (conn == null) System.out.println("Not Connected to the database");
        try {

            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Student Age : ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Course : ");
            String course = sc.nextLine();

            PreparedStatement pt = conn.prepareStatement(
                    "INSERT INTO student(name,age,course) VALUES (?,?,?)"
            );

            pt.setString(1, name);
            pt.setInt(2, age);
            pt.setString(3, course);

            pt.executeUpdate();

            System.out.println("\n-->  Student Added Successfully \n");

            pt.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    // Student update
    public void updateStudent() throws Exception {
        if (conn == null) System.out.println("Not Connected to the database");

        System.out.print("Enter Student Id to Update Data : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Course : ");
        String course = sc.nextLine();

        PreparedStatement st = conn.prepareStatement("UPDATE student SET name=?, age=?, course=? WHERE id=?");

        st.setString(1, name);
        st.setInt(2, age);
        st.setString(3, course);
        st.setInt(4, id);

        st.executeUpdate();

        // View accordingly id
        Statement st1 = conn.createStatement();

        ResultSet rs = st1.executeQuery("SELECT * FROM student WHERE id = " + id);

        System.out.println();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " " + rs.getString("course"));
        }

        System.out.println("-->  Student Updated Successfully \n");

        st.close();

    }

    // Student delete
    public void deleteStudent() throws Exception {
        if (conn == null) System.out.println("Not Connected to the database");

        System.out.print("Enter Student Id to Delete : ");
        int id = sc.nextInt();

        PreparedStatement st = conn.prepareStatement("DELETE FROM student WHERE id=?");

        st.setInt(1, id);

        st.executeUpdate();

        System.out.println("\n-->  Student Deleted Successfully \n");

        st.close();
    }

    // Student view
    public void viewStudent() throws Exception {
        if (conn == null) System.out.println("Not Connected to the database");

        ResultSet rs = conn.prepareStatement("SELECT * FROM student").executeQuery();

        System.out.println();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " +
            rs.getInt("age") + " " + rs.getString("course"));
        }

        System.out.println("\n-->  Student View Successfully \n");
    }

    // Student search
    public void searchStudent() throws Exception {
        if (conn == null) System.out.println("Not Connected to the database");

        System.out.print("Enter Student Id to be Search : ");
        int id = sc.nextInt();

        PreparedStatement pst = conn.prepareStatement("SELECT  * FROM student WHERE id=?");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " " + rs.getString("course"));
        }

        System.out.println("\n-->  Student Searched Successfully \n");

        pst.close();
    }
}