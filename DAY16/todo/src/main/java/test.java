import java.util.ArrayList;
import java.util.List;

public class test {

	private static List testList;
	
	public static void main(String[] args) {

		List l1 = new ArrayList();
		l1.add(1);
		List l2 = new ArrayList();
		l2.add(2);
		
		testList = l1;
		System.out.println(testList);
		
		testList = l2;
		System.out.println(testList);
	}

}
