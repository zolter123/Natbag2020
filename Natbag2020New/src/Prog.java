import java.time.LocalDateTime;
import java.util.Scanner;

import natbag.AirPort;
import natbag.Flight;

public class Prog {
	public static AirPort port = new AirPort();

	public static void main(String[] args) {
		hardCode();

		Scanner scan = new Scanner(System.in);

		int flightNum=0;
		int terminal=0;
		String flightCompany="";
		String country="";
		String city="";
		String localAirPort="";
		String date="";
		String type = "";
		String from="";
		String till="";
		String days="";
		
		boolean isDeparture;
		boolean flag = true;
		Flight temp = new Flight();

		System.out.println("Welcom to Natbag Managing System.");
		System.out.println("Please chose your action by action number:");
		menu();
		int choice = scan.nextInt();
		do {
			switch (choice) {
			case 1:

				System.out.println(port.toString());
				break;

			case 2:
				do {
					try {
						isDeparture = true;
						System.out.println("Please give flight number:");
						flightNum = scan.nextInt();
						System.out.println("Please give Terminal");
						terminal = scan.nextInt();
						System.out.println("Please enter the flight company:");
						flightCompany = scan.next();
						System.out.println("To which country the flight going:");
						country = scan.next();
						System.out.println("To which city:");
						city = scan.next();
						System.out.println("In Which AirPort the flight will land:");
						localAirPort = scan.next();
						scan.nextLine();
						System.out.println("When the flight is leaving? (DD/MM/YYYY HH:MM)");
						date = scan.nextLine();

						temp = new Flight(isDeparture, flightCompany, country, city, localAirPort, date, terminal,
								flightNum);
						flag = true;
					} catch (Exception e) {
						System.out.println("One of parameters was incorrect. Please try again");
						flag = false;
						scan.nextLine();

					}

				} while (flag == false);

				port.addDeparture(temp);
				break;

			case 3:
				do {
					try {
						isDeparture = false;
						System.out.println("Please give flight number:");
						flightNum = scan.nextInt();
						System.out.println("Please give Terminal");
						terminal = scan.nextInt();
						System.out.println("Please enter the flight company:");
						flightCompany = scan.next();
						System.out.println("From which country the flight going:");
						country = scan.next();
						System.out.println("From which city:");
						city = scan.next();
						System.out.println("From Which AirPort the flight will come:");
						localAirPort = scan.next();
						scan.nextLine();
						System.out.println("When the flight is landing? (DD/MM/YYYY HH:MM)");
						date = scan.nextLine();

						temp = new Flight(isDeparture, flightCompany, country, city, localAirPort, date, terminal,
								flightNum);
						flag = true;
					} catch (Exception e) {
						System.out.println("One of parameters was incorrect. Please try again");
						flag = false;
						scan.nextLine();

					}

				} while (flag == false);
				port.addArriving(temp);
				break;

			case 4:
				port.sortDeparturesByDate();
				System.out.println("Departures flights sorted by date:");
				System.out.println(port.showDepartures());
				break;

			case 5:
				port.sortArrivingByDate();
				System.out.println("Arriving flights sorted by date:");
				System.out.println(port.showArriving());
				break;

			case 6:
				System.out.println("Please enter the creteria by which you want find the flights:");
				System.out.println("***IF you want to skip filter creteria press [Enter] key***");
				System.out.println("Note! [The date range is unskipable]");
				System.out.println();
				scan.nextLine();
				flag = false;
				do {
					try {
						System.out.println("Arriving or Departuring flight?");
						type = scan.nextLine();
						System.out.println("Enter AirLine Name:");
						flightCompany = scan.nextLine();
						System.out.println("Enter country:");
						country = scan.nextLine();
						System.out.println("Enter City:");
						city = scan.nextLine();
						System.out.println("Enter AirPort");
						localAirPort = scan.nextLine();
						System.out.println("Enter Range of dates");
						System.out.println("From date:");
						 from = scan.nextLine();
						System.out.println("Untill date:");
						 till = scan.nextLine();
						System.out.println("Enter relevent days of week:");
						 days = scan.nextLine();
						flag = true;
					} catch (Exception e) {
						System.out.println("One of the creteria inputs was entered not correctry");
						System.out.println("Please enter the creterias again.");
						System.out.println();
					}

				} while (flag == false);

				if (type.equalsIgnoreCase("Arriving")) {
					System.out.println(port.getReleventArrivals(flightCompany,country, city,localAirPort,from,till, days));
				} else if( type.equalsIgnoreCase("departuring")) {
					System.out.println(port.getReleventDepartures(flightCompany,country, city,localAirPort,from,till, days));
				}else {
					System.out.println("No result found.");
				}

				break;

			}

			menu();
			System.out.println("Choce Action:");
			choice = scan.nextInt();
		} while (choice != 0);

		scan.close();

	}

	public static void menu() {
		
		System.out.println("1-> Show AirPort");
		System.out.println("2-> Add Departure Flight");
		System.out.println("3-> Add Arriving Flight");
		System.out.println("4-> Sort All Departures by Date");
		System.out.println("5-> Sort All Arrivings by Date");
		System.out.println("6-> Find flight by Specific creteria:");
		
		System.out.println("0-> Exit.");
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
