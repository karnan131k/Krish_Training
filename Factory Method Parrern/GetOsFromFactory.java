public class GetOsFromFactory {
	public BaseOs getInstance(OsType ostype) {
		if (ostype.equals(OsType.ANDROID)) {
			return new Android();
		}else if (ostype.equals(OsType.APPLE)) {
			return new Apple();
		}else {
			return new Linux();
		}
	}
}
