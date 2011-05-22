package dk.ostebaronen.lottery.domain;

import java.util.ArrayList;

public class Person {
	private int id;
	private String name;
	private ArrayList<Lot> lots;
	
	public ArrayList<Lot> getLots() {
		return lots;
	}

	public void setLots(ArrayList<Lot> lots) {
		this.lots = lots;
	}

	public Person(String name, int id) {
		this.id = id;
		this.name = name;
		lots = new ArrayList<Lot>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Id: " + id + "\t Name: "+ name + "\t Lots: " + lots.size();
	}
}
