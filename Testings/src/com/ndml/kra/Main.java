package com.ndml.kra;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		 File folder = new File("C:/Users/SudarshanR/Downloads/sftp");

		listFilesForFolder(folder);
				
	}

	public static void listFilesForFolder(File folder) throws SAXException, IOException, ParserConfigurationException {
		for (File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            System.out.println(fileEntry.getName());
        }
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  

			DocumentBuilder db = dbf.newDocumentBuilder();
	    	Document doc = db.parse(fileEntry);  

	    	NodeList nodeList = doc.getElementsByTagName("OfflinePaperlessKyc");  
	    	NodeList nodeList2 = doc.getElementsByTagName("KycRes");    
	    	
	    	
	    	
	    	
	    	if(nodeList.getLength()>0) {
	    		System.out.println("Aadhar");
	    	}
	    	else if(nodeList2.getLength()>0) {
	    		System.out.println("DigiLocker");
	    	}
	    	else {
	    		System.out.println("EKYC");
	    	}
	   
	    
	    	
	    

	
	}
	}
}