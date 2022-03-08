public class Phone {
	private String os;
	private String ram;
	private String processor;
	private double screnSize;
	private String battery;
	public Phone(String os, String ram, String processor, double screnSize, String battery) {
		super();
		this.os = os;
		this.ram = ram;
		this.processor = processor;
		this.screnSize = screnSize;
		this.battery = battery;
	}
	public String toString() {
		return "Phone [os=" + os + ", ram=" + ram + ", processor=" + processor + ", screnSize=" + screnSize
				+ ", battery=" + battery + "]";
	}
}
