public class Booking {

    private int bookingId;
    private int flightId;
    private String passengerName;
    private int age;
    private String gender;
    private String phone;
    private String seatNumber;
    private String bookingDate;
    private String status;

    public Booking(int bookingId,
                   int flightId,
                   String passengerName,
                   int age,
                   String gender,
                   String phone,
                   String seatNumber,
                   String bookingDate,
                   String status){

        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
        this.status = status;

    }
    public Booking(int flightId,
            String passengerName,
            int age,
            String gender,
            String phone,
            String seatNumber,
            String bookingDate,
            String status){

 this.flightId=flightId;
 this.passengerName=passengerName;
 this.age=age;
 this.gender=gender;
 this.phone=phone;
 this.seatNumber=seatNumber;
 this.bookingDate=bookingDate;
 this.status=status;

}

    public int getBookingId(){ return bookingId; }
    public int getFlightId(){ return flightId; }
    public String getPassengerName(){ return passengerName; }
    public int getAge(){ return age; }
    public String getGender(){ return gender; }
    public String getPhone(){ return phone; }
    public String getSeatNumber(){ return seatNumber; }
    public String getBookingDate(){ return bookingDate; }
    public String getStatus(){ return status; }

}
//public class Booking {
//
//    private int bookingId;
//    private int flightId;
//    private String passengerName;
//    private int age;
//    private String gender;
//    private String phone;
//    private String seatNumber;
//    private String bookingDate;
//    private String status;
//
//    public Booking(int flightId, String passengerName, int age,
//                   String gender, String phone,
//                   String seatNumber, String bookingDate,
//                   String status) {
//
//        this.flightId = flightId;
//        this.passengerName = passengerName;
//        this.age = age;
//        this.gender = gender;
//        this.phone = phone;
//        this.seatNumber = seatNumber;
//        this.bookingDate = bookingDate;
//        this.status = status;
//    }
//
//    public int getFlightId() { return flightId; }
//    public String getPassengerName() { return passengerName; }
//    public int getAge() { return age; }
//    public String getGender() { return gender; }
//    public String getPhone() { return phone; }
//    public String getSeatNumber() { return seatNumber; }
//    public String getBookingDate() { return bookingDate; }
//    public String getStatus() { return status; }
//}