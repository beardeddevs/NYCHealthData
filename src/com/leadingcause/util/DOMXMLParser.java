package com.leadingcause.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.leadingcause.dao.LeadingCauseDAO;
import com.leadingcause.entities.LeadingCause;
import com.leadingcause.enums.Sex;

public class DOMXMLParser {
	
	LeadingCauseDAO leadingCauseDAO = new LeadingCauseDAO();
	Set<LeadingCause> leadingCauses = new HashSet<LeadingCause>();


  public Set<LeadingCause> buildDOMTree(){
	  try {
		  
//		  	String path = getClass().getClassLoader().getResource("/").getPath().replace("%20", " ");
//			File fXmlFile = new File(path+"data.xml");
		  	File fXmlFile = new File("C:\\Java_Workspaces\\RBC\\NYCLeadingCauses\\data\\data.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
			NodeList nList = doc.getElementsByTagName("row");
					
		

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
						
			
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String year = eElement.getElementsByTagName("year").item(0).getTextContent();
					String ethnicity = eElement.getElementsByTagName("ethnicity").item(0).getTextContent();
					String sex = eElement.getElementsByTagName("sex").item(0).getTextContent();
					String causeOfDeath = eElement.getElementsByTagName("cause_of_death").item(0).getTextContent();
					String count = eElement.getElementsByTagName("count").item(0).getTextContent();
					String percentage = eElement.getElementsByTagName("percent").item(0).getTextContent();
					
					LeadingCause leadingCause = new LeadingCause(Integer.parseInt(year), ethnicity,Sex.valueOf(sex), causeOfDeath, 
							Integer.parseInt(count), Double.parseDouble(percentage));
					leadingCauses.add(leadingCause);
					
				

				}
			}
	
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		return leadingCauses;
  }

}