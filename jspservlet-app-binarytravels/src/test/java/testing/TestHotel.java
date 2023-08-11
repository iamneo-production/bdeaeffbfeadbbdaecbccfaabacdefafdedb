package testing;


import model.Hotel;
import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestHotel {
	LocalDate ld1 = LocalDate.of(2020, 02, 03);
	LocalDate ld2 = LocalDate.of(2020, 02, 07);
	Hotel hotel = new Hotel(2, "nonac", 20000, "single", ld1, ld2);

	@Test
	public void testGetNoOfPersonMethod() {
		hotel.setNoOfPersons(5);
		assertEquals(5, hotel.getNoOfPersons());
		hotel.setNoOfPersons(1);
		assertEquals(1, hotel.getNoOfPersons());
		try {
			hotel.setNoOfPersons(0);
			hotel.setNoOfPersons(-5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRateMethod() {
		hotel.setRates(12000);
		assertEquals(12000, hotel.getRates());
		hotel.setRates(8000);
		assertEquals(8000, hotel.getRates());
		try {
			hotel.setRates(0);
			hotel.setRates(-500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRoomType() {
		hotel.setRoomType("ac");
		assertEquals("ac", hotel.getRoomType());
		try {
			hotel.setRoomType(null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSetDate() {
		try {
			hotel.setFromdate(null);
			hotel.setTodate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

