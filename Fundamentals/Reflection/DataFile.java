import java.io.*;

public class DataFile{
	
	public static byte[] getBytes(String fileName){
		try{
			FileInputStream in = new FileInputStream(fileName);
			byte[] bytes = new byte[in.available()];
			in.read(bytes);
			in.close();
			return bytes;
		}catch(IOException e){
			return null;
		}
	}
}

