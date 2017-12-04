package Lecture23;

public class Simulation {
	public Atom[] atoms;
	public static boolean smashing(Atom a1, Atom a2) {
		return (a1.x == a2.x && a1.y == a2.y);
	}
	public void init() {
		atoms = new Atom[100];
		for (int i = 0; i < atoms.length; i++) {
			double tempX = Math.random() * 10.0 - 5.0;
			double tempY = Math.random() * 14 - 1;
			atoms[i] = new Atom(tempX, tempY, 0, 0);
		}
	}
}
