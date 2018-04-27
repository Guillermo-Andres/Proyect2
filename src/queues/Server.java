package queues;

public class Server {

	private Costumer current;
	
	public Server(Costumer current) {
		this.current=current;
	}
	
	public void process() {
		current.setRemainingTime(current.getRemainingTime()-1);
	}
}
