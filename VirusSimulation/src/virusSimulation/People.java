package virusSimulation;

import java.util.*;

public class People {
	String name;
	double resistence;
	List<People> socialNetwork;
	boolean isHealthy;
	boolean isTreated;
	
	public People(String name) {
		this.name = name;
		isHealthy = true;
		isTreated = false;
		socialNetwork = new ArrayList<>();
	}
	
	public void gotInfected() {
		//do nothing there, healthy people cann't infect other people
		isHealthy = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getResistence() {
		return this.resistence;
	}
	
	public List<People> getSocialNetwork(){
		return this.socialNetwork;
	}
	
	
	public void setResistence(double value) {
		this.resistence = value;
	}
	
	public void setNetwork(List<People> network) {
		this.socialNetwork = network;
	}
	public void addPeople(People p) {
		socialNetwork.add(p);
	}
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof People)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        People c = (People) o; 
          
        // Compare the data members and return accordingly  
        return name.equals(c.name); 
    } 
//	@Override
//	public boolean eqauls(Object o) {
//		People current = (People) o;
//		return this.name.equals(current.name);
//	}
}
