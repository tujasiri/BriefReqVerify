package com.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

public class BriefVerify {
/*
	//@Test
	public static void main(String[] args) throws Throwable {
		/*
		BriefVerify bv = new BriefVerify();
		bv.testEvaluationProcess();
		
	}
*/
	public static void sayHello() throws Throwable{
		System.out.println("Hello...");
	}
	
	public static int downloadBrief() throws Throwable{
		
		System.out.println("Reached download...");
		
		String uri = "http://localhost/docs/1993435.pdf";
		URL url = new URL(uri);
		//File destination = new File("/tmp/testbrief.pdf");
		File destination = new File("testbrief.pdf");
		
		try{
			
			FileUtils.copyURLToFile(url, destination);
			System.out.println("Downloading...");
		}
		catch(Exception e){
			
			System.err.println(e.toString() +"caught while running downloadBrief().");
			return(1);
			
		}
			return(0);
		
	}//end downloadBrief
	
} 