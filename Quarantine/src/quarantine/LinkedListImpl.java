package quarantine;

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
		return list;
	}

	public static LinkedListImpl deleteAtPosition(LinkedListImpl list, int position) {
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
		printData(impl);
	}
}