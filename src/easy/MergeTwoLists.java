package easy;

public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode resultNode = null;
		do {
			ListNode compareNode = compare(list1, list2);
			if (resultNode == null) {
				resultNode = new ListNode();
				resultNode.next = compareNode;
			} else
				resultNode.next = compareNode;
		} while (list1.next != null || list2.next != null);

		if (list1.next == null) {
			resultNode.val = list2.val;
			resultNode.next = list2;
			return resultNode;
		}

		if (list2.next == null) {
			resultNode.val = list1.val;
			resultNode.next = list1;
			return resultNode;
		}

		return resultNode;
	}

	private static ListNode compare(ListNode list1, ListNode list2) {
		int val1 = list1.val;
		int val2 = list2.val;

		if (val1 < val2)
			return list1;
		return list2;

	}

	private static ListNode makeNode(int... intArray) {
		ListNode resultNode = new ListNode();
		for (int index = 0; index<intArray.length; index++) {
			
		}
		return resultNode;
	}

	private static String printNode(ListNode node) {
		StringBuilder stringBuilder = new StringBuilder();
		while (node.next != null) {
			stringBuilder.append(node.val);
			stringBuilder.append(", ");
			node = node.next;
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println("_________________");

		ListNode node1 = makeNode(1, 2, 4);
		ListNode node2 = makeNode(1, 3, 4);

		MergeTwoLists mergeTwoLists = new MergeTwoLists();

		ListNode resultNode = mergeTwoLists.mergeTwoLists(node1, node2);

		System.out.println("_________________ resultNode -> " + printNode(resultNode));
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
