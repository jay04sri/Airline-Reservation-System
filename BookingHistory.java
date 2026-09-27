
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class BookingHistory extends JFrame{

    JTable table;

    DefaultTableModel model;

    public BookingHistory(){

        setTitle("Booking History");

        setSize(900,500);

        setLocationRelativeTo(null);

        model=new DefaultTableModel();

        model.setColumnIdentifiers(new String[]{

        	    "Booking ID",
        	    "Passenger",
        	    "Age",
        	    "Gender",
        	    "Phone",
        	    "Flight",
        	    "From",
        	    "To",
        	    "Date",
        	    "Seat",
        	    "Status"

        	});

        table=new JTable(model);

        add(new JScrollPane(table));

        loadBookings();

        setVisible(true);

    }

    public void loadBookings(){

        try{

            BookingDAO dao=new BookingDAO();

            ResultSet rs=dao.getBookingHistory();

            while(rs.next()){

            	model.addRow(new Object[]{

            		    rs.getInt("booking_id"),
            		    rs.getString("passenger_name"),
            		    rs.getInt("age"),
            		    rs.getString("gender"),
            		    rs.getString("phone"),
            		    rs.getString("flight_number"),
            		    rs.getString("source_city"),
            		    rs.getString("destination_city"),
            		    rs.getDate("booking_date"),
            		    rs.getString("seat_number"),
            		    rs.getString("status")

            		});
            }

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}
