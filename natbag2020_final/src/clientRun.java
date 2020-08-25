import flight.Airport;


public class clientRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Airport port = new Airport();
		port.addDeparture("ElAl", 1904, 3, "12/06/2020 14:00", "13/06/2020 08:00", "Rome");
		port.addLanding("KLM", 7856, 3, "21/05/2020 18:50", "22/05/2020 00:20", "London");
		port.addDeparture("LondonAir", 15, 4, "10/06/2020 18:00", "10/06/2020 20:00", "York");
		port.addLanding("ElAl", 1893, 6, "02/08/2020 14:05", "03/08/2020 19:43", "Berlin");
		
		
		boolean isHtml = args.length>0 &&args[0].equalsIgnoreCase("html");
		boolean isDepartures = args.length>1 && args[1].equalsIgnoreCase("departures");
		String airline;
		if(args.length>2) 
			 airline = args[2];
		String country;
		if(args.length>3)
			country= args[3];
		
		String prepOutput="";
		if(isDepartures){
			for(int i=0; i<port.getDeparture().size();i++){
				prepOutput = prepOutput+ port.getDeparture().get(i).toString()+"\n";
				if(isHtml) prepOutput= prepOutput+ "<br>"; 
				
			}
			
		} else{
			for(int i =0; i<port.getlanding().size();i++){
				prepOutput= prepOutput + port.getlanding().get(i).toString()+ "\n";
				if(isHtml) prepOutput= prepOutput+ "<br>";
				
			}
		}
		System.out.println(prepOutput);
		

	}

}
