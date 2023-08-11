package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bus;
import services.FareCalculator;

@WebServlet(urlPatterns= {"/jspservlet-app-binarytravels/bus"})
public class BusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BusServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Entering do get");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		int numberOfPersons=Integer.parseInt(request.getParameter("persons"));
		String bustype=request.getParameter("bustype");
		String date=request.getParameter("start");
		System.out.println(numberOfPersons);
		System.out.println(bustype);
		System.out.println(date);
		int rates;
		if(bustype.equals("acseater")){
			rates=1250;
		}
		else if(bustype.equals("acsemisleeper")){
			rates=1500;
		}
		else if(bustype.equals("acsleeper")) {
			rates=1800;
		}
		else if(bustype.equals("nonacseater")) {
			rates=500;
		}
		else if(bustype.equals("nonacsemisleeper")) {
			rates=750;
		}
		else {
			rates=1000;
		}
		
		LocalDate start=LocalDate.parse(date);				
	
		Bus bus=new Bus(numberOfPersons,bustype,rates,start);
		bus.setNoOfPersons(numberOfPersons);
		bus.setRates(rates);
		bus.setBusType(bustype);
		bus.setDate(start);
		
		FareCalculator fare=new FareCalculator();
		
		double rate=fare.book(bus);
		System.out.println(rate);
		request.setAttribute("bustype", bus.getBusType());
		request.setAttribute("date", bus.getDate());
		request.setAttribute("person", bus.getNoOfPersons());
		request.setAttribute("busfare", rate);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bus.jsp");
		dispatcher.forward(request, response);
	}
	
}
