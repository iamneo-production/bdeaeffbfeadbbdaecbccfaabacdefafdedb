package services;

public class Booking{
//	Enter code here...
    public double booking(int noOfPersons, int rates){
        double totalRate;
        totalRate = noOfPersons * rates;
        return totalRate;
    }
}

