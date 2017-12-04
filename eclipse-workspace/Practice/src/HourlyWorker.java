
public class HourlyWorker extends Worker{
	public HourlyWorker(String name, double salaryRate) {
		this.name = name;
		this.salaryRate = salaryRate;
	}
		public double computePay(int hours) {
			double salary;
			if (hours <= 40) {
				salary = salaryRate * hours;
			} else {
				salary = salaryRate * 40 + 1.5 * salaryRate * (hours-40);
			}
			return salary;
		}
	}
	
