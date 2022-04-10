public class DriverManagerLazy {

	public static void main(String[] args) {
		// Driver first = Driver.getInstance();
		// Driver second = Driver.getInstance();
		// System.out.println("static first Early instance :- "+first);
		// System.out.println("static second Early instance :- "+second);
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Driver first = Driver.getInstance();
				System.out.println("first Lazy instance :- "+first);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				Driver second = Driver.getInstance();
				System.out.println("second Lazy instance :- "+second);
			}
		});
		t1.start();
		t2.start();
	}

}
class Driver{
    //create static object
	 private static Driver obj ;
	 //create private constructor so we can not create object from outside this class
	 private Driver() {
		 System.out.println("instance created");
	 }
	 //create a method to return this object
	 public static Driver getInstance(){
         //verifying , object is already available or not
		 if (obj == null) {
			 obj=new Driver();
		}
		 return obj;
	 }
} 