package Lecture23;

public class UniverseDriver {
	public void printContent() {
	Simulation mySimulation = new Simulation();
	mySimulation.init();
	for (int i = 0; i < mySimulation.atoms.length; i++) {
		System.out.println(mySimulation.atoms[i].x + "  " + mySimulation.atoms[i].y);
	}
	}
}
