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
			
			list1 = list1.next;
			list2 = list2.next;
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
		if (intArray.length == 0)
			return resultNode;

		ListNode node = null;
		for (int index = 0; index < intArray.length; index++) {
			if (index == 0)
				node = makeNode(intArray[index], resultNode);
			else
				node = makeNode(intArray[index], node);
		}
		return resultNode;
	}

	private static ListNode makeNode(int integer, ListNode node) {

		ListNode tempNode = new ListNode();
		tempNode.val = integer;
		node.next = tempNode;
		return tempNode;
	}

	private static String printNode(ListNode node) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(node.val);

		while (node.next != null) {
			node = node.next;
			stringBuilder.append(", ");
			stringBuilder.append(node.val);
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

	public static class ListNode {
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
