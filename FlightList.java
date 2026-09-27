
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class FlightList extends JFrame {

    JTable table;
    DefaultTableModel model;

    public FlightList() {

        setTitle("Available Flights");

        setSize(800,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("Flight ID");
        model.addColumn("Flight No");
        model.addColumn("Source");
        model.addColumn("Destination");
        model.addColumn("Departure");
        model.addColumn("Arrival");
        model.addColumn("Price");
        model.addColumn("Seats");

        table = new JTable(model);

        loadFlights();

        add(new JScrollPane(table));

        setVisible(true);
    }

    private void loadFlights(){

        FlightDAO dao = new FlightDAO();

        ArrayList<Flight> flights = dao.getFlights();

        for(Flight f : flights){

            model.addRow(new Object[]{

                    f.getFlightId(),
                    f.getFlightNumber(),
                    f.getSource(),
                    f.getDestination(),
                    f.getDepartureTime(),
                    f.getArrivalTime(),
                    f.getPrice(),
                    f.getSeats()

            });

        }

    }

    public static void main(String args[]){

        new FlightList();

    }

}