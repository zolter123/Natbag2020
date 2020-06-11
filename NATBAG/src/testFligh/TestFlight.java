package testFligh;

import static org.junit.Assert.*;

import org.junit.Test;
import flight.Airport_Prog;
import flight.Flights;
public class TestFlight {

	@Test
	public void test() {
		
		Flights fly1= new Flights(5, "FGH", "NY", "2000-09-09");
		Flights fly = flightData();
		StringBuffer expectedResult = new StringBuffer();
		//expectedResult.append();
		assertEquals(fly1.getNumFlight(),  5 );
		
	}
	
	private Flights flightData() {
		Flights fl = new Flights(100, "FGH", "NY", "2000-09-09");
		
		return fl;
	}
}
