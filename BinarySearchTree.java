
class Node
{
	int element;
	Node parent, left, right;
	
	public Node(int item)
	{
		element = item;
		left = right = null;
	}
}

public class BinarySearchTree {
	static Node root;

	BinarySearchTree() {
		root = null;
	}

	void displayInOrder() {
		displayInOrder(root);
	}

	void displayInOrder(Node node) {
		if (node == null)
			return;

		displayInOrder(node.left);
		System.out.print(node.element + "  ");
		displayInOrder(node.right);
	}

	void displayPreOrder() {
		displayPreOrder(root);
	}

	void displayPreOrder(Node node) {
		if (node == null)
			return;

		System.out.print(node.element + "  ");
		displayPreOrder(node.left);
		displayPreOrder(node.right);
	}

	void insertBST(Node z) {
		Node y = null;
		Node x = root;
		while (x != null) {
			y = x;
			if (z.element < x.element)
				x = x.left;
			else
				x = x.right;
		}
		z.parent = y;

		if (y == null)
			root = z;
		else if (z.element < y.element)
			y.left = z;
		else
			y.right = z;
	}

	boolean searchNodeBST(int num) {
		if (searchBST(root, num) == null)
			return false;
		return true;
	}

	Node searchBST(Node x, int k) {
		if (x == null || k == x.element)
			return x;
		if (k < x.element)
			return searchBST(x.left, k);
		else
			return searchBST(x.right, k);
	}

	Node minimumBST(Node x) {
		while (x.left != null)
			x = x.left;
		return x;
	}

	Node maximumBST(Node x) {
		while (x.right != null)
			x = x.right;
		return x;
	}

	void transplantBST(Node u, Node v) {
		if (u.parent == null)
			root = v;
		else if (u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		if (v != null)
			v.parent = u.parent;
	}

	void deleteNodeBST(int x) {
		Node n = searchBST(root, x);
		if (n == null)
			System.out.println("\nNode " + x + " Not Found");
		else
			deleteBST(n);
	}

	void deleteBST(Node z) {
		Node y;
		if (z.left == null)
			transplantBST(z, z.right);
		else if (z.right == null)
			transplantBST(z, z.left);
		else {
			y = minimumBST(z.right);
			if (y.parent != z) {
				transplantBST(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplantBST(z, y);
			y.left = z.left;
			y.left.parent = y;
		}
	}

	void RemoveOccurrence(int x) {
		int searchFlag = 0;
		while (searchFlag == 0) {
			Node n = searchBST(root, x);
			if (n == null) {
				searchFlag = 1;
			} else {
				deleteBST(n);
			}
		}

	}

	void leftRotateAtBST(int x) {
		Node n = searchBST(root, x);
		leftRotateBST(n);
	}

	void leftRotateBST(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != null)
			y.left.parent = x;
		y.parent = x.parent;
		if (x.parent == null)
			root = y;
		else if (x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		y.left = x;
		x.parent = y;
	}

	void rightRotateAtBST(int x) {
		Node n = searchBST(root, x);
		rightRotateBST(n);
	}

	void rightRotateBST(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != null)
			y.right.parent = x;
		y.parent = x.parent;
		if (x.parent == null)
			root = y;
		else if (x == x.parent.right)
			x.parent.right = y;
		else
			x.parent.left = y;
		y.right = x;
		x.parent = y;
	}

	void RemoveMinimum(){
		System.out.println("One "+ minimumBST(root).element + " was deleted");
		deleteNodeBST(minimumBST(root).element);
	}

	void removeAllMinimums(){
		System.out.println("All "+ minimumBST(root).element + "s were deleted");
		RemoveOccurrence(minimumBST(root).element);
	}

	public static void main(String[] args) {
		Node n;
		BinarySearchTree B = new BinarySearchTree();

		int arr[] = { 5, 3, 10, 7, 13, 15, 10,3,3 };

		for (int i = 0; i < arr.length; i++) {
			n = new Node(arr[i]);
			B.insertBST(n);
		}

		System.out.print("\nPreorder: ");
		B.displayPreOrder();
		System.out.println();
		System.out.print("Inorder: ");
		B.displayInOrder();
		System.out.println();
		System.out.println();

		B.leftRotateAtBST(5);
		System.out.print("Preorder: ");
		B.displayPreOrder();
		System.out.println();
		System.out.print("Inorder: ");
		B.displayInOrder();
		System.out.println();
		System.out.println();

		B.rightRotateAtBST(5);
		System.out.print("Preorder: ");
		B.displayPreOrder();
		System.out.println();
		System.out.print("Inorder: ");
		B.displayInOrder();
		System.out.println();
		System.out.println();

		B.RemoveOccurrence(10);
		System.out.print("Preorder: ");
		B.displayPreOrder();
		System.out.println();
		System.out.print("Inorder: ");
		B.displayInOrder();
		System.out.println();
		System.out.println();

		B.RemoveMinimum();
		System.out.print("Preorder: ");
		B.displayPreOrder();
		System.out.println();
		System.out.print("Inorder: ");
		B.displayInOrder();
		System.out.println();
		System.out.println();

		B.removeAllMinimums();
		System.out.print("Preorder: ");
		B.displayPreOrder();
		System.out.println();
		System.out.print("Inorder: ");
		B.displayInOrder();
		System.out.println();
		System.out.println();
	}
}