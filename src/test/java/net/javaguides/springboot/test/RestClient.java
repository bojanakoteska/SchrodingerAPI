// SPDX-License-Identifier: MIT
package net.javaguides.springboot.test;

import org.springframework.web.client.RestTemplate;
import java.io.*;
public class RestClient {
	
	public static final String SERVER_URI = "http://localhost:8080/2dHermiteSho";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		try {
		//RestTemplate restTemplate = new RestTemplate();
		//System.out.println(restTemplate.getForObject(SERVER_URI, String.class));
			
			String pythonScriptPath = "src/main/resources/dvr_py-master/2d_Hermite_Sho.py";
			String[] cmd = new String[7];
			cmd[0] = "python"; // check version of installed python: python -V
			cmd[1] = pythonScriptPath;
			cmd[2]="10";
			cmd[3]="1.0";
			cmd[4]="0.0";
			cmd[5]="0.0";
			cmd[6]="100";
			
			// create runtime to execute external command
			Runtime rt = Runtime.getRuntime();
			Process pr;
			String res="";
			pr = rt.exec(cmd);
			// pr.waitFor(); 
			//System.out.println("Vlegov0");
			
			BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			//System.out.println(bfr.readLine());
			
			 BufferedReader stdError = new BufferedReader(new

		             InputStreamReader(pr.getErrorStream()));
			 String line = "";
			 while ((line = stdError.readLine()) != null) {

		            System.out.println(line);

		        }

			
			
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
