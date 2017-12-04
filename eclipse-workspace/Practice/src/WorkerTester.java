
public class WorkerTester {
	public static void main(String args[]) {
	Worker salaryWorker = new SalariedWorker("Iris", 100);
	Worker hourWorker = new HourlyWorker("Yan", 100);
	Worker[] workers = {salaryWorker, hourWorker};
	for (Worker worker: workers) {
		System.out.println(worker.name + " "+ worker.computePay(30));
	}
	Worker workerA = new HourlyWorker("Yan", 100);
	System.out.println(workerA);
	HourlyWorker b = (HourlyWorker)workerA;
	System.out.println(b);
	
}
}