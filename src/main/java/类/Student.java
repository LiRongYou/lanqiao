package 类;

public class Student{
	private String ID;//ID
	private String name;//����
	private int age;//����

public void setID(String ID){
	if(ID.length()!=18){
		ID="0";
	}else{
	this.ID=ID;
}
}
public String getID(String ID){
	return ID;
	
}
public void setName(String name){
	this.name=name;
}
public String getName(String name){
	return name;
}
public void setAge(int age){
	if (age>0&&age<100){
	this.age=age;
	}else{
	age=0;
	}	
}
public int getAge(int age){
	return age;
}
public Student(String ID,String name,int age){//���췽������ʼ�����������
	this.ID=ID;
	this.name=name;
	this.age=age;
}
public Student(String name,int age){//���췽������ʼ����������ԣ�����ID������
	this.ID="123456789123456789";
	this.name=name;
	this.age=age;
}
public Student(String ID,String name){//���췽������ʼ����������ԣ�����age������
	this.ID=ID;
	this.name=name;
	this.age=20;
}

	@Override
	public String toString() {
		return "Student{" +
				"ID='" + ID + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public static void main(String[] args) {
	String id="1";
	String name="黎荣右";
		Student student=new Student(id,name,10);
		System.out.println(student.toString());
	}
}