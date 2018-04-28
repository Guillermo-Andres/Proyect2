package servingPolicies;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataGenerator.dataReader;
import interfaces.Queue;
import queues.Costumer;
import queues.Server;

public class SLMSPolicy {

	private Queue<Costumer> inputQueue;
	private Queue[] inputQueues;
	private ArrayList<Costumer> processing, completedServices;
	private int time;
	private dataReader dr;
	
	public SLMSPolicy() {
		try {
			inputQueues = dr.readData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		completedServices = new ArrayList<>();
		processing = new ArrayList<>();
		time = 0;
	}
	
	public void processing(int serversQuantity) {
		for(int p = 0; p<inputQueues.length; p++) {
			inputQueue=inputQueues[p];
		}
		ArrayList<Server> servers = new ArrayList<>(serversQuantity);
		while (!inputQueue.isEmpty() || !processing.isEmpty()) {
			for (Server s : servers) {
				if (time == inputQueue.first().getArrivalTime() && s.isAvailable()) {
					Costumer cs = inputQueue.dequeue();
					s = new Server(cs);
					s.process();
					processing.add(cs);
					if (s.getCurrent().getRemainingTime() == 0) 
						s.reset();
				}
			}
			for (int i = 0; i < processing.size(); i++) {
				if (processing.get(i).getRemainingTime() == 0) {
					processing.get(i).setDepartureTime(time);
					completedServices.add(processing.get(i));
					processing.remove(i);
				}
			}
			time++;
			
		}
	}
	
	
	
}
