package servingPolicies;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataGenerator.dataReader;
import interfaces.Queue;
import queues.Costumer;
import queues.Server;

public class SLMSPolicy {

	private Queue<Costumer> inputQueue;
	private ArrayList<Costumer> processing, completedServices;
	private int time;
	private dataReader dr;
	
	public SLMSPolicy() {
		try {
			inputQueue = dr.readData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		completedServices = new ArrayList<>();
		processing = new ArrayList<>();
		time = 0;
	}
	
	public void processing(int serversQuantity) {
		ArrayList<Server> servers = new ArrayList<>(serversQuantity);
		while (!inputQueue.isEmpty() || !processing.isEmpty()) {
			for (Server s : servers) {
				if (time == inputQueue.first().getArrivalTime() && s.isAvailable()) {
					Costumer cs = inputQueue.dequeue();
					s = new Server(cs);
					s.process();
					processing.add(cs);
				}
			}
			for (Server s : servers) {
				if (s.getCurrent().getRemainingTime() == 0) 
					s.reset();
			}
			for (Costumer c : processing) {
				if (c.getRemainingTime() == 0) {
					c.setDepartureTime(time);
					completedServices.add(c);
				}
			}
			time++;
			
		}
	}
	
	
	
}
