import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;


public class FlightBackEnd{
  static CS400Graph<Airport> graph = new CS400Graph<Airport>();
  static Hashtable<String,Airport>airports = new Hashtable<String,Airport>();
  //city name -> airport
  
  public static void loadData() {
    loadGraph data = new loadGraph();
    graph = data.graph;
    airports = data.airports;
  }
  
  public static Airport getAirport(String cityName) {
      return airports.get(cityName.toLowerCase());
  }
  
  public static List<Airport> possibleDest(Airport port1) {
    CS400Graph<Airport>.Vertex port = graph.vertices.get(port1);
    List<CS400Graph<Airport>.Edge> neighbor = port.edgesLeaving;
    List<Airport> straightDest = new ArrayList<>();
    for(CS400Graph<Airport>.Edge e:neighbor) {
      straightDest.add(e.target.data);
    }
    return straightDest;
  }


  public static List<String> findPath(Airport port1, Airport port2) {
    try {
      CS400Graph<Airport>.Path path = graph.dijkstrasShortestPath(port1, port2);
      List<String> pathAirportName = new ArrayList<String>();
      for (Airport a:path.dataSequence) {
        pathAirportName.add(a.toString());
      }
      return pathAirportName;
    }
    catch(NoSuchElementException e) {
      return null;
    } 
  }


  public static int pathCost(Airport port1, Airport port2) {
    return graph.getPathCost(port1, port2);
  }
  

}
