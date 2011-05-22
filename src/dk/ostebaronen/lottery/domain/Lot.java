package dk.ostebaronen.lottery.domain;

public class Lot {
	private int serialNr;

	public Lot(int serialNr) {
		this.serialNr = serialNr;
	}

	public int getSerialNr() {
		return serialNr;
	}

	public void setSerialNr(int serialNr) {
		this.serialNr = serialNr;
	}
}
