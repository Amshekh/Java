class NativeMethodTest{

	private native static int readShared(int index);

	private static String getSharedText(){
		StringBuffer sb = new StringBuffer();
		for(int i = 0;; i++){
			int b = readShared(i);
			if(b == -1) return null;
			if(b == 0) break;
			sb.append((char) b);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception{
		System.loadLibrary("nmt");
		System.out.printf("Shared text: %s%n", getSharedText());
	}
}















