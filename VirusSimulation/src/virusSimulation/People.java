package virusSimulation;

import java.util.*;

public class People implements Node{
	String name;
	double resistence;
	List<People> socialNetwork;
	boolean isHealthy;
	boolean isTreated;
	
	/**
	 *  This is the constructor
	 * @param name: the name of people
	 */
	public People(String name) {
		this.name = name;
		isHealthy = true;
		isTreated = false;
		socialNetwork = new ArrayList<>(); 
	}
	
	
	/**
	 * This function aims to make the people unhealthy 
	 */
	public void gotInfected() {
		//do nothing there, healthy people cann't infect other people
		isHealthy = false;
	}
	
	/**
	 * This is the getter of name and override the method in Node interface
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This is the getter of resistence 
	 * @return the value of resistence
	 */
	public double getResistence() {
		return this.resistence;
	}
	
	/**
	 * This is the getter of socialNetwork
	 * @return the list of socialNetwork
	 */
	public List<People> getSocialNetwork(){
		return this.socialNetwork;
	}
	
	/**
	 * This is the setter of resistence
	 * @param value: the value of resistence
	 */
	public void setResistence(double value) {
		this.resistence = value;
	}
	
	/**
	 * This is the setter of socialNetwork
	 * @param  network: the list of socialNetwork
	 */
	public void setNetwork(List<People> network) {
		this.socialNetwork = network;
	}
	
	/**
	 * This function aims add a people into a this person's socialNerwork
	 * @param  p: people to add
	 */
	public void addPeople(People p) {
		socialNetwork.add(p);
	}
	
	/**
	 * This function override equals method in the Node interface 
	 */
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