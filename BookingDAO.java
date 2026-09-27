
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingDAO {

    public boolean bookFlight(Booking booking) {

        try {

            Connection con = DBConnection.getConnection();

            // Insert booking
            String insertQuery = "INSERT INTO bookings(user_id, flight_id, passenger_name, age, gender, phone, seat_number, booking_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, 1); // Temporary user_id (replace after registration/login)
            ps.setInt(2, booking.getFlightId());
            ps.setString(3, booking.getPassengerName());
            ps.setInt(4, booking.getAge());
            ps.setString(5, booking.getGender());
            ps.setString(6, booking.getPhone());
            ps.setString(7, booking.getSeatNumber());
            ps.setDate(8, java.sql.Date.valueOf(booking.getBookingDate()));
            ps.setString(9, booking.getStatus());

            int rows = ps.executeUpdate();

            // Reduce available seats
            PreparedStatement ps2 = con.prepareStatement(
                    "UPDATE flights SET available_seats = available_seats - 1 WHERE flight_id = ?");

            ps2.setInt(1, booking.getFlightId());
            ps2.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }
    public ResultSet getBookingHistory() {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            	    "SELECT " +
            	    "b.booking_id, " +
            	    "b.passenger_name, " +
            	    "b.age, " +
            	    "b.gender, " +
            	    "b.phone, " +
            	    "f.flight_number, " +
            	    "f.source_city, " +
            	    "f.destination_city, " +
            	    "b.booking_date, " +
            	    "b.seat_number, " +
            	    "b.status " +
            	    "FROM bookings b " +
            	    "JOIN flights f ON b.flight_id = f.flight_id";

            PreparedStatement ps = con.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }
}