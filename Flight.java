
public class Flight {

    private int flightId;
    private String flightNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double price;
    private int seats;

    public Flight(int flightId,
                  String flightNumber,
                  String source,
                  String destination,
                  String departureTime,
                  String arrivalTime,
                  double price,
                  int seats){

        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.seats = seats;
    }

    public int getFlightId(){ return flightId; }

    public String getFlightNumber(){ return flightNumber; }

    public String getSource(){ return source; }

    public String getDestination(){ return destination; }

    public String getDepartureTime(){ return departureTime; }

    public String getArrivalTime(){ return arrivalTime; }

    public double getPrice(){ return price; }

    public int getSeats(){ return seats; }

}