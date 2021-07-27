class BSTNode {
	public Double data;
	public BSTNode right;
	public BSTNode left;
	public BSTNode(Double data, BSTNode right, BSTNode left) {
		this.data = data;
		this.right = right;
		this.left = left;
	}
	public BSTNode(Double data) {
		this.data = data;
	}
	public BSTNode() {
	}
}



class BST {
	public BSTNode root;

	public BST(Double data) {
		BSTNode root = new BSTNode(data);
		this.root = root;
	}

	public BST() {
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(Double data) {
		if (root == null) {
			root = new BSTNode(data);
			return;
		}
		BSTNode temp = root;
		BSTNode node = new BSTNode(data);
		while (temp.left != null || temp.right != null) {
			if (data <= temp.data) {
				if (temp.left == null) {
					temp.left = node;
					break;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = node;
					break;
				}
				temp = temp.right;
			}
		}
		if (data <= temp.data) {
			temp.left = node;
		} else {
			temp.right = node;
		}
	}
	
	public void insert(Double data, BSTNode root) {
		if(root==null) {
			root=new BSTNode(data);
			return;
		}
		if(data<=root.data) {
			if(root.left==null) {
				root.left=new BSTNode(data);
				return;
			}
			insert(data,root.left);
		}else {
			if(root.right==null) {
				root.right=new BSTNode(data);
				return;
			}
			insert(data,root.right);
		}
	}

	public void sort() {
		inorder(root);
		System.out.println();
	}

	private void inorder(BSTNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}

	public BSTNode search(double key) {
		while (root == null) {
			System.out.println("empty tree");
			return null;
		}
		BSTNode temp = root;
		while (temp != null && temp.data != key) {
			if (key <= temp.data) {
				if (temp.left == null) {
					System.out.println("No such element");
					return null;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					System.out.println("No such element");
					return null;
				}
				temp = temp.right;
			}
		}
		return temp;
	}
	
	public BSTNode delete(double data) {
		return delete(root, data);
	}

	private BSTNode delete(BSTNode root,double data) {
		while (root == null) {
			System.out.println("empty tree");
			return null;
		}
		
		if(data<root.data) {
			root.left=delete(root.left,data);
		}else if(data>root.data) {
			root.right=delete(root.right,data);
		}else {
			if(root.left==null) {
				return root.right;
			}
			if(root.right==null) {
				return root.left;
			}
			
			BSTNode correct=root.right;
			while(correct.left!=null) {
				correct=correct.left;
			}
			
			root.data=correct.data;
			root.right=delete(root.right,data);
		}
		
		return root;
	}
}
