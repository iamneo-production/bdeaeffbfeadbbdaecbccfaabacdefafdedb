package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Train;
import services.FareCalculator;


/**
 * Servlet implementation class TrainController
 */
@WebServlet("/jspservlet-app-binarytravels/train")
public class TrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public TrainServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numberOfPersons=Integer.parseInt(request.getParameter("persons"));
		String berth=request.getParameter("berth");
		String date=request.getParameter("to");
		System.out.println(numberOfPersons);
		System.out.println(berth);
		System.out.println(date);
		int rates;
		if(berth.equals("ac1")){
			rates=1500;
		}
		else if(berth.equals("ac2")){
			rates=1250;
		}
		else if(berth.equals("ac3")) {
			rates=1000;
		}
		else if(berth.equals("nonac")) {
			rates=750;
		}
		else{
			rates=500;
		}
		LocalDate start=LocalDate.parse(date);				
	
		Train train=new Train(numberOfPersons,berth,rates,start);
		train.setNoOfPersons(numberOfPersons);
		train.setRates(rates);
		train.setBerth(berth);;
		train.setDate(start);
		
		FareCalculator fare=new FareCalculator();
		
		double trainfare=fare.book(train);
		request.setAttribute("berth", train.getBerth());
		request.setAttribute("date", train.getDate());
		request.setAttribute("person", train.getNoOfPersons());
		request.setAttribute("trainfare", trainfare);
		RequestDispatcher dispatcher = request.getRequestDispatcher("train.jsp");
		dispatcher.forward(request, response);
	}

}
