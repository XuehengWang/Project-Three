run:  compile test
	java frontEnd

compile: FlightBackEnd.class
	javac frontEnd.java

FlightBackEnd.class: loadGraph.class CS400Graph.class
	javac FlightBackEnd.java

loadGraph.class: Airport.class flights.csv
	javac loadGraph.java

Airport.class:
	javac Airport.java

CS400Graph.class: GraphADT.class
	javac CS400Graph.java

GraphADT.class:
	javac GraphADT.java

test: flightTest.class
	java -jar junit5.jar --class-path . --scan-classpath --details tree

flightTest.class:
	javac -cp .:junit5.jar flightTest.java

clean:
	$(RM) *.class


