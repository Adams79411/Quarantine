/**
 * 
 */
package binarytree;

/**
 * @author Steny Adams J
 *
 */
public class BinaryTreeImpl {
	Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeImpl list = new BinaryTreeImpl();
		list.root = new Node(2);
		list.root.left = new Node(3);
		list.root.right = new Node(5);
		list.root.left.left = new Node(4);
		list.root.left.right = new Node(6);
		System.out.println("InOrder");
		inOrder(list.root);
		System.out.println("PreOrder");
		preOrder(list.root);
		System.out.println("PostOrder");
		postOrder(list.root);
	}

	private static void postOrder(Node root2) {// left,right,root
		if (root2 == null) {
			return;
		}
		postOrder(root2.left);
		postOrder(root2.right);
		System.out.println(root2.data);
	}

	private static void preOrder(Node root2) {// root,left,right
		if (root2 == null) {
			return;
		}
		System.out.println(root2.data);
		preOrder(root2.left);
		preOrder(root2.right);
	}

	private static void inOrder(Node root2) {// left,root,right
		if (root2 == null) {
			return;
		}
		inOrder(root2.left);
		System.out.println(root2.data);
		inOrder(root2.right);
	}
}
