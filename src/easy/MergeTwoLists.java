package easy;

public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;

		if (list2 == null)
			return list1;

		Result result = makeThisNode(list1, list2, null);

		ListNode resultNode = result.node;
		int flag = result.flag;
		if (flag == 1)
			list1 = list1.next;
		else
			list2 = list2.next;

		int count = 0;
		ListNode node = null;
		while (list1 != null && list2 != null) {

			if (count == 0) {
				result = makeThisNode(list1, list2, resultNode);
				count++;
			} else
				result = makeThisNode(list1, list2, node);

			node = result.node;
			flag = result.flag;
			if (flag == 1)
				list1 = list1.next;
			else
				list2 = list2.next;
		}

		while (list2 != null) {
			node = makeNode(list2.val, node == null ? resultNode : node);
			list2 = list2.next;
		}

		while (list1 != null) {
			node = makeNode(list1.val, node == null ? resultNode : node);
			list1 = list1.next;
		}

		return resultNode;
	}

	private Result makeThisNode(ListNode list1, ListNode list2, ListNode node) {

		ListNode tempNode = new ListNode();
		int flag = 0;

		int val1 = list1.val;
		int val2 = list2.val;
		if (val1 < val2) {
			tempNode.val = val1;
			flag = 1;
		} else {
			tempNode.val = val2;
			flag = 2;
		}

		if (node != null)
			node.next = tempNode;

		return new Result(flag, tempNode);
	}

	private static ListNode makeNode(int... intArray) {
		ListNode resultNode = new ListNode();
		if (intArray.length == 0)
			return resultNode;

		resultNode.val = intArray[0];

		ListNode node = null;
		for (int index = 1; index < intArray.length; index++) {
			if (index == 1)
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

		ListNode node1 = makeNode(2);
		ListNode node2 = makeNode(1);

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

	public static class Result {
		int flag;
		ListNode node;

		Result(int val, ListNode node) {
			this.flag = val;
			this.node = node;
		}
	}
}
