public class DriverManagerEarly {

	public static void main(String[] args) {
		Driver first = Driver.getInstance();
		Driver second = Driver.getInstance();
		System.out.println("static first Early instance :- "+first);
		System.out.println("static second Early instance :- "+second);
	}

}
class Driver{
    //create static object
	static Driver obj = new Driver();
	//create private constructor so we can not create object from outside this class
	private Driver() {
		System.out.println("instance created");
	}
	//create a method to return this object
	public static Driver getInstance(){
		return obj;
	}
}