public class MobileFactoryMain {
	public static void main(String[] args) {
		GetOsFromFactory ob = new GetOsFromFactory();
		BaseOs androidBaseOs = ob.getInstance(OsType.ANDROID);
		androidBaseOs.showOs();
		BaseOs appleBaseOs = ob.getInstance(OsType.APPLE);
		appleBaseOs.showOs();
		BaseOs linuxBaseOs = ob.getInstance(OsType.LINUX);
		linuxBaseOs.showOs();
	}
}
