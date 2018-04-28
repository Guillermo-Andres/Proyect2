package queues;

import java.util.ArrayList;

public class Server {

	private Costumer current;
	private boolean availability;
	
	public Server(Costumer current) {
		this.current=current;
		this.availability = true;
		
	}
	
	public Server() {
		current = null;
		availability = true;
	}
	
	public Costumer getCurrent() {
		return current;
	}
	
	public void process() {
		current.setRemainingTime(current.getRemainingTime()-1);
	}
	
	public void reset() {
		Costumer tool = new Costumer(0, -1, -1);
		this.setCurrent(tool);
	}
	
	public void setCurrent(Costumer current) {
		this.current = current;
	}
	
	public void setAvailability(boolean status) {
		this.availability = status;
	}
	
	public boolean getAvailability() {
		return this.availability;
	}

	public boolean isAvailable() {
		return current.getRemainingTime() == 0;
	}
	
	public int hasAvailability(ArrayList<Server> currents) {
		for(int i = 0; i<currents.size(); i++) 
			if(currents.get(i).isAvailable()) 
					return i;	
		return -1;
	}
		
	
	public void reset(ArrayList<Server> currents) {
		for(int i =0; i<=currents.size();i++)
		currents.get(i).reset();
	}
}
