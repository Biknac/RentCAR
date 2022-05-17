package order_list;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import order_list.Structure;
import order_list.DB;

@WebServlet("/order_list")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	private String htmlText = "<!DOCTYPE html>\r\n"
			+ "<html lang=\"en\">\r\n"
			+ "<head>\r\n"
			+ "<meta charset=\"utf-8\">\r\n"	
			+ "<form>"
			+ "<br>------------------------------------<br>"
	        +  "Заверщшення заявок (за ID):"
	        + "<br><br>   "
	        + " <input type = \"number\" id=\"order_id\" name=\"order_idn\" />"
	        + " <br><br>  "
		    +"<input type=\"submit\" value=\"Завершити\" onclick=\"DeleteOrder()\">"
		    + "<br>------------------------------------<br>"
		    + "</form>"
		    + "<script src=\"./operator.js\"></script>" 
			+ "</body>\r\n"
			+ "</html>";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		if(request.getParameter("StatusIDC") == null)
		{
			PrintWriter writer = response.getWriter();
			List<Structure> oper = DB.select();
			String json = new Gson().toJson(oper);
	    	writer.println(json);
	    	response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(htmlText);
			System.out.println("bbbbbb");
		}
		else{
			PrintWriter writer = response.getWriter();
			List<Structure> oper = DB.selectStatus(Integer.parseInt(request.getParameter("StatusIDC")));
			String json = new Gson().toJson(oper);
	    	writer.println(json);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String Email = request.getParameter("email");
    	String Name = request.getParameter("name");
    	int IdCar = Integer.parseInt(request.getParameter("car"));
    	Structure new_user = new Structure(Email,Name,IdCar);
        DB.insert(new_user); 
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		
		String body = inputStreamToString(request.getInputStream());
		Map<?, ?> params = parseBody(body);
		
		int IdUser = Integer.parseInt(params.get("id").toString());
        DB.delete(IdUser); 
        System.out.println("aaaaaa");
	}
	

	protected static String inputStreamToString(InputStream inputStream) {
		try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
			return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
		}
	}

	
	protected static Map<String, String> parseBody(String body) {

		Map<String, String> map = new HashMap<String, String>();

		body = body.replaceAll("\\\"", "");
		body = body.replaceAll("\\{", "");
		body = body.replaceAll("\\}", "");

		String[] lines = body.split(",");
		for (String s : lines) {
			String[] item = s.split(":");
			map.put(item[0], item[1]);
		}

		return map;
	}

	
}