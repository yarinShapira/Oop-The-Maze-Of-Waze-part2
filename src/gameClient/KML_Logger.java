package gameClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import gameUtils.Fruit;
import gameUtils.robot;

public class KML_Logger {

	public static void openFile(String file_Name) {
		try {
			PrintWriter pw = new PrintWriter(new File(file_Name));
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			sb.append("<kml xmlns=\"http://earth.google.com/kml/2.2\">\n");
			sb.append("<Document>\n");
			sb.append("<name>Points with TimeStamps</name>");//TODO
			//fruit
			sb.append("<Style id=\"fruit\">\n"); 
			sb.append("<IconStyle>\n"); 
			sb.append("<Icon>\n");
			sb.append("<href>http://maps.google.com/mapfiles/kml/shapes/dollar.png</href>\n");
			sb.append("</Icon>\n");
			sb.append("<hotSpot x=\"32\" y=\"1\" xunits=\"pixels\" yunits=\"pixels\"/>\n"); 
			sb.append("</IconStyle>\n");
			sb.append("</Style>");
			//robot
			sb.append("<Style id=\"robot\">\n"); 
			sb.append("<IconStyle>\n"); 
			sb.append("<Icon>\n");
			sb.append("<href>http://maps.google.com/mapfiles/kml/shapes/man.png</href>\n");
			sb.append("</Icon>\n");
			sb.append("<hotSpot x=\"32\" y=\"1\" xunits=\"pixels\" yunits=\"pixels\"/>\n"); 
			sb.append("</IconStyle>\n");
			sb.append("</Style>");

			pw.write(sb.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void addFruit(String file_Name, String fruit) {
		Fruit temp = new Fruit(fruit);
		StringBuilder sb = new StringBuilder();
		sb.append("<Placemark>\n");
		sb.append("<TimeStamp>\n");
		sb.append("<when>" + java.time.LocalDateTime.now() + "</when>\n");
		sb.append("</TimeStamp>\n");
		sb.append("<styleUrl>#fruit</styleUrl>\n");
		sb.append("<Point>\n");
		sb.append("<coordinates>" + temp.location.toFile() + "</coordinates>\n");
		sb.append("</Point>\n");
		sb.append("</Placemark>\n");
		try {
			FileWriter fw = new FileWriter(file_Name, true);
			fw.append(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addRobot(String file_Name, String robot) {
		robot temp = new robot(robot);
		StringBuilder sb = new StringBuilder();
		sb.append("<Placemark>\n");
		sb.append("<TimeStamp>\n");
		sb.append("<when>" + java.time.LocalDateTime.now() + "</when>\n");
		sb.append("</TimeStamp>\n");
		sb.append("<styleUrl>#robot</styleUrl>\n");
		sb.append("<Point>\n");
		sb.append("<coordinates>" + temp.location.toFile() + "</coordinates>\n");
		sb.append("</Point>\n");
		sb.append("</Placemark>\n");
		try {
			FileWriter fw = new FileWriter(file_Name, true);
			fw.append(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void closeFile(String file_Name) {
		String end = "</Document>\n</kml>";
		try {
			FileWriter fw = new FileWriter(file_Name, true);
			fw.append(end);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
