class LegacyBox{
	
	private int length, breadth, height;

	public LegacyBox(int l, int b, int h){
		length = l;
		breadth = b;
		height = h;
	}

	public boolean isValid(short thickness){
		return (thickness < length / 2)
			&& (thickness < breadth / 2)
			&& (thickness < height / 2);
	}

	public native int getInnerVolume(short thickness);

	static{
		System.loadLibrary("box4j");
	}
}

class ObjectAccessTest{

	public static void main(String[] args) throws Exception{
		int l = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int h = Integer.parseInt(args[2]);
		short t = Short.parseShort(args[3]);
		LegacyBox box = new LegacyBox(l, b, h);
		System.out.printf("Inner volume = %d%n", 
			box.getInnerVolume(t));
	}
}

















