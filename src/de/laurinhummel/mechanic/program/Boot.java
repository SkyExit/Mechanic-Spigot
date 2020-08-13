package de.laurinhummel.mechanic.program;

public class Boot {

	public static void main(String[] args) {
		Human laurin = new Human("Laurin", 13, "keiner", "Tennis");
		Human monja = new Human("Monja", 11, "keiner", "Schwimmen");
		
		laurin.printInformation();
		monja.printInformation();
	}
}
