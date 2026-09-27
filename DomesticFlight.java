import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class DomesticFlight extends JFrame
{
	JComboBox CBFrom, CBTo, CBClass, CBAdult, CBChildren, CBInfant;
	JLabel LFrom, LTo, LBookingDate, LClass, LAdult, LChildren, LInfant, LBookingDetails, LPassengerDetails, LDate, LImg1, LImg2, LNotes;
	JTextField TFBookingDate;
	Icon img1, img2;
	JButton BFindFlight;
	JPanel PPanel1, PPanel2;

	LoginPage type1;

	public DomesticFlight(LoginPage type1)
	{
		Container c =getContentPane();
		c.setLayout(new BorderLayout());
		String[] sItem1={"Trivandrum"};
		String[] sItem2 ={ "Bangalore", "Chennai ", "Delhi", "Goa", "Hyderabad", "Kolkata", "Lucknow", "Mumbai", "Vishakapatnam" };
		String[] sItem3={"Economic","Business"};

		this.type1 = type1;
		PPanel1 = new JPanel(null);
		PPanel1.setPreferredSize(new Dimension(500,200));

		LBookingDetails = new JLabel("<html><b><font color=\"#C71585\">Booking Details</font></b></html>");
		LFrom = new JLabel("From          :");
		LTo = new JLabel("To               :");
		LBookingDate = new JLabel("Booking Date:");
		LClass = new JLabel("Class         :");

		CBFrom = new JComboBox(sItem1);
		CBTo = new JComboBox(sItem2);
		CBClass = new JComboBox(sItem3);

		TFBookingDate = new JTextField(10);
		LDate = new JLabel("(DD/MM/YYYY)");
		LDate.setForeground(Color.red);

		img1=new ImageIcon("map1.jpg");
		LImg1 = new JLabel(img1);

		BFindFlight = new JButton("Find Flight");

		LBookingDetails.setBounds(20,3,100,20);

		LFrom.setBounds(20,40,100,20);
		CBFrom.setBounds(100,40,100,20);

		LTo.setBounds(20,100,100,20);
		CBTo.setBounds(100,100,100,20);

		LBookingDate.setBounds(14,160,100,20);
		TFBookingDate.setBounds(100,160,100,20);
		LDate.setBounds(210,160,100,20);

		LClass.setBounds(20,220,100,20);
		CBClass.setBounds(100,220,100,20);

		BFindFlight.setBounds(50,270,100,25);

		LImg1.setBounds(0,290,495,260);

		PPanel1.add(LBookingDetails);
		PPanel1.add(LFrom);
		PPanel1.add(CBFrom);
		PPanel1.add(LTo);
		PPanel1.add(CBTo);
		PPanel1.add(LBookingDate);
		PPanel1.add(TFBookingDate);
		PPanel1.add(LDate);
		PPanel1.add(LClass);
		PPanel1.add(CBClass);
		PPanel1.add(BFindFlight);
		PPanel1.add(LImg1);
		PPanel1.setBackground(Color.white);

		c.add(PPanel1,BorderLayout.WEST);

		PPanel2 = new JPanel(null);
		PPanel2.setPreferredSize(new Dimension(320,160));

		LPassengerDetails=new JLabel("<html><b><font color=\"#C71585\">PassengerDetails</font></b></html>");

		LAdult = new JLabel("Adults(12+)");

		LChildren = new JLabel("Children(2-11)");
		LInfant = new JLabel("Infants(under 2)");

		String[] item4={"1","2","3","4","5","6"};
		CBAdult = new JComboBox(item4);

		String[] item5={"0","1","2","3","4"};
		CBChildren = new JComboBox(item5);

		String[] item6={"0","1","2","3"};
		CBInfant = new JComboBox(item6);

		img2 = new ImageIcon("note_bg.gif");
		LImg2 = new JLabel(img2);
		LNotes = new JLabel("<html><body><p>NOTE: Bookings with International Credit Cards <p> have temporarily been suspended.This Service<p> will resume shortly and we will have a notice<p> posted on our website.We regret any <p>inconvenience caused to our passengers.</body></html>");

		LPassengerDetails.setBounds(40,3,100,20);

		LAdult.setBounds(40,40,100,20);
		CBAdult.setBounds(140,40,100,20);

		LChildren.setBounds(40,105,100,20);
		CBChildren.setBounds(140,105,100,20);

		LInfant.setBounds(40,170,100,20);
		CBInfant.setBounds(140,170,100,20);

		LImg2.setBounds(16,220,320,200);
		LNotes.setBounds(55,240,380,180);

		PPanel2.add(LPassengerDetails);
		PPanel2.add(LAdult);
		PPanel2.add(LChildren);
		PPanel2.add(LInfant);
		PPanel2.add(CBAdult);
		PPanel2.add(CBChildren);
		PPanel2.add(CBInfant);

		PPanel2.add(LNotes);
		PPanel2.add(LImg2);

		PPanel2.setBackground(Color.white);

		c.add(PPanel2,BorderLayout.EAST);

		setSize(795,580);
		setVisible(true);

		BFindFlight.addActionListener(new button3(this, type1));
	}
	public static void main(String args[])
	{
		LoginPage type1=null;
		new DomesticFlight(type1);
	}
}

