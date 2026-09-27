
public class FlightSearchTest {

    public static void main(String[] args) {
    	FlightDAO dao = new FlightDAO();

    	Flight flight = dao.getFlight("Trivandrum", "Delhi");

    	if (flight != null) {
    	    System.out.println("Found: " + flight.getFlightNumber());
    	    System.out.println("Price: " + flight.getPrice());
    	    System.out.println("Time: " + flight.getDepartureTime());
    	} else {

            System.out.println("Flight Not Found");

        }

    }

}