/* Matthew, Jason, Yong Team 1 
CS331 - Team Project - 12/11/12
Clean and Go Application 
Description: Java application for Clean and Go shop. Retrieve simple queries based on shop data, employees, revenue, and more. Updates (deletes) data when prompted with user information matching database information. 
Desc of file:  Returns scenario 3 queries. 
*/
package TPfinal;

import java.io.*;
import java.sql.*;

public class scenario3query {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // SCENARIO 3
    // Function to print schedule date and day by input data (Employee ID)
    // Output: Print scheduled date and day, or print empty table if there is no schedule.
    public static void Employee(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter Employee ID number: ");
            String empID = br.readLine();
            System.out.println(" ");

            String query = "SELECT scheduleDate, DAYNAME(scheduleDate) " +
                            "FROM Emp_schedule " +
                            "WHERE Employee_Emp_IDnum = '" + empID + "' ";

            ResultSet rset;
            rset = stmt.executeQuery(query);
            System.out.println("             WEEKLY WORKING SCHEDULE");
            System.out.println("--------------------------------------------------");

            String a = "DATE";
            String b = "DAY";

            System.out.print(a);
            for (int i = 0; i < 16 - a.length(); i++)
                System.out.print(" ");
            System.out.println(b);
            System.out.println("--------------------------------------------------");

            while (rset.next()) {
                System.out.print(rset.getString(1));
                for (int i = 0; i < 16 - rset.getString(1).length(); i++)
                    System.out.print(" ");
                System.out.println(rset.getString(2));
            }
            System.out.println("");
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}