class button3 implements ActionListener
{
	DomesticFlight type;
	LoginPage type1;
	button3(DomesticFlight type, LoginPage type1)
	{
		this.type = type;
		this.type1 = type1;
	}
	public void actionPerformed(ActionEvent e)
	{
		String sFrom = (String)type.CBFrom.getSelectedItem();
		String sTo = (String)type.CBTo.getSelectedItem();
		String sClass = (String)type.CBClass.getSelectedItem();
		String sBookingDate = type.TFBookingDate.getText();
		if (sBookingDate.trim().isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Please enter the booking date (YYYY-MM-DD).");
		    return;
		}

		Integer iAdult = Integer.parseInt((String)type.CBAdult.getSelectedItem());
		Integer iChildren = Integer.parseInt((String)type.CBChildren.getSelectedItem());
		Integer iInfant = Integer.parseInt((String)type.CBInfant.getSelectedItem());

		int i = 0;

		FlightDAO dao = new FlightDAO();

		Flight flight = dao.getFlight(sFrom, sTo);

		if (flight == null) {

		    JOptionPane.showMessageDialog(null, "Flight not found!");

		    return;
		}

		double price = flight.getPrice();

		String sTime = flight.getDepartureTime();

		int flightId = flight.getFlightId();

		int availableSeats = flight.getSeats();

		if (sClass.equals("Business")) {

		    price = price * 3;

		}

		Integer iPrice = (int) price;
		type.setTitle(iPrice + " " + sTime);

		iPrice = (iPrice*iAdult)+(iPrice*(iChildren/2));

		if (availableSeats <= 0) {

		    JOptionPane.showMessageDialog(null, "Seats are full!");

		    return;
		}

		int choice = JOptionPane.showConfirmDialog(
		        null,
		        "Seats available. Do you want to book now?");

		if (choice == JOptionPane.YES_OPTION) {

		    Booking booking = new Booking(

		            flightId,
		            "Guest Passenger",
		            iAdult,
		            "Male",
		            "9999999999",
		            "A1",
		            sBookingDate,
		            "CONFIRMED"

		    );

		    BookingDAO bookingDAO = new BookingDAO();

		    boolean success = bookingDAO.bookFlight(booking);

		    if (success) {

		        JOptionPane.showMessageDialog(
		                null,
		                "Booking Successful!");

		        new PrintTicket1(
		                sFrom,
		                sTo,
		                sClass,
		                iAdult,
		                iChildren,
		                iInfant,
		                sBookingDate,
		                iPrice,
		                sTime);

		    } else {

		        JOptionPane.showMessageDialog(
		                null,
		                "Booking Failed!");

		    }

		}
	}
}


class Save2 implements Serializable
{
	String sFrom, sTo, sClass, sBookingDate, sTime;
	Integer iPrice, iAdult, iChildren, iInfant;
//	int iCount;
	public Save2(String sFrom, String sTo, String sClass, Integer iAdult, Integer iChildren, Integer iInfant, String sBookingDate, Integer iPrice, String sTime)
	{
		this.sFrom=sFrom;
		this.sTo=sTo;
		this.sClass=sClass;
		this.iAdult=iAdult;
		this.iChildren=iChildren;
		this.iInfant=iInfant;
		this.sBookingDate=sBookingDate;
		this.iPrice=iPrice;
		this.sTime=sTime;
//		this.iCount = iCount;
	}
	public String toString()
	{
		return sFrom+" "+sTo+" "+sClass+" "+iAdult+" "+iChildren+" "+iInfant+" "+sBookingDate+" "+iPrice+" "+sTime;
	}
}