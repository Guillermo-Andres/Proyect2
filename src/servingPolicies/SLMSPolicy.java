package servingPolicies;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataGenerator.dataReader;
import interfaces.Queue;
import queues.Costumer;
import queues.Server;

public class SLMSPolicy {

	private Queue<Costumer> inputQueue;
	private Queue<Costumer>[] inputQueues;
	private ArrayList<Costumer> processing, completedServices;
	private int time;
	//private dataReader dr;

	public SLMSPolicy(dataReader dr) {
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
		Server[] servers = new Server [serversQuantity];
		
		Costumer currentCustomer;
		Server currentServer = servers[0];

		for(int p = 0; p < inputQueues.length; p++) {
			inputQueue = inputQueues[p];

			while (!inputQueue.isEmpty() || !processing.isEmpty()) {
				
				if (!processing.isEmpty()) {
					currentServer.process();
					System.out.println("Processing!");
					if (currentServer.getCurrent().getRemainingTime() == 0) {
						currentServer.getCurrent().setDepartureTime(time);
						completedServices.add(currentServer.getCurrent());
						processing.remove(currentServer.getCurrent());
						currentServer.setAvailability(true);
					}
				}
				
				if (!inputQueue.isEmpty() && inputQueue.first().getArrivalTime() == time) {
					currentCustomer = inputQueue.dequeue();
					for (int i = 0; i < servers.length; i++) {
						servers[i] = new Server();
						if (servers[i].getAvailability()) {
							currentServer = servers[i];
							currentServer.setCurrent(currentCustomer);
							currentServer.setAvailability(false);
							processing.add(currentServer.getCurrent());
						}
						if (currentServer.getCurrent().getRemainingTime() == 0) {
							currentServer.getCurrent().setDepartureTime(time);
							completedServices.add(currentServer.getCurrent());
							processing.remove(currentServer.getCurrent());
							currentServer.setAvailability(true);
						}
					}	
				}		
				
				time++;

			}
		}
	}



}
