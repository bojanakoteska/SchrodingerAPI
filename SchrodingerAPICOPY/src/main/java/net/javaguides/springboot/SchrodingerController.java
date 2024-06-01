// SPDX-License-Identifier: MIT
package net.javaguides.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SchrodingerController {

    String  line = "";
    
    
    //  1D Morse with Hermite basis- npts must be equal to num_eigs if we use Hermite basis
    // prec is for precision
    
    //http://localhost:8080/1dHermiteMorse?npts=10&D=3.0&a=0.5&x0=0.0&prec=6
    
    @RequestMapping("/1dHermiteMorse")
    public String HermiteMorse1D(@RequestParam(value = "npts", defaultValue = "5") Integer npts, @RequestParam(value = "D", defaultValue = "3") Double D, @RequestParam(value = "a", defaultValue = "0.5") Double a, @RequestParam(value = "x0", defaultValue = "0") Double x0, @RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/1d_Hermite_Morse.py";
		String[] cmd = new String[7];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=D.toString();
		cmd[4]=a.toString();
		cmd[5]=x0.toString();
		cmd[6]=prec.toString();
		 
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			pr = rt.exec(cmd);
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return res;
    
    }
    
    
    // http://localhost:8080/1dHermiteSho?npts=10&k=1.0&x0=0.0&prec=19
    @RequestMapping("/1dHermiteSho")
    public String HermiteSho1D(@RequestParam(value = "npts", defaultValue = "5") Integer npts, @RequestParam(value = "k", defaultValue = "1.0") Double k, @RequestParam(value = "x0", defaultValue = "0.0") Double x0, @RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/1d_Hermite_Sho.py";
		String[] cmd = new String[6];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=k.toString();
		cmd[4]=x0.toString();
		cmd[5]=prec.toString();
		 
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			pr = rt.exec(cmd);
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return res;
    
    }
    
    // http://localhost:8080/1dHermiteSombrero?npts=10&a=-5.0&b=1.0&prec=3
    // b must be positive number
    @RequestMapping("/1dHermiteSombrero")
    public String HermiteSombrero1D(@RequestParam(value = "npts", defaultValue = "5") Integer npts, @RequestParam(value = "a", defaultValue = "-5.0") Double a, @RequestParam(value = "b", defaultValue = "1.0") Double b, @RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/1d_Hermite_Sombrero.py";
		String[] cmd = new String[6];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=a.toString();
		cmd[4]=b.toString();
		cmd[5]=prec.toString();
		 
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			pr = rt.exec(cmd);
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return res;
    
    }
    
    
   // http://localhost:8080/1dHermiteWoodSax?npts=10&V0=50.0&z=0.5&r0=1.2&A=16&prec=4
    @RequestMapping("/1dHermiteWoodSax")
    public String HermiteWoodSax1D(@RequestParam(value = "npts", defaultValue = "5") Integer npts, @RequestParam(value = "V0", defaultValue = "50.0") Double V0, @RequestParam(value = "z", defaultValue = "0.5") Double z, @RequestParam(value = "r0", defaultValue = "1.2") Double r0, @RequestParam(value = "A", defaultValue = "16") Integer A, @RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/1d_Hermite_WoodSax.py";
		String[] cmd = new String[8];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=V0.toString();
		cmd[4]=z.toString();
		cmd[5]=r0.toString();
		cmd[6]=A.toString();
		cmd[7]=prec.toString();
		 
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			pr = rt.exec(cmd);
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	
	return res;
    
    }
    
    // http://localhost:8080/2dHermiteSho?npts=10&k=1.0&x0=0.0&y0=0.0&prec=100
    @RequestMapping("/2dHermiteSho")
    public String HermiteSho2D(@RequestParam(value = "npts", defaultValue = "5") Integer npts, @RequestParam(value = "k", defaultValue = "1.0") Double k, @RequestParam(value = "x0", defaultValue = "0.0") Double x0, @RequestParam(value = "y0", defaultValue = "0.0") Double y0, @RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/2d_Hermite_Sho.py";
		String[] cmd = new String[7];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=k.toString();
		cmd[4]=x0.toString();
		cmd[5]=y0.toString();
		cmd[6]=prec.toString();
		
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			
			pr = rt.exec(cmd);
			
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		//System.out.println(bfr.readLine());
		
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	
	return res;
    
    }
    
    // http://localhost:8080/3dHermiteSho?npts=10&k=1.0&x0=0.0&y0=0.0&z0=0.0&prec=100
    @RequestMapping("/3dHermiteSho")
    public String HermiteSho3D(@RequestParam(value = "npts", defaultValue = "5") Integer npts, @RequestParam(value = "k", defaultValue = "1.0") Double k, @RequestParam(value = "x0", defaultValue = "0.0") Double x0, @RequestParam(value = "y0", defaultValue = "0.0") Double y0, @RequestParam(value = "z0", defaultValue = "0.0") Double z0, @RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/3d_Hermite_Sho.py";
		String[] cmd = new String[8];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=k.toString();
		cmd[4]=x0.toString();
		cmd[5]=y0.toString();
		cmd[6]=z0.toString();
		cmd[7]=prec.toString();
		
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			
			pr = rt.exec(cmd);
			
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		//System.out.println(bfr.readLine());
		
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
	
	return res;
    
    }
    
    // http://localhost:8080/2dHermiteMorse?npts=10&D1=3.0&a1=0.5&D2=3&a2=0.5&x0=0.0&y0=0.0&prec=100
    @RequestMapping("/2dHermiteMorse")
    public String HermiteMorse2D(@RequestParam(value = "npts", defaultValue = "5") Integer npts,
    		@RequestParam(value = "D1", defaultValue = "3") Double D1, 
    		@RequestParam(value = "a1", defaultValue = "0.5") Double a1, 
    		@RequestParam(value = "D2", defaultValue = "3") Double D2, 
    		@RequestParam(value = "a2", defaultValue = "0.5") Double a2, 
    		@RequestParam(value = "x0", defaultValue = "0") Double x0, 
    		@RequestParam(value = "y0", defaultValue = "0") Double y0,
    		@RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/2d_Hermite_Morse.py";
		String[] cmd = new String[10];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=D1.toString();
		cmd[4]=a1.toString();
		cmd[5]=D2.toString();
		cmd[6]=a2.toString();
		cmd[7]=x0.toString();
		cmd[8]=y0.toString();
		cmd[9]=prec.toString();
		 
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			pr = rt.exec(cmd);
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return res;
    
    }
    
 // http://localhost:8080/3dHermiteMorse?npts=10&D1=3.0&a1=0.5&D2=3&a2=0.5&D3=3.0&a3=0.5&x0=0.0&y0=0.0&z0=0&prec=100
    @RequestMapping("/3dHermiteMorse")
    public String HermiteMorse3D(@RequestParam(value = "npts", defaultValue = "5") Integer npts,
    		@RequestParam(value = "D1", defaultValue = "3") Double D1, 
    		@RequestParam(value = "a1", defaultValue = "0.5") Double a1, 
    		@RequestParam(value = "D2", defaultValue = "3") Double D2, 
    		@RequestParam(value = "a2", defaultValue = "0.5") Double a2,
    		@RequestParam(value = "D3", defaultValue = "3") Double D3, 
    		@RequestParam(value = "a3", defaultValue = "0.5") Double a3,
    		@RequestParam(value = "x0", defaultValue = "0") Double x0, 
    		@RequestParam(value = "y0", defaultValue = "0") Double y0,
    		@RequestParam(value = "z0", defaultValue = "0") Double z0,
    		@RequestParam(value = "prec", defaultValue = "8") Integer prec)
    {
    	String pythonScriptPath = "src/main/resources/dvr_py-master/3d_Hermite_Morse.py";
		String[] cmd = new String[13];
		cmd[0] = "python"; // check version of installed python: python -V
		cmd[1] = pythonScriptPath;
		cmd[2]=npts.toString();
		cmd[3]=D1.toString();
		cmd[4]=a1.toString();
		cmd[5]=D2.toString();
		cmd[6]=a2.toString();
		cmd[7]=D3.toString();
		cmd[8]=a3.toString();
		cmd[9]=x0.toString();
		cmd[10]=y0.toString();
		cmd[11]=z0.toString();
		cmd[12]=prec.toString();
		 
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr;
		String res="";
		try {
			pr = rt.exec(cmd);
			// TODO Auto-generated catch block
			
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		
			while((line = bfr.readLine()) != null) {
			// display each output line form python script
			System.out.println(line);
			res+=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return res;
    
    }
    
    
}
