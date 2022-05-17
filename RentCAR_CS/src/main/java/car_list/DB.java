package car_list;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import car_list.Structure;

public class DB { 
	
	
	public static List<Structure> select(){
		List<Structure> cars = new ArrayList<Structure>();
		try(Connection con = new mysql.ConnectionDB().getConnection()) { 	
			   Statement statement = con.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM car_list");
               while(resultSet.next()){ cars.add(setValues(resultSet)); }
		 }
        catch(Exception ex) { System.out.println(ex); }
		return cars;
		}

	public static Structure selectOne(String Cars) {
		Structure cars = null;
        try(Connection con = new mysql.ConnectionDB().getConnection()){	
        		String sql = "SELECT * FROM car_list WHERE Cars=?";
        		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
                    preparedStatement.setString(1, Cars);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()) { cars = setValues(resultSet); }
        		}
        }
        catch(Exception ex) { System.out.println(ex); }
        return cars;
    }

	public static Structure setValues(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt(1);
        String Type = resultSet.getString(2);
        int Total = resultSet.getInt(3);
        Structure car = new Structure(id, Type, Total);
        return car;
	}
}