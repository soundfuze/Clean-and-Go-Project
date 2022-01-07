/* Matthew, Jason, Yong Team 1 
CS331 - Team Project - 12/11/12
Clean and Go Application 
Description: Java application for Clean and Go shop. Retrieve simple queries based on shop data, employees, revenue, and more. Updates (deletes) data when prompted with user information matching database information. 
Desc of file:  Returns scenario 2-1 queries.  
*/
package TPfinal;

import java.io.*;
import java.sql.*;

public class scenario2_1queries {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // Scenario 2-1 : option A
    // function to search new customer in the year by the input "year".
    // Output: total number of customer in that "year".
    public static void NewCustomers(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();
            System.out.print("Enter the current year: ");
            String year = br.readLine(); //type input

            String query =  "SELECT count(*) AS totalCount " + "from Customer " + 
                        "where C_enter like '%" +
                        year + "%'";

            ResultSet rset;
            rset = stmt.executeQuery(query);

            rset.next();
            long result = rset.getLong("totalCount");
            System.out.println("New customers in this year: " + result + "\n");

            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Scenario 2-1 : option B
    // function to search total transactions in that current year and month by input "year" and "month".
    // Output: total number of transaction count of the "month" and the "year."
    public static void TotalTransactions(Connection conn) throws SQLException, IOException {
        try {
            Statement stmt = conn.createStatement();

            System.out.print("Enter the current year: ");
            String year = br.readLine();
            System.out.print("Enter the current month: ");
            String month = br.readLine();

            String query =  "SELECT count(*) AS totalCount  " + "from Service "
                            + "where CS_Date like '" +
                                year + "%'" + "and CS_Date like '%" + month + "%'" ; //input month and year.

            ResultSet rset;
            rset = stmt.executeQuery(query);

            rset.next();
            long result = rset.getLong("totalCount");
            System.out.println("Total transaction: " + result);

            stmt.close();
            System.out.println("");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}