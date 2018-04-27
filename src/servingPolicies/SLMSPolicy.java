package servingPolicies;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import dataGenerator.dataReader;
import interfaces.Queue;
import queues.Costumer;
import queues.SLLQueue;

public class SLMSPolicy {

	private Queue<Costumer> inputQueue;
	private ArrayList<Costumer> completedServices;
	private int time;
	private dataReader dr;
	
	public SLMSPolicy() {
		try {
			inputQueue = dr.readData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		completedServices = new ArrayList<>();
		time = 0;
	}
	
	public void processing() {
		
	}
	
	
	
}
