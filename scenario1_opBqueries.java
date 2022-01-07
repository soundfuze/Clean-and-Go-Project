/* Matthew, Jason, Yong Team 1 
CS331 - Team Project - 12/11/12
Clean and Go Application 
Description: Java application for Clean and Go shop. Retrieve simple queries based on shop data, employees, revenue, and more. Updates (deletes) data when prompted with user information matching database information. 
Desc of file:  Returns scenario 1-optionB queries. 
*/
package TPfinal;

import java.io.*;
import java.sql.*;

public class scenario1_opBqueries {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Scenario 1-1
    // Function to delete Equipment by input data (Equipment ID).
    // Output: Number of affected rows, or print error message if there is no affected row.
    public static void deleteEquipment(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter Equipment ID number you want to delete: ");
            String equID = br.readLine();

            String query = "delete from Equipment " +
                "where Equ_IDnum = '" +
                equID + "'";
            
            int rowAffected = stmt.executeUpdate(query);

            if (rowAffected == 0) {
                System.out.println("No Equipment found." + "\n");
            } else {
                System.out.println("Rows affected: " + rowAffected);
                System.out.println("Delete completed." + "\n");
            }
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Scenario 1-2
    // Function to delete Service by input data (Service ID).
    // Output: Number of affected rows, or print error message if there is no affected row.
    public static void deleteService(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter Service ID number you want to delete: ");
            String serviceID = br.readLine();

            String query = "delete from Service " +
                "where S_IDnum = '" +
                serviceID + "'";
            
            int rowAffected = stmt.executeUpdate(query);

            if (rowAffected == 0) {
                System.out.println("No Service found." + "\n");
            } else {
                System.out.println("Rows affected: " + rowAffected);
                System.out.println("Delete completed." + "\n");
            }
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Scenario 1-3
    // Function to delete Customer by input data (Customer name).
    // Output: Number of affected rows, or print error message if there is no affected row.
    public static void deleteCustomer(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter the name of Customer: ");
            String Cname = br.readLine();

            String query = "delete from Customer " +
                "where C_name LIKE '%" +
                Cname + "%'";
            
            int rowAffected = stmt.executeUpdate(query);

            if (rowAffected == 0) {
                System.out.println("No Customer found." + "\n");
            } else {
                System.out.println("Rows affected: " + rowAffected);
                System.out.println("Delete completed." + "\n");
            }
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Scenario 1-4
    // Function to delete Employee by input data (Employee name).
    // Output: Number of affected rows, or print error message if there is no affected row.
    public static void deleteEmployee(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter the name of Employee: ");
            String Ename = br.readLine();

            String query = "delete from Employee " +
                "where Emp_name LIKE '%" +
                Ename + "%'";
    
            int rowAffected = stmt.executeUpdate(query);

            if (rowAffected == 0) {
                System.out.println("No Employee found." + "\n");
            } else {
                System.out.println("Rows affected: " + rowAffected);
                System.out.println("Delete completed." + "\n");
            }
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}