
public class SubtractTask implements Runnable{
	
	private Counter counter;
	private int limit;

	public SubtractTask(Counter counter, int limit){
		this.counter = counter;
		this.limit = limit;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= limit; i++) counter.add(-i);
		
	}

}
