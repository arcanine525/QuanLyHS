import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String name;
	private Day dateOfBirth;
	private String address;
	private String email;
	private String phone;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Day getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Day dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	Student(){
	}

	public void printStudenInfoByMenu(){
		System.out.println("1.	Mã số: "+ID);
		System.out.println("2.	Họ tên: "+name);
		System.out.println("3.	Ngày sinh: "+dateOfBirth.printDate());
		System.out.println("4.	Địa chỉ: "+address);
		System.out.println("5.	Email: "+email);
		System.out.println("6.	Điện thoại: "+phone);
	}
	
	public void printStudentInfoByLine(){
		System.out.println(ID+"\t"+name+"\t"+dateOfBirth.printDate()+"\t"+address+"\t"+email+"\t"+phone);
	}
}
