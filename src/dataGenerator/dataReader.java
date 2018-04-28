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
	Queue<Costumer>[] inputQueues;

	public dataReader() throws FileNotFoundException {
		parentDirectory = "inputFiles"; 

	}

	public Queue<Costumer>[] readData() throws FileNotFoundException{
		inputQueues = new SLLQueue [15];

		for (int i=1; i<3; i++) { 
			inputQueues[i-1] = new SLLQueue<Costumer>();
			String fileName = "data_" + i  + ".txt"; 
			Scanner inputFile = new Scanner(new File(parentDirectory, fileName)); 

			while (inputFile.hasNext()) {
				String data = inputFile.nextLine();
				String[] dataArr = data.split(" ");
				inputQueues[i-1].enqueue(new Costumer(1, Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1])));

			}


		}
		return inputQueues; 
	}
}
