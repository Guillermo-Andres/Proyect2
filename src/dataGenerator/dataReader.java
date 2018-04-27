package dataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dataReader {

	public void readData() throws FileNotFoundException{
		
			
			 //  inputQueue=new SLLQueue<>();
			  // processingQueue=new SLLQueue<>();
		
		Scanner reader = new Scanner(new File ("input.csv"));
		int i=1;
		while(reader.hasNext()) {
		
			String myString = reader.nextLine();
			String[] stringArray=myString.split(" ");
			//inputQueue.enqueue(new Job (i, (int)Integer.parseInt(stringArray[0]),(int) Integer.parseInt(stringArray[1])));
			i++;
		
		}
		reader.close();
	
	}
}