package linked_list;

public class Run {
	public static void main(String[] args) {
		System.out.println("Testing linked list");
		LinkedList<String> linearList = new LinkedLinearList<String>();
		System.out.println(linearList.outputList());
		linearList.addFirst("c");
		System.out.println(linearList.outputList());
		linearList.addFirst("b");
		linearList.addFirst("a");
		System.out.println(linearList.outputList());
		linearList.addLast("d1");
		System.out.println(linearList.outputList());
		linearList.addFirst("d0");
		System.out.println(linearList.outputList());
		linearList.addLast("d2");
		System.out.println(linearList.outputList());
		System.out.println(linearList.indexOf("d0"));
		System.out.println(linearList.remove(4));
		System.out.println(linearList.outputList());
		linearList.add(4, "e1");
		System.out.println(linearList.outputList());
		
	}
}
