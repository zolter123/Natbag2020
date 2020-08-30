import java.time.LocalDateTime;

import natbag.AirPort;
import natbag.Flight;

public class ClientProg {

	public static AirPort port = new AirPort();

	public static void main(String[] args) {
		hardCode();
		boolean isHtml = args.length > 0 && args[0].equalsIgnoreCase("html");
		boolean isDeparture = args.length > 1
				&& args[1].equalsIgnoreCase("departures");
		String airLine = args[2];
		String country = args[3];
		String city = args[4];
		String airport = args[5];
		String day1 = args[6];
		String month1 = args[7];
		String year1 = args[8];
		String day2 = args[9];
		String month2 = args[10];
		String year2 = args[11];
		String[] alldays = { "" };
		String from = day1 + "/" + month1 + "/" + year1 + " 00:00";
		String till = day2 + "/" + month2 + "/" + year2 + " 00:00";
		
		

		
	}
	

	public static void hardCode() {
		port.addDeparture(new Flight(true, "BritishAirLine", "Britan", "London", "York", "30/10/2020 10:05", 5, 1318));
		port.addDeparture(
				new Flight(true, "TurkishAirLines", "Turkey", "Istanbul", "Sabiha", "05/11/2020 10:06", 4, 1464));
		port.addDeparture(new Flight(true, "MongoliaAir", "Mongolia", "Mongolia", "alla", "30/10/2020 10:07", 8, 1564));

		port.addArriving(new Flight(false, "RussiaTurs", "Russia", "Moscow", "Piterskiy", "06/03/2020 11:05", 2, 4351));
		port.addArriving(new Flight(false, "GermanFly", "Germany", "Berlin", "Zadoish", "06/03/2020 10:15", 5, 3652));
		port.addArriving(new Flight(false, "ClosetTours", "Narnia", "Kingdom", "Lion", "06/03/2020 11:10", 1, 2575));

	}


}
