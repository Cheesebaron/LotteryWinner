package dk.ostebaronen.lottery.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import dk.ostebaronen.lottery.domain.Lot;
import dk.ostebaronen.lottery.domain.Person;

public class LotFileReader {
	private ArrayList<Person> persons;
	private static int id = 0;
	
	public LotFileReader() {
		persons = new ArrayList<Person>();
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}
	
	public Person readLine(String line) {
		Scanner lineScan = new Scanner(line);
		lineScan.useDelimiter(","); //use comma as delimiter
		
		Person p = new Person(lineScan.next(), id);
		ArrayList<Lot> lots = new ArrayList<Lot>();
		int numberOfLots = Integer.parseInt(lineScan.next());
		for (int i = 0; i < numberOfLots; i++) {
			Lot l = new Lot(i);
			lots.add(l);
		}
		p.setLots(lots);

		return p;
	}
	
	public void readFile(String fileName) {
		File inFile = new File(fileName);
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			
			while((line = br.readLine()) != null) { //Read line by line
				id++;
				Person p = readLine(line);
				if (p != null)
					persons.add(p);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
