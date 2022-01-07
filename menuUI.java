/* Matthew, Jason, Yong Team 1 
CS331 - Team Project - 12/11/12
Clean and Go Application 
Description: Java application for Clean and Go shop. Retrieve simple queries based on shop data, employees, revenue, and more. Updates (deletes) data when prompted with user information matching database information. 
Desc of file:  Contains all menuUI for the java application. 
*/
package TPfinal;

public class menuUI {
    public static void printMenu() {
        System.out.println("*****************************************************************************");
        System.out.println("                                 ***********");
        System.out.println("                         Welcome to Clean-and-Go Shop");
        System.out.println("                                 ***********");
        System.out.println("*****************************************************************************");
        System.out.println("1. Equipment & Supplies");
        System.out.println("2. Customers & Services");
        System.out.println("3. Employees");
        System.out.println("4. Updates");
        System.out.println("5. Quit" + "\n");
    }

    public static void deleteMenu() {

        System.out.println("*****************************************************************************");
        System.out.println("                         Welcome to Clean-and-Go Shop");
        System.out.println("                                 4. Updates");
        System.out.println("*****************************************************************************");
        System.out.println("- (Note) Insert and Update options not yet implemented -");
        System.out.println("1. Delete specific equipment.");
        System.out.println("2. Delete a specific service.");
        System.out.println("3. Delete specific customer information.");
        System.out.println("4. Delete specific employee information.");
        System.out.println("5. Quit" + "\n");
    }

    public static void CustomerServiceMenu() {
        System.out.println("*****************************************************************************");
        System.out.println("                         Welcome to Clean-and-Go Shop");
        System.out.println("                           2. Customer And Services");
        System.out.println("*****************************************************************************");
        System.out.println("1. Analyze the progress of the business");
        System.out.println("2. Services");
        System.out.println("3. Customers");
        System.out.println("4. Quit" + "\n");
    }

    public static void analyzeMenu() {
        System.out.println("*****************************************************************************");
        System.out.println("                         Welcome to Clean-and-Go Shop");
        System.out.println("                     2-1. Analyze the progress of the business");
        System.out.println("*****************************************************************************");
        System.out.println("1. Total number of new customers");
        System.out.println("2. Total number of service transactions");
        System.out.println("3. Quit" + "\n");
    }

    public static void customerMenu() {
        System.out.println("*****************************************************************************");
        System.out.println("                         Welcome to Clean-and-Go Shop");
        System.out.println("                                 2-3. Customer");
        System.out.println("*****************************************************************************");
        System.out.println("1. Name of Service & Customers");
        System.out.println("2. Customer Number per month");
        System.out.println("3. Quit" + "\n");
    }

    public static void servicesMenu() {
        System.out.println("*****************************************************************************");
        System.out.println("                         Welcome to Clean-and-Go Shop");
        System.out.println("              2-2. Retrieve some information about services offered");
        System.out.println("*****************************************************************************");
        System.out.println("1. Return most popular service");
        System.out.println("2. Return no. of service transactions in the last 6 months");
        System.out.println("3. Return annual revenue from all services provided to customers");
        System.out.println("4. Quit" + "\n");
    }
}
