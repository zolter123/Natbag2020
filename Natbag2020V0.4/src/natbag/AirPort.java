package natbag;

import java.beans.FeatureDescriptor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AirPort {

	private ArrayList<Flight> arrivals;
	private ArrayList<Flight> departures;

	public AirPort() {
		arrivals = new ArrayList<Flight>();
		departures = new ArrayList<Flight>();
	}

	public String toString(boolean isHtml) {
		String str = "All the arraving flights: \n";
		for (int i = 0; i < arrivals.size(); i++) {
			str = str + arrivals.get(i).toString(isHtml) + "\n";
		}

		str = str + "All the departuring flights: \n";
		for (int i = 0; i < departures.size(); i++) {
			str = str + departures.get(i).toString(isHtml) + "\n";
		}

		return str;

	}

	public void addDeparture(Flight temp) {
		departures.add(temp);
	}

	public void addArriving(Flight temp) {
		arrivals.add(temp);
	}

	public void sortDeparturesByDate() {
		Comparator<Flight> compareBydate = new Comparator<Flight>() {

			public int compare(Flight o1, Flight o2) {

				return o1.getFlightDate().compareTo(o2.getFlightDate());
			}
		};
		Collections.sort(departures, compareBydate);

	}

	public String showDepartures(boolean isHtml) {
		String str = "All the departuring flights: \n";
		for (int i = 0; i < departures.size(); i++) {
			str = str + departures.get(i).toString(isHtml) + "\n";
		}
		return str;
	}

	public void sortArrivingByDate() {
		Comparator<Flight> compareBydate = new Comparator<Flight>() {

			public int compare(Flight o1, Flight o2) {

				return o1.getFlightDate().compareTo(o2.getFlightDate());
			}
		};
		Collections.sort(arrivals, compareBydate);

	}
	
	public String showArriving(boolean isHtml) {
		String str = "All the arraving flights: \n";
		for (int i = 0; i < arrivals.size(); i++) {
			str = str + arrivals.get(i).toString(isHtml) + "\n";
		}
		return str;
	}

	public String getReleventArrivals(String flightCompany, String country, String city, String localAirPort, String from,
			String till, String days, boolean isHtml) {
		StringBuffer buff = new StringBuffer();
		LocalDateTime dateFrom;
		LocalDateTime dateTill;
		try {
			 dateFrom = LocalDateTime.parse(from, Flight.format);
			 dateTill = LocalDateTime.parse(till, Flight.format);
		} catch (Exception e) {
			dateFrom = LocalDateTime.parse("01/01/0001 00:00", Flight.format);
			dateTill = LocalDateTime.parse("01/01/2120 00:00", Flight.format);
		}
		
		String[] allDays = days.split(" ");
		if(isHtml){
			buff.append("<style> table, th, td {border: 1px solid black;border-collapse: collapse;}</style>");
			buff.append("<h1> All Relevent Arriving Flights</h1>");
			buff.append("<table>");
			buff.append("<tr>");
			buff.append("<th> Flight arrives on</th>");
			buff.append("<th> Flight Number</th>");
			buff.append("<th> Terminal</th>");
			buff.append("<th> Air Line</th>");
			buff.append("<th> Origins</th>");
			buff.append("<th> Origin AirPort</th> </tr>");
			
			
		}
		
		for(int i=0;i<arrivals.size();i++) {
			if(arrivals.get(i).getFlightCompany().equalsIgnoreCase(flightCompany) || flightCompany.equals("")) {
				if(arrivals.get(i).getCountry().equalsIgnoreCase(country) || country.equals("")) {
					if(arrivals.get(i).getCity().equalsIgnoreCase(city) || city.equals("")) {
						if(arrivals.get(i).getLocalAirPort().equalsIgnoreCase(localAirPort) || localAirPort.equals("")) {
							if(arrivals.get(i).getFlightDate().isAfter(dateFrom)&& arrivals.get(i).getFlightDate().isBefore(dateTill)) {
								for(int j=0; j<allDays.length;j++) {
									if(arrivals.get(i).getDayOfWeek().equalsIgnoreCase(allDays[j]) ||allDays[j].equals("")) {
										buff.append(arrivals.get(i).toString(isHtml)+"\n");
										
									}
								}
							}
						}
					}
				}
			}
		}
		if(buff.toString().equals(""))
			buff.append("No Result Found");
		if(isHtml)
			buff.append("</table>");
		
		return buff.toString();
	}

	public String getReleventDepartures(String flightCompany, String country, String city, String localAirPort,
			String from, String till, String days, boolean isHtml) {
		StringBuffer buff = new StringBuffer();
		LocalDateTime dateFrom;
		LocalDateTime dateTill;
		try {
			 dateFrom = LocalDateTime.parse(from, Flight.format);
			 dateTill = LocalDateTime.parse(till, Flight.format);
		} catch (Exception e) {
			dateFrom = LocalDateTime.parse("01/01/0001 00:00", Flight.format);
			dateTill = LocalDateTime.parse("01/01/2120 00:00", Flight.format);
		}
		
		String[] allDays = days.split(" ");
		if(isHtml){
			buff.append("<style> table, th, td {border: 1px solid black;border-collapse: collapse;}</style>");
			buff.append("<h1> All Relevent Departuring Flights</h1>");
			buff.append("<table>");
			buff.append("<tr>");
			buff.append("<th> Flight take of on</th>");
			buff.append("<th> Flight Number</th>");
			buff.append("<th> Terminal</th>");
			buff.append("<th> Air Line</th>");
			buff.append("<th> Destination</th>");
			buff.append("<th> Landing AirPort</th> </tr>");
			
			
		}
		for(int i=0;i<departures.size();i++) {
			if(departures.get(i).getFlightCompany().equalsIgnoreCase(flightCompany) || flightCompany.equals("")) {
				if(departures.get(i).getCountry().equalsIgnoreCase(country) || country.equals("")) {
					if(departures.get(i).getCity().equalsIgnoreCase(city) || city.equals("")) {
						if(departures.get(i).getLocalAirPort().equalsIgnoreCase(localAirPort) || localAirPort.equals("")) {
							if(departures.get(i).getFlightDate().isAfter(dateFrom)&& departures.get(i).getFlightDate().isBefore(dateTill)) {
								for(int j=0; j<allDays.length;j++) {
									if(departures.get(i).getDayOfWeek().equalsIgnoreCase(allDays[j]) ||allDays[j].equals("")) {
										buff.append(departures.get(i).toString(isHtml)+"\n");
										
									}
								}
							}
						}
					}
				}
			}
		}
		if(buff.toString().equals(""))
			buff.append("No Result Found");
		if(isHtml)
			buff.append("</table>");
		return buff.toString();

	}

}
