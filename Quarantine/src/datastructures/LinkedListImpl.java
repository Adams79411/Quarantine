package datastructures;

public class LinkedListImpl {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int d) {
			data = d;
			next = null;
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
		Node temp = null;
		if (currentNode != null && currentNode.data == data) {
			currentNode = currentNode.next;
			return list;
		}
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
		Node temp = null;
		if (currentNode != null && position == 0) {
			currentNode = currentNode.next;
			return list;
		}
		int counter = 0;
		while (currentNode != null && position != counter) {
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
		}
		int size = 0;
		if (list.head != null) {
			Node lastNode = list.head;
			while (lastNode != null) {
				size++;
				lastNode = lastNode.next;
			}
		}
		int midPos = (size % 2) == 0 ? size / 2 : (size + 1) / 2;
		int counter = 0;
		if (list.head != null) {
			Node lastNode = list.head;
			while (lastNode.next != null && counter == midPos) {
				lastNode = lastNode.next;
			}
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
		deleteAtPosition(impl, 1);
		insertAtMiddle(impl, 6);
		printData(impl);
	}
}