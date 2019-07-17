import BuildingBlocks.List;

public class app {
	public static void main(String[] args) {
		List l = new List();
		
		for (int x = 1; x <= 50; x++) {
			l.append(x);
		}
		

		l.insert("Head", 0);
				
		System.out.println(l);
		
		System.out.println(l.length());
		
		l.delete(0);
		System.out.println(l);
		
		System.out.println(l.length());
	}

}
