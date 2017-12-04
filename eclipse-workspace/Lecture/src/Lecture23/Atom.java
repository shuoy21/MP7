package Lecture23;

public class Atom {
		public double x;
		public double y;
		public double vx;
		public double vy;
		public Atom(double newX, double newY, double newVX, double newVY) {
			this.x = newX;
			this.y = newY;
			this.vx = newVX;
			this.vy = newVY;
		}
		public boolean equals(Atom a2) {
			return (this.x == a2.x) && (this.y == a2.y);
		}
		public boolean moving() {
			return (this.vx != 0) && (this.vy != 0);
		}
		public String toString() {
			String value = "";
			value += "Atom object: " + x + y;
			return value;
		}
}
