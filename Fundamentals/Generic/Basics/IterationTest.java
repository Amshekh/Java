import java.util.*;

class LottoStateMachine implements Iterable<Integer>{
	
	private int digits;
	private static Random rdm = new Random();
	
	public LottoStateMachine(int digits){
		this.digits = digits;
	}

	private static int getNextDigit(){
		long t = System.currentTimeMillis() + 1000;
		while(System.currentTimeMillis() < t);
		return rdm.nextInt(10);
	}
	
	public Iterator<Integer> iterator(){
		return new Iterator<Integer>(){

			int count = digits;

			public boolean hasNext(){
				return count > 0;
			}
			
			public Integer next(){
				count--;
				return getNextDigit();
			}

			public void remove(){}
		};
	}
}

class IterationTest{

	public static void main(String[] args){
		LottoStateMachine lotto = new LottoStateMachine(10);
		System.out.print("WINNER:");
		for(int digit : lotto)
			System.out.printf(" %d", digit);
		System.out.println("!");
	}
}














