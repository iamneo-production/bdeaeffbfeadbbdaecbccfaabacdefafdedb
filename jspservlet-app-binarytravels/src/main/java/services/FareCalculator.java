package services;

import java.time.temporal.ChronoUnit;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

public class FareCalculator extends Booking{

    public double book(Flight flight) {

        double totalFare = booking(flight.getNoOfPersons(),flight.getRates());

        if(flight.getTriptype().equalsIgnoreCase("one-way")){
            return totalFare;
        }else{
            int comp = (flight.getFrom()).compareTo(flight.getTo());
            if(comp < 0)
                return 2 * totalFare;
            else
                return 0;
        }
    }

    public double book(Bus bus) {
        double totalFare = booking(bus.getNoOfPersons(),bus.getRates());
        return totalFare;
    }

    public double book(Hotel hotel) {
        double totalFare = 0;
        
        // Check if Check-In date is before Check-Out date
        if (hotel.getFromdate().isBefore(hotel.getTodate())) {
            int noOfPersons = hotel.getNoOfPersons();
            String occupancy = hotel.getOccupancy();
            int rates = hotel.getRates();
    
            // Calculate total fare based on occupancy
            if (occupancy.equalsIgnoreCase("single") && noOfPersons == 1) {
                totalFare = booking(noOfPersons, rates);
            } else if (occupancy.equalsIgnoreCase("double") && noOfPersons == 2) {
                totalFare = booking(noOfPersons, rates);
            } else if (occupancy.equalsIgnoreCase("mixed") && noOfPersons == 3) {
                // 1 Double Occupancy room and 1 Single Occupancy room
                totalFare = 2 * booking(1, rates) + booking(1, rates);
            } else {
                // Invalid occupancy or number of persons
                totalFare = 0; // Or set an appropriate default value
            }
        }
        
        return totalFare;
    }
    

    public double book(Train train) {
        double totalFare = booking(train.getNoOfPersons(),train.getRates());
        return totalFare;
    }

}