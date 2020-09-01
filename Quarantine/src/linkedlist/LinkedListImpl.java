package linkedlist;

public class LinkedListImpl {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int d) {
			next = null;
			data = d;
		}
	}

	public static LinkedListImpl insert(LinkedListImpl list, int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node lastNode = list.head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
		return list;
	}

	public static LinkedListImpl delete(LinkedListImpl list, int data) {
		Node currentNode = list.head;
		if (currentNode != null && currentNode.data == data) {
			list.head = currentNode.next;
			return list;
		}
		Node temp = null;
		while (currentNode != null && currentNode.data != data) {
			temp = currentNode;
			currentNode = currentNode.next;
		}
		if (currentNode != null) {
			temp.next = currentNode.next;
		}
		return list;
	}

	public static LinkedListImpl deleteAtPosition(LinkedListImpl list, int position) {
		Node currentNode = list.head;
		int counter = 0;
		if (currentNode != null && counter == position) {
			list.head = currentNode.next;
			return list;
		}
		Node temp = null;
		while (currentNode != null && counter != position) {
			temp = currentNode;
			currentNode = currentNode.next;
			counter++;
		}
		if (currentNode != null) {
			temp.next = currentNode.next;
		}
		return list;
	}

	public static LinkedListImpl insertAtMiddle(LinkedListImpl list, int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		if (list.head == null) {
			list.head = newNode;
		} else {
			int count = 0;
			Node lastNode1 = list.head;
			while (lastNode1 != null) {
				lastNode1 = lastNode1.next;
				count++;
			}
			int midPosition = (count % 2 == 0) ? (count / 2) : (count + 1) / 2;
			Node lastNode = list.head;
			int counter = 1;
			while (counter != midPosition) {
				lastNode = lastNode.next;
				counter++;
			}
			newNode.next = lastNode.next;
			lastNode.next = newNode;
		}
		return list;
	}

	public static void printData(LinkedListImpl list) {
		Node data = list.head;
		while (data != null) {
			System.out.println(data.data);
			data = data.next;
		}
	}

	public static void main(String[] args) {
		LinkedListImpl impl = new LinkedListImpl();
		insert(impl, 5);
		insert(impl, 6);
		insert(impl, 7);
		insert(impl, 8);
//		delete(impl, 5);
//		deleteAtPosition(impl, 1);
		insertAtMiddle(impl, 9);
//		printData(impl);
//		printTheMiddleElement(impl);
		reverseTheList(impl);
		printData(impl);
	}

	private static LinkedListImpl reverseTheList(LinkedListImpl list) {
		Node next = null, prev = null;
		Node currentNode = list.head;
		while (currentNode != null) {
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}
		list.head = prev;
		return list;
	}

	private static void printTheMiddleElement(LinkedListImpl list) {
		Node currentNode = list.head;
		int count = 0;
		while (currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}
		int midPosition = count % 2 == 0 ? (count / 2) : (count + 1) / 2;
		int counter = 0;
		Node lastNode = list.head;
		while (counter != midPosition) {
			lastNode = lastNode.next;
			counter++;
		}
		System.out.println(lastNode.data);
	}
}