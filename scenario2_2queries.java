/* Matthew, Jason, Yong Team 1 
CS331 - Team Project - 12/11/12
Clean and Go Application 
Description: Java application for Clean and Go shop. Retrieve simple queries based on shop data, employees, revenue, and more. Updates (deletes) data when prompted with user information matching database information. 
Desc of file:  Returns scenario 2-2 queries. 
*/
package TPfinal;

import java.io.*;
import java.sql.*;

public class scenario2_2queries {
    
    // Scenario 2-2 : option A
    public static void mostPopularService(Connection conn) throws SQLException, IOException {
        /* Report the most requested type of service */
        Statement stmt = conn.createStatement();
        String query = "SELECT S_name " +
                    "FROM Service " +
                    "GROUP BY S_name " +
                    "ORDER BY COUNT(*) DESC " +
                    "LIMIT 1;";
        ResultSet rset;
        rset = stmt.executeQuery(query);
        System.out.println("             MOST POPULAR SERVICE");
        System.out.println("--------------------------------------------------\n");
        while (rset.next()) { // Return result set
            System.out.print("Our customers choose: ");
            System.out.println(rset.getString(1)+ " service");
        }
        System.out.println(" ");
        stmt.close();
    }

    // Scenario 2-2 : option B
    public static void last6MonthTransactions(Connection conn) throws SQLException, IOException {
        /* Return the toal number of transactions per month during the last 6 months. */
        Statement stmt = conn.createStatement();
        String query = "SELECT MONTH(CS_date) AS 'Month', COUNT(S_IDNUM) AS 'Number of Services' " +
                    "FROM Service " +
                    "WHERE CS_date > DATE_SUB( now(), INTERVAL 6 MONTH) " +
                    "GROUP BY Month;"; 
        ResultSet rset;
        rset = stmt.executeQuery(query);
        System.out.println("    TOTAL TRANSACTIONS DURING THE PAST 6 MONTHS   ");
        System.out.println("--------------------------------------------------\n");
        while (rset.next()) { // Return result set
            System.out.println("Month: " + rset.getLong(1) + "\nTotal Transactions: " + rset.getInt(2) + "\n");
        }
        stmt.close();
    }

    // Scenario 2-2 : option C
    public static void annualRevenuefromServices(Connection conn) throws SQLException, IOException {
        /* Returns the annual revenue made from services provided to customers, grouped by service type. */
        Statement stmt = conn.createStatement();
        String query = "SELECT EXTRACT(YEAR FROM CS_date) AS 'Year', S_name AS 'Service', SUM(CS_amountCharged) AS 'Revenue'  " +
                    "FROM Service " +
                    "WHERE CS_date  " +
                    "GROUP BY Year, Service " +
                    "ORDER BY Year DESC;";
        ResultSet rset;
        rset = stmt.executeQuery(query);
        System.out.println("           Annual Revenue from Services");
        System.out.println("--------------------------------------------------\n");
        while (rset.next()) { // Return result set
            System.out.println(rset.getLong(1) + " " + rset.getString(2) + " $" + rset.getInt(3) + " earned");
        }
        System.out.println(" ");
        stmt.close();
    }
}
