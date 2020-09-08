package binarytree;

public class BinarySearchTreeImpl {
	Node root;

	static class Node {
		int data;
		Node left = null, right = null;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		BinarySearchTreeImpl impl = new BinarySearchTreeImpl();
		impl.insert(5);
		impl.insert(99);
		impl.insert(12);
		impl.insert(34);
		impl.insert(6);
		impl.insert(77);
		impl.inorder(impl.root);
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}

	private void insert(int i) {
		root = insertData(root, i);
	}

	private Node insertData(Node root2, int i) {
		if (root2 == null) {
			root2 = new Node(i);
			return root2;
		}
		if (root2 != null) {
			if (i < root2.data) {
				root2.left = insertData(root2.left, i);
			} else if (i > root2.data) {
				root2.right = insertData(root2.right, i);
			}
		}
		return root2;
	}
}
