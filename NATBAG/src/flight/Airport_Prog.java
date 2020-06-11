package flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Airport_Prog {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arrSize;
		int numFlight;
		String CompanyName;
		String Destination;
		String dateFlight;

		System.out.println("How many flight in total");
		arrSize = scan.nextInt();

		List<Flights> flightArr = new ArrayList<Flights>();
		
		for(int i=0; i < arrSize;i++) {
			System.out.println("Give me number of flight, Name of Company, The Destination, AND date. ");
			numFlight=scan.nextInt();
			CompanyName=scan.next();
			Destination=scan.next();
			dateFlight=scan.next();
			flightArr.add(new Flights(numFlight, CompanyName,Destination,dateFlight ));
		}
		
		Comparator <Flights> CompareByflightNum = new Comparator<Flights>() {
		
			@Override
			public int compare(Flights o1, Flights o2) {
				if(o1.getNumFlight()>o2.getNumFlight())
				return 1;
				if(o1.getNumFlight()<o2.getNumFlight())
					return -1;
				return 0;
			}
		};
		
		Comparator <Flights>  CompareByCompanyName = new Comparator<Flights>() {

			@Override
			public int compare(Flights o1, Flights o2) {
				return (o1.getCompanyName().compareTo(o2.getCompanyName()));
			}
		};
		
		System.out.println("Menu of sort. select 1 to sort by flight number, select 2 to sort by Company name.");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			Collections.sort(flightArr, CompareByflightNum);
			break;
			
		case 2:	
			Collections.sort(flightArr, CompareByCompanyName);
			break;
		default:
			break;
		}
		System.out.println(flightArr);
		
		scan.close();

	}

}
