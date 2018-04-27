package queues;

import java.util.ArrayList;

public class Server {

	private Costumer current;
	
	public Server(Costumer current) {
		this.current=current;
	}
	
	public Costumer getCurrent() {
		return current;
	}
	
	public void process() {
		current.setRemainingTime(current.getRemainingTime()-1);
	}
	
	public void reset() {
		current = null;
	}
	
	public boolean isAvailable() {
		return current == null;
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
