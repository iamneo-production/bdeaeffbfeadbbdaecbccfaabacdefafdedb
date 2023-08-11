package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.Hotel;
import services.FareCalculator;




@WebServlet(urlPatterns={"/jspservlet-app-binarytravels/hotel"})
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public HotelServlet() {
        super();
     }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numberOfPersons=Integer.parseInt(request.getParameter("persons"));
		String roomtype=request.getParameter("roomtype");
		String occupancy=request.getParameter("occupancy");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		LocalDate fromDate=LocalDate.parse(from);
		LocalDate toDate=LocalDate.parse(to);
		
		int rates;
		if(roomtype.equals("AC")){
			rates=1500;
		}
		else
			rates=1000;
		System.out.println(numberOfPersons);
		System.out.println(roomtype);
		System.out.println(rates);
    
		Hotel hotel=new Hotel(numberOfPersons,roomtype,rates,occupancy,fromDate,toDate);
	
		hotel.setNoOfPersons(numberOfPersons);
		hotel.setRates(rates);
		hotel.setRoomType(roomtype);
		hotel.setFromdate(fromDate);
		hotel.setTodate(toDate);
	
		FareCalculator  fare=new FareCalculator();
		double rate=fare.book(hotel);
		System.out.println(rate);
		request.setAttribute("hoteltype", hotel.getRoomType());
		request.setAttribute("fromdate", hotel.getFromdate());
		request.setAttribute("todate", hotel.getTodate());
		request.setAttribute("person", hotel.getNoOfPersons());
		request.setAttribute("hotelfare", rate);
		RequestDispatcher dispatcher = request.getRequestDispatcher("hotel.jsp");
		dispatcher.forward(request, response);
	
	}
	
}
