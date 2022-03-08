import java.util.*;
public class Library implements Cloneable{

	private String departmentName;
	List<Book> booksList =  new ArrayList<>();
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Book> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}
	public void loadBook() {
		for(int i=1; i<=10; i++) {
			Book book = new Book();
			book.setBookId(i);
			book.setBookName("Book" + i);
			getBooksList().add(book);
		}
	}
	public String toString() {
		return "Library [departmentName=" + departmentName + ", booksList=" + booksList + "]";
	}
	protected Library clone() throws CloneNotSupportedException {
		
		Library newlibrary = new Library();
		for(Book book: getBooksList()) {
			newlibrary.getBooksList().add(book);
		}
		return newlibrary;
	}
}
