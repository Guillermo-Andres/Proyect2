package testers;

import java.io.FileNotFoundException;

import dataGenerator.dataReader;
import servingPolicies.SLMSPolicy;

public class PolicyOneTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		dataReader dr = new dataReader();
		
		SLMSPolicy fp = new SLMSPolicy(dr);
		
		fp.processing(3);
		
	}
	
}
