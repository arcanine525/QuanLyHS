import java.io.IOException;
import java.util.*;


public class Menu{
	public int option,choice;
	ArrayList<Student>list=new ArrayList<Student>();
	Scanner in= new Scanner(System.in);

	void mainMenu(){
		printMenu();
		System.out.println("Nhập tính năng:");
		option=in.nextInt();
		boolean quit=false;
		while(quit==false){
			switch(option){
			case 1:
				viewStudentList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				//viewStudentList();
				System.out.println("Nhập ID của học viên cần xóa:");
				delStudent(in.nextInt());
				break;
			case 4:
				in.nextLine();
				System.out.println("Nhập ID của học viên cần chỉnh sửa:");
				choice=in.nextInt();
				modifyStudent(choice);
				break;
			case 5:
				try {
					Utility.writeStudentToFile(list);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Ghi thành công!");
				mainMenu();
				break;
			case 6:
				try {
					list=Utility.readStudentFromFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Load file thành công!");
				mainMenu();
			case 7:
				quit=true;
				break;
			default:
				System.out.println("Không hỗ trợ!");
				mainMenu();				
			}
		}
	}

	void printMenu(){
		System.out.println("==============================");
		System.out.println("1 - Xem danh sách lớp");
		System.out.println("2 - Thêm học viên");
		System.out.println("3 - Xóa học viên");
		System.out.println("4 - Chỉnh sửa thông tin học viên");
		System.out.println("5 - Ghi dữ liệu");
		System.out.println("6 - Load dữ liệu");
	}

	//Xem danh sách học viên
	void viewStudentList(){
		System.out.println("Danh sách học viên");
		for(int i=0;i<list.size();i++){
			list.get(i).printStudentInfoByLine();
		}
		mainMenu();
	}

	//Thêm học viên
	void addStudent(){
		Student hs=new Student();
		String str;
		int d,m,y;
		System.out.println("Nhập thông tin học viên");
		hs.setName(in.nextLine());
		System.out.println("Nhập tên học viên: ");
		
		hs.setName(in.nextLine());
		
		System.out.println("Nhập ngày sinh: ");
		d=in.nextInt();
		System.out.println("Nhập tháng sinh: ");
		m=in.nextInt();
		System.out.println("Nhập năm sinh:");
		y=in.nextInt();
		Day day=new Day(d,m,y);
		hs.setDateOfBirth(day);

		str=in.nextLine();
		System.out.println("Nhập địa chỉ:");
		str=in.nextLine();
		hs.setAddress(str);

		System.out.println("Nhập email:");
		hs.setEmail(in.next());

		System.out.println("Nhập số điện thoại:");
		hs.setPhone(in.next());

		list.add(hs);
		setID();
		mainMenu();
	}

	//Xóa học viên
	void delStudent(int id){
		list.remove(id-1);
		setID();//RESET ID
		System.out.println("Xóa thành công!");
		mainMenu();
	}

	//Chỉnh sửa thông tin học viên
	void modifyStudent(int c){
		int id=c-1;
		list.get(id).printStudenInfoByMenu();
		System.out.println("Chọn trường muốn chỉnh sửa: ");
		int choice=in.nextInt();
		switch(choice){
		case 1:
			System.out.println("Không thể thay đổi ID!");
			break;
		case 2:
			System.out.println("Nhập tên học viên: ");
			list.get(id).setName(in.next());
			break;
		case 3:
			int d,m,y;
			System.out.println("Nhập ngày sinh: ");
			d=in.nextInt();
			System.out.println("Nhập tháng sinh: ");
			m=in.nextInt();
			System.out.println("Nhập năm sinh:");
			y=in.nextInt();
			Day day=new Day(d,m,y);
			list.get(id).setDateOfBirth(day);
			break;
		case 4:
			System.out.println("Nhập địa chỉ:");
			list.get(id).setAddress(in.next());
			break;
		case 5:
			System.out.println("Nhập email:");
			list.get(id).setEmail(in.next());
			break;
		case 6:
			System.out.println("Nhập số điện thoại:");
			list.get(id).setPhone(in.next());
			break;
		default:
			System.out.println("Không hỗ trợ!");
			break;
		}
		mainMenu();
	}

	//Set ID
	void setID(){
		for(int i=0;i<list.size();i++){
			list.get(i).setID(i+1);
		}
	}

}
