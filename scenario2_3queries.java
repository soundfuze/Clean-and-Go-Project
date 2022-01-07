/* Matthew, Jason, Yong Team 1 
CS331 - Team Project - 12/11/12
Clean and Go Application 
Description: Java application for Clean and Go shop. Retrieve simple queries based on shop data, employees, revenue, and more. Updates (deletes) data when prompted with user information matching database information. 
Desc of file:  Returns scenario 2-3 queries. 
*/
package TPfinal;

import java.io.*;
import java.sql.*;

public class scenario2_3queries {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Scenario 2-3 : option A
    // function to view the list of service name and customer name who has service.
    // Output: lists of service and customers who has the service ("type of service").
    public static void CustomerListForService(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter the name of the service: ");
            String service = br.readLine();
            System.out.println(" ");

            String query = "SELECT S_name, C_Name " +
                            "FROM Service, Customer " +
                            "WHERE Customer_C_IDnum = C_IDnum " +
                            "AND S_name LIKE '%" + service + "%'";     //input name of service
            
            ResultSet rset;
            rset = stmt.executeQuery(query);

            System.out.println("            CUSTOMER LIST FOR A SERVICE");
            System.out.println("--------------------------------------------------");
            System.out.print("SERVICE");
            for (int i = 0; i < 9; i++)
                System.out.print(" ");
            System.out.println("CUSTOMER NAME");
            System.out.println("--------------------------------------------------");

            while (rset.next()) {
                System.out.print(rset.getString(1));
                for (int i = 0; i < 16 - rset.getString(1).length(); i++)
                    System.out.print(" ");
                System.out.println(rset.getString(2));
            }
            stmt.close();
            System.out.println(" ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Scenario 2-3 : option B
    // function to view the number of new customer in that "month" and "year".
    // Output: list of all new customers in that "month" and "year".  
    public static void CustomerNum(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter the Year: ");
            String year = br.readLine();
            String query = "SELECT Month(C_enter) AS MONTH, COUNT(*) " +
                            "FROM Customer " +
                            "WHERE Year(C_enter) = '" + year + "'" +        //input year
                            "GROUP BY MONTH(C_enter) " +
                            "ORDER BY MONTH ASC";

            ResultSet rset;
            rset = stmt.executeQuery(query);

            System.out.println(" ");
            System.out.println("                CUSTOMER NUMBER");
            System.out.println("--------------------------------------------------");
            System.out.print("MONTH");
            for (int i = 0; i < 11; i++)
                System.out.print(" ");
            System.out.println("NUMBER OF CUSTOMER");
            System.out.println("--------------------------------------------------");

            while (rset.next()) {
                System.out.print(rset.getString(1));
                for (int j = 0; j < 16 - rset.getString(1).length(); j++)
                System.out.print(" ");
                System.out.println(rset.getString(2));
            }
                stmt.close();
                System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}