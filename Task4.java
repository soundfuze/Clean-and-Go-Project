/* Matthew, Jason, Yong Team 1 
CS331 - Team Project - 12/11/12
Clean and Go Application 
Description: Java application for Clean and Go shop. Retrieve simple queries based on shop data, employees, revenue, and more. Updates (deletes) data when prompted with user information matching database information. 
Desc of file:  Main java file for navigating application, reading client input, and establishing a connection to the database.
*/
package TPfinal;

import java.io.*;
import java.sql.*;

public class Task4 {

    public static String url = "jdbc:mysql://localhost:3306/CleanAndGo?serverTimezone=UTC&useSSL=TRUE"; // Url with schema name 'CleanAndGo'
    public static String user = "student";
    public static String password = "password";
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        Connection conn = null; // Initialize connection object to null 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Choose mysql driver
            conn = DriverManager.getConnection(url, user, password); // Establish connection 

            boolean done = false;

            do {
                menuUI.printMenu(); // Print the first menu UI to user
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) { // Switch case for navigating application homepage
                    case '1': System.out.println("Not a valid option. Not yet implemented.");
                        break;
                    case '2': CustomerAndServices(conn); // Customer service menu 
                        break;
                    case '3': scenario3query.Employee(conn); // Employee menu 
                        break;
                    case '4': Updates(conn); // Update menu 
                        break;
                    case '5': done = true; // Quit 
                        break;
                    default:
                        System.out.println("Not a valid option.");
                }
            } while (!done);
            
        } catch (ClassNotFoundException e) { // Handle exceptions if needed
            System.out.println("Could not load the driver");
        } catch (SQLException ex) { // Sql exception 
            System.out.println(ex);
        } catch (IOException e) { // Input/Output exception
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // End connection 
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static String readLine() { // Readline helper function: returns line and handles exceptions, if any 
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("Error in SimpleIO.readLine: " + "IOException was thrown.");
            System.exit(1);
        }
        return line; 
    }

    // SCENARIO 1
    private static void Updates(Connection conn) throws SQLException, IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ID = "HappyAdmin", PW = "MakeMoneyAdmin";
        String adminID, adminPW;

        System.out.print("Enter Admin ID: "); // Ask user for adminID and pass
        adminID = br.readLine();
        System.out.print("Enter Admin Password: ");
        adminPW = br.readLine();
        System.out.println("");

        if (adminID.equals(ID) && (adminPW.equals(PW))) { // If the correct adminID/pass was entered, proceed. If else, exit.  
            boolean done = false;
            do {
                menuUI.deleteMenu(); // Display delete MenuUI
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) { // Switch case for navigating update page
                    case '1': scenario1_opBqueries.deleteEquipment(conn); // DeleteEquip method
                        break;
                    case '2': scenario1_opBqueries.deleteService(conn); // DeleteServ method
                        break;
                    case '3': scenario1_opBqueries.deleteCustomer(conn); // DeleteCust method
                        break;
                    case '4': scenario1_opBqueries.deleteEmployee(conn); // DeleteEmp method
                        break;
                    case '5': done = true; // Quit 
                        break;
                    default:
                        System.out.println("Not a valid option." + "\n");
                }
            } while (!done);
        } else {
            System.out.println("Invalid Information. Please check your ID or Password." + "\n");
        }
    }

    // SCENARIO 2
    private static void CustomerAndServices(Connection conn) throws SQLException, IOException {
            boolean done = false;
            do {
                menuUI.CustomerServiceMenu(); // Display customer service menu 
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) { // Switch case for navigating customer/service page
                    case '1': TotalNumbers(conn); // Information about shop numbers
                        break;
                    case '2': aboutServices(conn); // Information about services
                        break;
                    case '3': aboutCustomer(conn); // Information about customers 
                        break;
                    case '4': done = true; // Quit 
                        break;
                    default:
                        System.out.println("Not a valid option." + "\n");
                }
            } while (!done);
    }

    // SCENARIO 2-1 INTERFACE
    private static void TotalNumbers(Connection conn) throws SQLException, IOException {
        boolean done = false;
            do {
                menuUI.analyzeMenu(); // Analyze Business Menu 
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) {
                    case '1': scenario2_1queries.NewCustomers(conn); // Display new customers 
                        break;
                    case '2': scenario2_1queries.TotalTransactions(conn); // Display transactions 
                        break;
                    case '3': done = true; // Quit 
                        break;
                    default:
                        System.out.println("Not a valid option." + "\n");
                }
            } while (!done);
    }

    
    // SCENARIO 2-2 INTERFACE 
    private static void aboutServices(Connection conn) throws SQLException, IOException {
        boolean done = false;
            do {
                menuUI.servicesMenu(); // Display services menu 
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) {
                    case '1': scenario2_2queries.mostPopularService(conn); // Display most pop. service 
                        break;
                    case '2': scenario2_2queries.last6MonthTransactions(conn); // Display last 6 months transactions
                        break;
                    case '3': scenario2_2queries.annualRevenuefromServices(conn); // Display annual revenue from services
                        break;
                    case '4': done = true; // Quit 
                        break;
                    default:
                        System.out.println("Not a valid option." + "\n");
                }
            } while (!done);
    }

    // SCENARIO 2-3 INTERFACE 
    public static void aboutCustomer(Connection conn) throws SQLException, IOException {
        boolean done = false;
            do {
                menuUI.customerMenu(); // Display customer menu
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                switch (ch.charAt(0)) {
                    case '1': scenario2_3queries.CustomerListForService(conn); // Display list of service name and list of customer name
                        break;
                    case '2': scenario2_3queries.CustomerNum(conn); // Display list of new customer's number in that 'Month' and 'Year'
                        break;
                    case '3': done = true; // Quit
                        break;
                    default:
                        System.out.println("Not a valid option." + "\n");
                }
            } while (!done); 
    }
}

