package order_list;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import order_list.Structure;

public class DB { 
	
	
	public static List<Structure> select(){
		List<Structure> users = new ArrayList<Structure>();
		try(Connection con = new mysql.ConnectionDB().getConnection()) { 	
			   Statement statement = con.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM order_list");
               while(resultSet.next()) { users.add(setValues(resultSet)); }
		}
        catch(Exception ex) { System.out.println(ex); }
		return users;
	}

	public static List<Structure> selectStatus(int idStatus) {
    	List<Structure> users = new ArrayList<Structure>();
		try(Connection con = new mysql.ConnectionDB().getConnection()) { 	
			   String sql = "SELECT * FROM order_list where id_ApplicationStatuses=?";
			   PreparedStatement s = con.prepareStatement(sql);
			   s.setInt(1, idStatus);
			   ResultSet rs = s.executeQuery();
               while(rs.next()) { users.add(setValues(rs)); }
		}
        catch(Exception ex) { System.out.println(ex); }
		return users;
    }
	
	public static Structure selectOne(String User) {
		Structure users = null;
        try(Connection con = new mysql.ConnectionDB().getConnection()){	
        		String sql = "SELECT * FROM order_list WHERE User=?";
        		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
                    preparedStatement.setString(1, User);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()) { users = setValues(resultSet); }
        		}
        }
        catch(Exception ex) { System.out.println(ex); }
        return users;
    }

	public static Structure setValues(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt(1);
        String Email = resultSet.getString(2);
        String Name = resultSet.getString(3);
        int IdCar = resultSet.getInt(4);
        Structure user = new Structure(id, Email, Name, IdCar);
        return user;
	}
	
	 public static int insert(Structure user)
	    {
	 	   try(Connection con = new mysql.ConnectionDB().getConnection())
	 	   {
	 		   String sqlInsert = "INSERT INTO order_list (email, name, id_car) Values (?, ?, ?)";
	 		   try(PreparedStatement preparedStatement = con.prepareStatement(sqlInsert)){
	                preparedStatement.setString(1, user.getEmail());
	                preparedStatement.setString(2, user.getName());
	                preparedStatement.setInt(3, user.getIdCar());
	                return preparedStatement.executeUpdate();
	           }
	 	   }
	        catch(Exception ex) { System.out.println(ex); }
	        return 0;
	    }
	 
	  public static int delete(int id)
	    {
	 	   try(Connection con = new mysql.ConnectionDB().getConnection())
	 	   {
	 		   String sqlDelete = "DELETE FROM order_list WHERE id = ?";
	 		   try(PreparedStatement preparedStatement = con.prepareStatement(sqlDelete)){
	 			   preparedStatement.setInt(1, id);
	                return  preparedStatement.executeUpdate();
	           }
	 	   }
	        catch(Exception ex) { System.out.println(ex); }
	        return 0;
	    }
	
	  
}
