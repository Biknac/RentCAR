package car_list;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import car_list.Structure;
import car_list.DB;

@WebServlet("/car_list")
public class CarListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("application/json; charset=UTF-8");
		if(request.getParameter("Cars") == null)
		{
			PrintWriter writer = response.getWriter();
			List<Structure> foo = DB.select();
			String list = new Gson().toJson(foo );
	    	writer.println(list);
		}
		else 
		{
			PrintWriter writer = response.getWriter();
			Structure foo = DB.selectOne(request.getParameter("Cars"));
			String list = new Gson().toJson(foo );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
