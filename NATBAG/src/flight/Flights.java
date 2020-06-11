package flight;
import java.text.DateFormat;
import java.util.Date;

public class Flights {
	private int numFlight;
	private String CompanyName;
	private String Destination;
	private String dateFlight;
	
	
	public Flights(int numFlight, String companyName, String destination, String dateFlight) {
		this.numFlight = numFlight;
		CompanyName = companyName;
		Destination = destination;
		this.dateFlight = dateFlight;
	}


	public int getNumFlight() {
		return numFlight;
	}


	public void setNumFlight(int numFlight) {
		this.numFlight = numFlight;
	}


	public String getDestination() {
		return Destination;
	}


	public void setDestination(String destination) {
		Destination = destination;
	}


	public String getDateFlight() {
		return dateFlight;
	}


	public void setDateFlight(String dateFlight) {
		this.dateFlight = dateFlight;
	}
	


	public String getCompanyName() {
		return CompanyName;
	}


	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}


	@Override
	public String toString() {
		return "Flights [numFlight=" + numFlight + ", CompanyName=" + CompanyName + ", Destination=" + Destination
				+ ", dateFlight=" + dateFlight + "]" + "\n";
	}
	
	
	
	
	
	
	
	
}
