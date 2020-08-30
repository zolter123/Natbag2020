package natbag;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Flight {
	public static final int Days_Of_Week = 7;

	public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
	private String dayOfWeek;
	private int flightNum;
	private int terminal;
	private String flightCompany;
	private String country;
	private String city;
	private String localAirPort;
	private LocalDateTime flightDate;
	private boolean isDeparture;

	public Flight(boolean isDep, String company, String country, String City, String airPort, String date, int terminal,
			int flightNum) {

		setFlightCompany(company);
		setCountry(country);
		setCity(City);
		setLocalAirPort(airPort);
		setFlightDate(date);
		setTerminal(terminal);
		setFlightNum(flightNum);
		setDeparture(isDep);
		setDayOfWeek(flightDate.getDayOfWeek().toString());
		
	}

	public Flight() {
		// default constructor for temp;
	}

	
	public String toString(boolean isHtml) {
		String str;
		if (isDeparture) {
			if(isHtml){
				str = "<tr>";
				str = str + "<td>" + dayOfWeek+ ", " +showDate() + "</td>";
				str = str + "<td>" + flightNum + "</td>"; 
				str = str + "<td>" + terminal + "</td>";
				str = str + "<td>" + flightCompany +"</td>";
				str = str + "<td>" + country+", " + city+"</td>";
				str = str + "<td>" + localAirPort +"</td>" +"</tr>";
				
				return str;
			}
			return "Flight take of on: " + dayOfWeek + ", " + showDate() + ", flight Number: " + flightNum
					+ ", terminal: " + terminal + ", Flight Company: " + flightCompany + ",Destination: Country "
					+ country + ", City " + city + ", arriving to air port: " + localAirPort;
		} else {
			if(isHtml){
				
					str = "<tr>";
					str = str + "<td>" + dayOfWeek+ ", " +showDate() + "</td>";
					str = str + "<td>" + flightNum + "</td>"; 
					str = str + "<td>" + terminal + "</td>";
					str = str + "<td>" + flightCompany +"</td>";
					str = str + "<td>" + country+", " + city+"</td>";
					str = str + "<td>" + localAirPort +"</td>" +"</tr>";
					
					return str;
			}
		
		return "Flight arriving on: " + dayOfWeek + ", " + showDate() + ", flight Number: " + flightNum + ", terminal: "
				+ terminal + ", Flight Company: " + flightCompany + ",Flight Origins: Country " + country + ", City "
				+ city + ", arriving from air port: " + localAirPort;
		}
	}

	private String showDate() {
		String str = flightDate.getDayOfMonth() + "/" + flightDate.getMonthValue() + "/" + flightDate.getYear() + " "
				+ flightDate.getHour() + ":";
		if (flightDate.getMinute() >= 10) {
			str = str + flightDate.getMinute();
		} else {
			str = str + "0" + flightDate.getMinute();
		}
		return str;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public int getTerminal() {
		return terminal;
	}

	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}

	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocalAirPort() {
		return localAirPort;
	}

	public void setLocalAirPort(String localAirPort) {
		this.localAirPort = localAirPort;
	}

	public LocalDateTime getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String date) {
		this.flightDate = LocalDateTime.parse(date, format);
	}

	public boolean isDeparture() {
		return isDeparture;
	}

	public void setDeparture(boolean isDeparture) {
		this.isDeparture = isDeparture;
	}

	
	

}
