
public class Dog {
	private String name;
	private String breed;
	private int age;
	
	// default constructor
	
	public Dog() {
		name = "lucky";
		breed = "Husky";
		age = 3;
	}
	
	// constructor with param
	
	public Dog(String n, String b, int a) {
		name = n;
		breed = b;
		age = a;		
	}
	
	// getters
	
	public String getName(){
		return name;
	}
	
	public String getBreed() {
		return breed;
	}
	
	public int getAge() {
		return age;
	}
	
	// setters
	
	public void setName(String in) {
		name = in;
	}
	
	public void setBreed(String in){
		breed = in;
	}
	
	public void setAge(int in) {
		age = in;
	}
	
	
	
}
