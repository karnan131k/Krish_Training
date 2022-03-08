public class Customer {
	public static void main(String[] args) {
		Phone buyPhone1 = new CustomizePhone()
				.setOs("Android")
				.setRam("4GB")
				.setBattery("4000 MAH")
				.getPhone();
		System.out.println(buyPhone1);
		System.out.println();
		Phone buyPhone2 = new CustomizePhone()
				.setOs("IOS")
				.setRam("12GB")
				.setBattery("3500 MAH")
				.setScrenSize(15.4)
				.getPhone();
		System.out.println(buyPhone2);
	}
}
