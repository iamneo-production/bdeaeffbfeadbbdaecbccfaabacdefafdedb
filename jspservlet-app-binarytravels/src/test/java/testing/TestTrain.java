package testing;


import model.Train;
import java.time.LocalDate;
import static org.junit.Assert.*;  
import org.junit.Test;

public class TestTrain {
	LocalDate ld = LocalDate.of(2020, 02, 03);
	Train train = new Train(2,"nonac",1500,ld);
	
	@Test
	public void testGetNoOfPersonMethod() {
		train.setNoOfPersons(5);
		assertEquals(5,train.getNoOfPersons());
		train.setNoOfPersons(1);
		assertEquals(1,train.getNoOfPersons());
		try {
			train.setNoOfPersons(0);
			train.setNoOfPersons(-5);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetRateMethod() {
		train.setRates(12000);
		assertEquals(12000,train.getRates());
		train.setRates(8000);
		assertEquals(8000,train.getRates());
		try {
			train.setRates(0);
			train.setRates(-500);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetBerth() {
		train.setBerth("ac1");
		assertEquals("ac1",train.getBerth());
		try {
			train.setBerth(null);
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetDate() {
		try {
			train.setDate(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

