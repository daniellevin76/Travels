package controlls;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import models.AgentBean;
import models.ApiBean;

/**
 * Servlet implementation class Traffic
 */
@WebServlet(name = "Traffic", urlPatterns = "/traffic")
public class Traffic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traffic() {
        super();
        // TODO Auto-generated constructor stub
        
       
    }
    
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		
		
		
		
		// instantiate AgentBean
		
				AgentBean agent = new AgentBean();
				
				//instantiate ApiBean
				
				
				ApiBean apiBean = new ApiBean();
				
				// Malmö Södervärn 80120, Malmö C 80000, Malmö Triangeln 80140, Malmö Hyllie 80040, Malmö Värnhem 80110
				
				// Check if the right info got sent
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						
						// Id for bus stop
						//String selPoint = "80000";
						
						String selPoint = request.getParameter("station");
						
						

						
					String URLtoSend = "http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey=" + selPoint;
							
					
					
					

					
					
					//String URLtoSend = "http://www.labs.skanetrafiken.se/v2.2/stationresults.asp?selPointFrKey="+selPoint;
							
					//String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + cityStr + "," + countryStr
					//		+ "&APPID=099eff339f56d6a29a9823857b2f2671&mode=xml";

					//System.out.println(URLtoSend);

					// Set the URL that will be sent
					URL line_api_url = new URL(URLtoSend);

					// Create a HTTP connection to sent the GET request over
					HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
					linec.setDoInput(true);
					linec.setDoOutput(true);
					linec.setRequestMethod("GET");

					// Make a Buffer to read the response from the API
					BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));


					// a String to save the full response to use later
					
					String ApiResponse;	
					ApiResponse = apiBean.createApiResponse(in);
					
					ApiResponse = ApiBean.replaceCharsSwedish(ApiResponse);
					
			
				
				System.out.println(ApiResponse);
					
					// Method the makes a XML doc out of a string, if it is in a XML format. 
					
					Document doc = ApiBean.convertStringToXMLDocument(ApiResponse);
					String tagName1 = "Name";
					String tagName2 = "JourneyDateTime";
					String tagName3 = "Towards";
					
					// Current date and time
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime now = LocalDateTime.now();  
					   
					 //  System.out.print(now);
					
					
					// create a list with the content of "Name" nodes
					ArrayList<String> nameList = apiBean.createListOfNodesContent(doc, tagName1);
					ArrayList<String> towardsList = apiBean.createListOfNodesContent(doc, tagName3);
					ArrayList<String> dateTimeList = apiBean.createListOfNodesContent(doc, tagName2);
					
					
					//Just for testing
					System.out.println("nameList " + nameList.size() );
					System.out.println("towardsList " + towardsList.size() );
					
					ArrayList<String> bussAndTowardsList = new ArrayList<String>();
					
					for (int i = 0; i <nameList.size()-1; i++) {
						
						bussAndTowardsList.add((nameList.get(i).concat(" towards ")).concat(towardsList.get(i)));
					}
					ArrayList<Integer> hoursArray = new ArrayList<Integer>();
					ArrayList<Integer> minutesArray = new ArrayList<Integer>();
					ArrayList<Integer> secondsArray = new ArrayList<Integer>();
			
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					
					
					
					
					Calendar calendar = Calendar.getInstance();
					try {
						for (int i = 0; i< dateTimeList.size(); i++) {
							calendar.setTime(sdf.parse(dateTimeList.get(i)));
							
							int hour = calendar.get(Calendar.HOUR_OF_DAY); //returns the hour
							int minute = calendar.get(Calendar.MINUTE); //returns the minute
							int second = calendar.get(Calendar.SECOND); //returns the second
							
							int totalMinutes = hour*60 + minute; // convert hours to minutes
							
							
							// get the time difference between busses time table and current time
							int timeDiff = totalMinutes-(now.getHour()*60 + now.getMinute()) ;
							
						
							//System.out.print(hour);
							
						//	intHours.add(i, hour);
							minutesArray.add(i, timeDiff);
							//intSeconds.add(i, second);
							
							
						}
						
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//get current time and convert to total minutes
					
				//	System.out.println(minutesArray.size());
				//	System.out.println(nameList);
						
				
					// send list to Bob page
					request.setAttribute("list1", bussAndTowardsList);
					request.setAttribute("list2", dateTimeList);
					//request.setAttribute("list3", towardsList);
					RequestDispatcher rd = request.getRequestDispatcher("bob.jsp");
					rd.forward(request, response);
					
					
					


		
					

					
					
					
	}

}