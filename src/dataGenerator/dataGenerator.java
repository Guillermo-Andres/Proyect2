package dataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class dataGenerator {

	public static void main (String[] args) throws FileNotFoundException{
		String directory = "inputFiles"; // folder that contains the files
		Random r= new Random();
		int genF= r.nextInt(150);
		
		PrintWriter pFile=new PrintWriter(new File(directory, "datafiles.txt"));
		
		for(int i =1; i<genF;i++) {
			int data= r.nextInt(15);
			String name ="data_"+i+".txt";
			pFile.println(name);
			PrintWriter tool = new PrintWriter(new File(directory,name));
			int arrivalT=1+r.nextInt(10);
			for(int j=0;j<data;j++) {
				arrivalT+=r.nextInt(20);
				int startT=r.nextInt(15);
				tool.println(arrivalT+" " +startT);
			}
			tool.close();
		}
		pFile.close();
	}
}
