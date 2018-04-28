package dataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.Queue;
import queues.Costumer;

import queues.SLLQueue;

public class dataReader {
	private String parentDirectory;
	Queue[] inputQueues;
	
	public dataReader() throws FileNotFoundException {
		parentDirectory = "inputFiles"; 
		
	}

	public Queue[] readData() throws FileNotFoundException{
		
		

				inputQueues = new SLLQueue [40];

				for (int i=0; i<40; i++) { 
					
						
						String fileName = "data_" + i  + ".txt"; 
						Scanner inputFile = new Scanner(new File(parentDirectory, fileName)); 
						ArrayList<Integer> fileContent = new ArrayList<>(); 
					while (inputFile.hasNext())
		                        inputQueues[i].enqueue(new Costumer(1, inputFile.nextInt(), inputFile.nextInt()));					
						inputFile.close();
						
				}	
				return inputQueues; 
			}
}
