//--== CS400 File Header Information ==--
//Name: Justin Yun
//Email: jlyun@wisc.edu
//Team: JD
//TA: Harper
//Lecturer: Florian Heimerl


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class flightTest {

    @BeforeEach
    void loading() {
	FlightBackEnd.loadData();
    }

    @Test
    //Check if the path is the shortest.
    void test1() {
	Airport origin = FlightBackEnd.getAirport("Milwaukee");
	Airport destination = FlightBackEnd.getAirport("Madison");
	assertEquals(FlightBackEnd.pathCost(origin, destination), 74);
    }

    @Test
    //Check if the path is the shortest.
    void test2() {
	Airport origin = FlightBackEnd.getAirport("Milwaukee");
	Airport destination = FlightBackEnd.getAirport("Madison");
	assertEquals(FlightBackEnd.findPath(origin, destination).toString(), "[MKE (Milwaukee,WI) , MSN (Madison,WI) ]");
    }

    @Test
    void test3() {
	Airport origin = FlightBackEnd.getAirport("Madison");
	Airport destination = FlightBackEnd.getAirport("Los Angeles");
	assertEquals(FlightBackEnd.pathCost(origin, destination), 877);
    }

    @Test
    //Check if the path is the shortest.
    void test4() {
	Airport origin = FlightBackEnd.getAirport("Milwaukee");
	Airport destination = FlightBackEnd.getAirport("Madison");
	assertEquals(FlightBackEnd.findPath(origin, destination).toString(), "[MKE (Milwaukee,WI) , MSN (Madison,WI) ]");
    }


    @Test
    //Check if the path is the shortest.
    void test5() {
	Airport origin = FlightBackEnd.getAirport("Los Angeles");
	Airport destination = FlightBackEnd.getAirport("sANTA ANA");
	System.out.println(FlightBackEnd.findPath(origin, destination).toString());
	assertEquals(FlightBackEnd.findPath(origin, destination).toString(), "[LAX (Los Angeles,CA) , SBA (Santa Barbara,CA) , SNA (Santa Ana,CA) ]");
    }


    @Test
    void test6() {
	Airport origin = FlightBackEnd.getAirport("Chicago");
	Airport destination = FlightBackEnd.getAirport("milwaukee");
	assertEquals(FlightBackEnd.pathCost(origin, destination)-FlightBackEnd.pathCost(destination, origin),0);
    }

    @Test
    //When if you put Wrong origin / destination
    void test7() {
	Airport origin = FlightBackEnd.getAirport("Milwaukee");
	Airport wrongDestination = FlightBackEnd.getAirport("Seoul");
	assertEquals(FlightBackEnd.findPath(origin, wrongDestination), null);
    }

    @Test
    void test8() {
	Airport wrongOrigin = FlightBackEnd.getAirport("ch1kago");
	Airport wrongDestination = FlightBackEnd.getAirport("10s angeles");
	assertEquals(FlightBackEnd.findPath(wrongOrigin, wrongDestination), null);
    }


    @Test
    void test9() {
	Airport wrongOrigin = FlightBackEnd.getAirport("pr0vidence");
	Airport destination = FlightBackEnd.getAirport("los angeles");
	assertEquals(FlightBackEnd.findPath(wrongOrigin, destination), null);
    }

    @Test
    void test10() {
	Airport origin = FlightBackEnd.getAirport("Madison");
	Airport destination = FlightBackEnd.getAirport("madison");
	assertEquals(FlightBackEnd.pathCost(origin, destination),0);
	assertEquals(FlightBackEnd.findPath(origin, destination).toString(), "[MSN (Madison,WI) ]");

    }





}
