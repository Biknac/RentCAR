package order_list;

import java.io.Serializable;

public class Structure implements Serializable{
	 private static final long serialVersionUID = 1L;
	 
	 private int id;
	 private String Email;
	 private String Name;
	 private int IdCar;

	 public Structure(String Email, String Name, int IdCar)
	 {
		 this.Email = Email;
		 this.Name = Name;
	 }
	 
	 public Structure(int id, String Email, String Name, int IdCar)
	 {
		 this.id = id;
		 this.Email = Email;
		 this.Name = Name;
		 this.IdCar = IdCar;
	 }
	 
	 public int getId() {
	        return id;
	    }
	 
	 public String getEmail()
	 {
		 return Email;
	 }
	 public void setEmail(String Email)
	 {
		 this.Email = Email;
	 }
	 
	 public String getName()
	 {
		 return Name;
	 }
	 public void setName(String Name)
	 {
		 this.Name = Name;
	 }
	 
	 public int getIdCar()
	 {
		 return IdCar;
	 }
	 public void setIdCar(int IdCar)
	 {
		 this.IdCar = IdCar;
	 }
	 
}


