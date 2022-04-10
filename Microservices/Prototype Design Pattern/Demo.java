public class Demo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Library library1 = new Library();
		library1.setDepartmentName("Department of computer science");
		library1.loadBook();
		System.out.println(library1);
		
		Library library2 = library1.clone();
		library2.setDepartmentName("Department of physical science");
		System.out.println(library2);
		
		Library library3 = library1.clone();
		library3.setDepartmentName("Department of Informtion technology");
		System.out.println(library3);
	}
}
