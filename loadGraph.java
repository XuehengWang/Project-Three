// --== CS400 File Header Information ==--
// Name: Xueheng Wang
// Email: xwang2395@wisc.edu
// Team: JD
// Role: Data wrangler
// TA: Harper
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * This class is to load the graph of air routes in the u.s., those routes are filtered by 100 to
 * 400 miles.
 * 
 * @author Xueheng Wang
 *
 */
public class loadGraph {
  public CS400Graph<Airport> graph; // graph of flight routes
  public Hashtable<String, Airport> airports;// hash table of all Airport objects using city name
                                             // (in lower case) as the key

  /**
   * The constructor of loadGraph, when called, the full graph will be loaded and stored in field
   * graph, and every objects of Airport are stored in the hash table airports with city name as its key.
   */
  public loadGraph() {
    graph = new CS400Graph<Airport>();
    airports = new Hashtable<>();
    try {
      File file = new File("flights.csv");
      FileReader reader = new FileReader(file);
      BufferedReader br = new BufferedReader(reader);
      br.readLine();
      String line = br.readLine();
      while (line != null) {
        String[] info = line.split(",");
        // get or create airport object for origin and add to graph and hash table
        String originCity = info[4].substring(1);
        String originCityLowerCase = originCity.toLowerCase();
        Airport origin;
        if (airports.containsKey(originCityLowerCase)) {// if the airport has existed
          origin = airports.get(originCityLowerCase);
        } else {// if the airport has not existed
          origin = new Airport(originCity, info[3], info[5].substring(1, 3));
          airports.put(originCityLowerCase, origin);
          graph.insertVertex(origin);
        }

        // get or create airport object for destination and add to graph and hash table
        String desCity = info[7].substring(1);
        String desCityLowerCase = desCity.toLowerCase();
        Airport destination;
        if (airports.containsKey(desCityLowerCase)) {
          destination = airports.get(desCityLowerCase);
        } else {
          destination = new Airport(desCity, info[6], info[8].substring(1, 3));
          airports.put(desCityLowerCase, destination);
          graph.insertVertex(destination);
        }

        // add the route with distance
        int distance = Integer.parseInt(info[1]);
        graph.insertEdge(origin, destination, distance);

        line = br.readLine();
      }
    } catch (IOException e1) {
      System.out.println("Encountered IOException.");
      e1.printStackTrace();;
    }

  }
}
