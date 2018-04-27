package dataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import interfaces.Queue;
import queues.Costumer;

import queues.SLLQueue;

public class dataReader {

	public Queue readData() throws FileNotFoundException{
		
			
			  SLLQueue inputQueue=new SLLQueue<>();
			  SLLQueue processingQueue=new SLLQueue<>();
		
		Scanner reader = new Scanner(new File ("input.csv"));
		int i=1;
		while(reader.hasNext()) {
		
			String myString = reader.nextLine();
			String[] stringArray=myString.split(" ");
			inputQueue.enqueue(new Costumer (i, (int)Integer.parseInt(stringArray[0]),(int) Integer.parseInt(stringArray[1])));
			i++;
		
		}
		reader.close();
		return inputQueue;
	
	}
}