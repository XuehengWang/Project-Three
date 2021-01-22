// --== CS400 File Header Information ==--
// Name: Xueheng Wang
// Email: xwang2395@wisc.edu
// Team: JD
// Role: Data wrangler
// TA: Harper
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 * This class represents an airport in a city.
 * 
 * @author Xueheng Wang
 *
 */
public class Airport {

  private String city; // name of the city where airport is located
  private String airportCode;// code of the airport
  private String stateAbbreviation; // abbreviation of the state where the city is located

  /**
   * Constructor of Airport class that initiate all the fields within the class.
   * 
   * @param city
   * @param airportCode
   * @param stateAbbreviation
   */
  public Airport(String city, String airportCode, String stateAbbreviation) {
    this.city = city;
    this.airportCode = airportCode;
    this.stateAbbreviation = stateAbbreviation;
  }

  /**
   * @return city name
   */
  public String getCity() {
    return city;
  }

  /**
   * 
   * @return airport code
   */
  public String getAirportCode() {
    return airportCode;
  }

  /**
   * 
   * @return abbreviation of state
   */
  public String getState() {
    return stateAbbreviation;
  }

 @Override
  /**
   * Get a string representation of this airport object using city name. (So when the shortest paths
   * are printed out, it should be shown usin_ cities)
   */
  public String toString() {
    return airportCode + " (" + city + "," + stateAbbreviation +") ";
  }
}
