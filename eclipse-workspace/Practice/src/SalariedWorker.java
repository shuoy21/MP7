
public class SalariedWorker extends Worker {
	public SalariedWorker(String name, double salaryRate) {
		this.name = name;
		this.salaryRate = salaryRate;
	}
	@Override
	public double computePay(int hour) {
		// TODO Auto-generated method stub
		return 40 * salaryRate;
	}

}
