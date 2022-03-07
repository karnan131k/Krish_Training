import java.util.*;
public class FindStringOccurrence {
	public static void findOccurrence(char[] ch) {

		Map<Character,Integer> map=new HashMap<Character,Integer>();  
		for(int i=0; i<ch.length; i++) {
			int occurrence=0;
			for(int j=0; j<ch.length; j++) {
				
				if(ch[i]==ch[j]) {
					occurrence++;
				}
			}
			map.put(ch[i], occurrence);
		}
		System.out.println("Character's Occurrence :-");
		System.out.println(map);
		
	}

	public static void main(String[] args) {
		System.out.println("Enter your string for finding the character occurrence ?");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        char[] ch = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            ch[i] = text.charAt(i);
        }
        findOccurrence(ch);
	}

}

