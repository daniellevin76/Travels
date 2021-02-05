package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ApiBean {

	public static Document convertStringToXMLDocument(String xmlString) {

		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> removeDuplicates(ArrayList<String> list) {

		return (ArrayList<String>) list.stream().distinct().collect(Collectors.toList());
	}

	public ArrayList<String> createListOfNodesContent(Document doc, String tagName) {

		// normalize the XML response
		doc.getDocumentElement().normalize();

		// Create a Node list that gets everything in and under the "clouds" tag

		NodeList nList = doc.getElementsByTagName(tagName);

		// Instantiate the list
		ArrayList<String> list = new ArrayList<String>();

		// loop through the content of the tag nList.getLength()
		for (int temp = 0; temp < nList.getLength(); temp++) {

			// Save a node of the current list id
			Node node = nList.item(temp);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;

				list.add(temp, eElement.getTextContent());

			}
		}
		return list;

	}

	public String createApiResponse(BufferedReader in) {
		String inLine;
		// a String to save the full response to use later
		String ApiResponse = "";

		// loop through the whole response
		try {
			while ((inLine = in.readLine()) != null) {

				// System.out.println(inputLine);
				// Save the temp line into the full response
				ApiResponse += inLine;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// in.close();

		return ApiResponse;

	}

	public static String replaceCharsSwedish(String ApiResponse) {

		ApiResponse = ApiResponse.replaceAll("Ã", "Ö");
		ApiResponse = ApiResponse.replaceAll("Ã¶", "ö");
		ApiResponse = ApiResponse.replaceAll("Ã¥", "å");

		ApiResponse = ApiResponse.replaceAll("Ã€", "ä");
		ApiResponse = ApiResponse.replaceAll("Ãž", "ø");
		return ApiResponse;

	}

}