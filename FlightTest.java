
import java.util.ArrayList;

public class FlightTest {

    public static void main(String args[]){

        FlightDAO dao = new FlightDAO();

        ArrayList<Flight> list = dao.getFlights();

        for(Flight f : list){

            System.out.println(
                    f.getFlightNumber()+"  "
                    +f.getSource()+" -> "
                    +f.getDestination()+"  ₹"
                    +f.getPrice());

        }

    }

}