package car_list;

import java.io.Serializable;

public class Structure implements Serializable{
	 private static final long serialVersionUID = 1L;
	 
	 private int id;
	 private String Type;
	 private int Total;
	 
	 public Structure(String Type, int Total)
	 {
		 this.Type = Type;
		 this.Total = Total;
	 }
	 
	 public Structure(int id, String Type, int Total)
	 {
		 this.id = id;
		 this.Type = Type;
		 this.Total = Total;
	 }
	 
	 public int getId() {
	        return id;
	    }
	 
	 public String getType()
	 {
		 return Type;
	 }
	 public void setType(String Type)
	 {
		 this.Type = Type;
	 }
	 
	 public int getTotal()
	 {
		 return Total;
	 }
	 public void setTotal(int Total)
	 {
		 this.Total = Total;
	 }
}

