import java.io.*;
import java.util.ArrayList;

public class Utility {
	private static String path="data.txt";
	
	public static void writeStudentToFile(ArrayList<Student> list) throws IOException{
		FileOutputStream f=new FileOutputStream(path);
		ObjectOutputStream ob=new ObjectOutputStream(f);
		try{
		ob.writeObject(list);
		}catch (FileNotFoundException e){
			System.out.println("Lỗi ghi file");
		}
		ob.close();		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> readStudentFromFile() throws IOException{
		ArrayList<Student> list=new ArrayList<Student>();
		FileInputStream f= new FileInputStream(path);
		ObjectInputStream o=new ObjectInputStream(f);
		try {
			list=(ArrayList<Student>) o.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e){
			System.out.println("Lỗi đọc file"+e.getMessage());
		}
		o.close();	
		return list;
	}
}

