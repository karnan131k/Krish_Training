public class CustomizePhone {
	private String os;
	private String ram;
	private String processor;
	private double screnSize;
	private String battery;
	public CustomizePhone setOs(String os) {
		this.os = os;
		return this;
	}
	public CustomizePhone setRam(String ram) {
		this.ram = ram;
		return this;
	}
	public CustomizePhone setProcessor(String processor) {
		this.processor = processor;
		return this;
	}
	public CustomizePhone setScrenSize(double screnSize) {
		this.screnSize = screnSize;
		return this;
	}
	public CustomizePhone setBattery(String battery) {
		this.battery = battery;
		return this;
	}
	public Phone getPhone() {
		return new Phone(os,ram,processor,screnSize,battery);
	}
	
	
}
