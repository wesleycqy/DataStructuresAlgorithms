class Node {
    int data, color;
    Node parent, left, right;
  }
  
  public class RedBlackTree {
    private Node root, NullNode;
    public RedBlackTree() {
        NullNode = new Node();
        NullNode.right = null;
        NullNode.left = null;
        NullNode.color = 0;
        root = NullNode;
      }
    
  
    void Preorder(Node currentNode) {
      if (currentNode != NullNode) {
        System.out.print("\t"+ currentNode.data);
        Preorder(currentNode.left);
        Preorder(currentNode.right);
      }
    }
    void displayPreorder() {
      Preorder(this.root);
    }
    
    void Postorder(Node currentNode) {
      if (currentNode != NullNode) {
        Postorder(currentNode.left);
        System.out.print("\t"+ currentNode.data);
        Postorder(currentNode.right);
      }
    }
    void displayPostorder() {
      Postorder(this.root);
    }

    void transplant(Node x, Node y) {
      if (x.parent == null)         {root = y;} 
      else if (x == x.parent.left)  {x.parent.left = y;}
      else                          {x.parent.right = y;}
      y.parent = x.parent;
    }
  
    void deleteNodeHelper(Node node, int key) {
      Node z = NullNode;
      Node x, y;
      while (node != NullNode) {
        if (node.data == key) {
          z = node;
        }
  
        if (node.data <= key) {
          node = node.right;
        } else {
          node = node.left;
        }
      }
  
      if (z == NullNode) {
        System.out.println("Oops, was not able to find key in the tree");
        return;
      }
  
      y = z;
      int yOriginalColor = y.color;
      if (z.left == NullNode) {
        x = z.right;
        transplant(z, z.right);
      } else if (z.right == NullNode) {
        x = z.left;
        transplant(z, z.left);
      } else {
        y = minimum(z.right);
        yOriginalColor = y.color;
        x = y.right;
        if (y.parent == z) {
          x.parent = y;
        } else {
          transplant(y, y.right);
          y.right = z.right;
          y.right.parent = y;
        }
  
        transplant(z, y);
        y.left = z.left;
        y.left.parent = y;
        y.color = z.color;
      }
      if (yOriginalColor == 0) {
        RBDeleteFixup(x);
      }
    }
    void deleteNode(int number) {
        deleteNodeHelper(this.root, number);
      }
    void RBDeleteFixup(Node newNode) {
        Node placeholder;
        while (newNode != root && newNode.color == 0) {
          if (newNode == newNode.parent.left) {
            placeholder = newNode.parent.right;
            if (placeholder.color == 1) {
              placeholder.color = 0;
              newNode.parent.color = 1;
              leftRotate(newNode.parent);
              placeholder = newNode.parent.right;
            }
    
            if (placeholder.left.color == 0 && placeholder.right.color == 0) {
              placeholder.color = 1;
              newNode = newNode.parent;
            } else {
              if (placeholder.right.color == 0) {
                placeholder.left.color = 0;
                placeholder.color = 1;
                rightRotate(placeholder);
                placeholder = newNode.parent.right;
              }
    
              placeholder.color = newNode.parent.color;
              newNode.parent.color = 0;
              placeholder.right.color = 0;
              leftRotate(newNode.parent);
              newNode = root;
            }
          } else {
            placeholder = newNode.parent.left;
            if (placeholder.color == 1) {
              placeholder.color = 0;
              newNode.parent.color = 1;
              rightRotate(newNode.parent);
              placeholder = newNode.parent.left;
            }
    
            if (placeholder.right.color == 0 && placeholder.right.color == 0) {
              placeholder.color = 1;
              newNode = newNode.parent;
            } else {
              if (placeholder.left.color == 0) {
                placeholder.right.color = 0;
                placeholder.color = 1;
                leftRotate(placeholder);
                placeholder = newNode.parent.left;
              }
    
              placeholder.color = newNode.parent.color;
              newNode.parent.color = 0;
              placeholder.left.color = 0;
              rightRotate(newNode.parent);
              newNode = root;
            }
          }
        }
        newNode.color = 0;
      }
    
    void RBInsertFixUp(Node k) {
      Node u;
      while (k.parent.color == 1) {
        if (k.parent == k.parent.parent.right) {
          u = k.parent.parent.left;
          if (u.color == 1) {
            u.color = 0;
            k.parent.color = 0;
            k.parent.parent.color = 1;
            k = k.parent.parent;
          } else {
            if (k == k.parent.left) {
              k = k.parent;
              rightRotate(k);
            }
            k.parent.color = 0;
            k.parent.parent.color = 1;
            leftRotate(k.parent.parent);
          }
        } else {
          u = k.parent.parent.right;
  
          if (u.color == 1) {
            u.color = 0;
            k.parent.color = 0;
            k.parent.parent.color = 1;
            k = k.parent.parent;
          } else {
            if (k == k.parent.right) {
              k = k.parent;
              leftRotate(k);
            }
            k.parent.color = 0;
            k.parent.parent.color = 1;
            rightRotate(k.parent.parent);
          }
        }
        if (k == root) {
          break;
        }
      }
      root.color = 0;
    }
    void insert(int element) {
      Node z = new Node();
      z.data = element;
      
      Node y = null;
      Node x = root;
      while(x != NullNode)
      {
        y = x;
        if(z.data < x.data)   {x = x.left;}
        else                  {x = x.right;}
      }

      z.parent = y;
      if(y == null)             {root = z;}
      else if(z.data < y.data)  {y.left = z;}
      else                      {y.right = z;}

      z.left = NullNode;
      z.right = NullNode;
      z.color = 1; 
      
      if(z.parent == null)          {z.color = 0; return;}
      if(z.parent.parent ==  null)  {return;}
      
      RBInsertFixUp(z);

      }

    Node minimum(Node node) {
      while (node.left != NullNode) {
        node = node.left;
      }
      return node;
    }

    void leftRotate(Node nodeLeft) {
      Node nodeRight = nodeLeft.right;
      nodeLeft.right = nodeRight.left;
      if (nodeRight.left != NullNode) {nodeRight.left.parent = nodeLeft;}
      nodeRight.parent = nodeLeft.parent;

      if (nodeLeft.parent == null)                {root = nodeRight;} 
      else if (nodeLeft == nodeLeft.parent.left)  {nodeLeft.parent.left = nodeRight;}
      else                                        {nodeLeft.parent.right = nodeRight;}
      nodeRight.left = nodeLeft;
      nodeLeft.parent = nodeRight;
    }
    void rightRotate(Node nodeLeft) {
      Node nodeRight = nodeLeft.left;
      nodeLeft.left = nodeRight.right;
      if (nodeRight.right != NullNode) {nodeRight.right.parent = nodeLeft;}
      nodeRight.parent = nodeLeft.parent;

      if (nodeLeft.parent == null)                  {root = nodeRight;} 
      else if (nodeLeft == nodeLeft.parent.right)   {nodeLeft.parent.right = nodeRight;}
      else                                          {nodeLeft.parent.left = nodeRight;}
      nodeRight.right = nodeLeft;
      nodeLeft.parent = nodeRight;
    }
        
    void printTree(Node node, String indent, boolean last) {
      if (node != NullNode) {
        System.out.print(indent);
        if (last)   {System.out.print("R-------");indent += "\t";}
        else        {System.out.print("L-------");indent += "|\t";}
  
        String strColor = node.color == 1 ? "red" : "black";
        System.out.println(node.data + "(" + strColor + ")");
        printTree(node.left, indent, false);
        printTree(node.right, indent, true);
      }
    }
    void printTree() {
      printTree(this.root, "", true);
    }
  
    public static void main(String[] args) {
      RedBlackTree bst = new RedBlackTree();

		  int arr[] = {20,10,30,15,40,35,13,50,5,45,7};

      for(int i = 0; i<arr.length; i++){
          bst.insert(arr[i]);

          System.out.println("INSERT: "+arr[i]);
          System.out.print("Preorder: ");
          bst.displayPreorder();
          System.out.println();
          System.out.print("Inorder: ");
          bst.displayPostorder();
          System.out.println();
          System.out.println();
          bst.printTree();
          System.out.println("\n");
      }

      System.out.println("\nAfter deleting 30:");
      bst.deleteNode(30);
      System.out.print("Preorder: ");
      bst.displayPreorder();
      System.out.println();
      System.out.print("Postorder: ");
      bst.displayPostorder();
      System.out.println();
      System.out.println();

      bst.printTree();
    }
  }