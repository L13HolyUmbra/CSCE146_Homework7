
public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//construct
//		BSTt lolz = new BSTt(); 
//		//test is empty
//		System.out.println(lolz.isEmpty());
//		lolz.insert(5); 
//		//test root
//		System.out.println(lolz.getRoot());
//		lolz.insert(3); 
//		System.out.println(lolz.getRoot());
//		//test node count
//		System.out.println(lolz.getNodeCount());
//		//test get left and right
//		System.out.println(lolz.getRoot().getRight());
//		System.out.println(lolz.getRoot().getLeft());
//		lolz.insert(1); 
//		//test height
//		System.out.println(lolz.getMaxHeight());
//		//test contains
//		System.out.println(lolz.contains(1)); 
		
		//slide tree
		BST<Integer> test = new BST<Integer>(); 
		test.insert(13); 
		test.insert(9); 
		test.insert(11); 
		test.insert(4); 
		test.insert(1); 
		test.insert(7); 
		test.insert(16); 
		test.insert(14); 
		test.insert(20);
		test.insert(18);
		test.insert(23); 
		//test all the traversals 
		System.out.println(test.toStringInorder(null));
		System.out.println(test.toStringPreorder(null));
		System.out.println(test.toStringPostorder(null));
		//test the contains
		System.out.println(test.contains(2)); 
		//test height
		System.out.println(test.getMaxHeight());
		//test node count
		System.out.println(test.getNodeCount());
		
		
	}

}
