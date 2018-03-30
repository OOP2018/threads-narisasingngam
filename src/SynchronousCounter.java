
public class SynchronousCounter extends Counter{

	public synchronized void add(int amount){
		super.add(amount);
	}

}
