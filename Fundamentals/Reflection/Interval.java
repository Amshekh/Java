class Interval{

	private int id;
	protected int minutes;
	protected int seconds;
	private static int count;

	public Interval(int m, int s){
		id = ++count;
		minutes = m + s / 60;
		seconds = s % 60;
	}
	
	public int getId(){
		return id;
	}

	public int getMinutes(){
		return minutes;
	}

	public int getSeconds(){
		return seconds;
	}

	public Interval add(Interval other){
		return new Interval(minutes + other.minutes,
			seconds + other.seconds);
	}

	public String toString(){
		String text = minutes + ":";
		if(seconds < 10) 
			text += "0";
		return text + seconds;
	}

	public int getTime(){
		return 60 * minutes + seconds;
	}

	public int hashCode(){
		return id ^ getTime();
	}

	public boolean equals(Object other){
		Interval that = (Interval) other;
		return (this.id == that.id) && (this.getTime() == that.getTime());
	}

}

class BigInterval extends Interval{

	private int hours;

	public BigInterval(int h, int m, int s){
		super((m + s / 60) % 60, s % 60);
		hours = h + (m + s / 60) / 60;
	}

	public int getHours(){
		return hours;
	}

	public int getTime(){
		return 3600 * hours + super.getTime();
	}

	public String toString(){
		String text = hours + ":";
		if(minutes < 10) text += "0";
		return text + super.toString();
	}
	
}

























