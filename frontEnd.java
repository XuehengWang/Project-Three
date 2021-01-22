import java.util.List;
import java.util.Scanner;
/**
 * This class is the front end
 * @author Huiqian Jing
 *
 */
public class frontEnd {
  private final static String WELCOME_MSG = "======== WELCOME to the Shortest Flight Application ========";
  private final static String GOODBYE_MSG =
      "======== Thank you for using this Application! ========";
  private final static String MENU = "\nCOMMAND MENU:\n"
      +"[G] Get the fly route between two cities\n"
      +"[F] Find all direct destinations from origin city\n"
      +"[H] Help (display this Menu)\n"
      +"[Q] Quit the application.";
  /**
   * This method process and run the user command line
   * @param line the line to be processed
   */
  private static void processUserInput(String line) {
    char c = line.charAt(0);
    switch (String.valueOf(c).toUpperCase()) {
      case "G":
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your origin city:");
        String OrigCity = scanner.nextLine();
        Airport a1 = FlightBackEnd.getAirport(OrigCity);
        if(a1 == null) {System.out.print("No airport exists in " + OrigCity);break;}
        System.out.println("Enter your destination city:");
        String DestCity = scanner.nextLine();
        Airport a2 = FlightBackEnd.getAirport(DestCity);        
        if(a2 == null) {System.out.print("No airport exists in " + DestCity);break;}
        List<String> path =  FlightBackEnd.findPath(a1,a2);
        if(path!=null) {
          System.out.println("The minimum flight route is:");
          for(String data:path) {
            System.out.print(data + "->");
          }
          System.out.println("The total length is:" + FlightBackEnd.pathCost(a1, a2) + " miles");
        }
        else {
          System.out.println("No route exists");
          }
        break;
      case "F":
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the city name:");
        String city = scanner1.nextLine();
        Airport a3 = FlightBackEnd.getAirport(city); 
        if(a3==null) {
          System.out.print("No airport exists in " + city);
          break;
          }
        List<Airport> list = FlightBackEnd.possibleDest(a3);
        if(list!=null) {
          System.out.println("You can fly from " + a3.toString() + " to: ");
          for(Airport data:list) {
            System.out.println(data.toString());
          }
        }
        break;
      case "H":
        System.out.println(MENU);
        break;       
      default:
        System.out.println("Invalid command. Enter 'H' to get the menu");                
        
    }
  }
  /**
   * Reads and process user command line
   */
  private static void driver() {
    FlightBackEnd.loadData();
    Scanner scanner = new Scanner(System.in);
    String promptCommandLine = "\nENTER COMMAND: ";
    System.out.println(MENU);
    System.out.print(promptCommandLine);
    String line = scanner.nextLine();
    char c = line.charAt(0);
    while (Character.toUpperCase(c) != 'Q') {
      processUserInput(line);
      System.out.print(promptCommandLine);
      line = scanner.nextLine();
      c = line.charAt(0);
    }
    scanner.close();
    
  }
  /**
   * Main method for Find Shortest Flight application
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(WELCOME_MSG);
    driver();
    System.out.println(GOODBYE_MSG);    
  }
  
}