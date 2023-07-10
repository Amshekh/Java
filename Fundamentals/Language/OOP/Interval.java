public class Interval{
	
	private int minutes, seconds;

	public Interval(int m, int s){
		minutes = m + s / 60;
		seconds = s % 60;
	}

	public final int getMinutes(){
		return minutes;
	}

	public final int getSeconds(){
		return seconds;
	}

	public int getTime(){
		return 60 * minutes + seconds;
	}
	
	public Interval add(Interval other){
		return new Interval(minutes + other.minutes, 
			seconds + other.seconds);
	}

	public String toString(){
		String result = minutes + ":";
		if(seconds < 10)
			result += "0";
		return result + seconds;
	}

	public int hashCode(){
		return 1000 * getTime();
	}

	public boolean equals(Object other){
		Interval that = (Interval) other;
		return this.getTime() == that.getTime();
	}

	public void finalize(){
		System.out.printf("-- Reclaiming interval instance<%d, %d>%n", 
			minutes, seconds);
	}
}
















