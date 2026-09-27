
import java.sql.*;
import java.util.ArrayList;

public class FlightDAO {

    public ArrayList<Flight> getFlights(){

        ArrayList<Flight> list = new ArrayList<>();

        try{

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM flights");

            while(rs.next()){

                Flight flight = new Flight(

                        rs.getInt("flight_id"),
                        rs.getString("flight_number"),
                        rs.getString("source_city"),
                        rs.getString("destination_city"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getDouble("price"),
                        rs.getInt("available_seats")
                );

                list.add(flight);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return list;

    }
    public Flight getFlight(String source, String destination) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM flights WHERE source_city=? AND destination_city=?");

            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Flight(
                        rs.getInt("flight_id"),
                        rs.getString("flight_number"),
                        rs.getString("source_city"),
                        rs.getString("destination_city"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getDouble("price"),
                        rs.getInt("available_seats")
                );

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

}
