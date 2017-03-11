/**
 * Created by Shivani Shinde on 10-03-2017.
 */
class BinarySearch
{
    // Function to insert a node
    public static void insert(int key){

        // create a new node having the given value
        Node newnode = new Node(key);

        // Root node is empty
        if(Node.root == null){
            Node.root = newnode;
            return;
        }
        Node curr = Node.root;
        Node parent = null;

        while(true){
            parent = curr;

            // Node will be inserted in the left subtree
            if(key < curr.key){
                curr = curr.left;
                if(curr == null){
                    parent.left = newnode;
                    return;
                }
            }

            // Node will be inserted in the right subtree
            else{
                curr = curr.right;
                if(curr == null){
                    parent.right = newnode;
                    return;
                }
            }
        }
    }

    // Function to search an element
    public static boolean search(int key){
        Node curr = Node.root;

        // Iterate till element found
        while(curr != null){

            // current root is the element
            if(curr.key == key){
                return true;
            }
            Node parent = curr;

            // element value is less than current root value
            if(key < curr.key){
                curr = parent.left;
            }

            // element value is more than current root value
            else{
                curr = parent.right;
            }
        }

        // element not found
        return false;
    }

    // Function to delete an element
    public static boolean delete(int key){
        Node curr = Node.root;
        Node parent = Node.root;
        int rightpresent = 0;

        // Search for the element in the tree
        while(curr.key != key){
            parent = curr;

            // Element in the left sub tree
            if(key < curr.key){
                rightpresent = 0;
                curr = parent.left;
            }

            // Element in the right sub tree
            else{
                rightpresent = 1;
                curr = parent.right;
            }
            // Element not present in the tree
            if(curr == null){
                return false;
            }
        }

        // No children of the node to be deleted
        if(curr.left == null && curr.right == null){

            // If root, delete the root
            if(curr == Node.root){
                Node.root = null;
            }
            else{

                // Left child of its parent
                if(rightpresent == 0){
                    parent.left = null;
                }

                // Right child of its parent
                else{
                    parent.right = null;
                }
            }
        }

        // Only left sub tree
        else if(curr.right == null){

            // Root deleted, left child is new root
            if(curr == Node.root){
                parent.left = Node.root;
            }
            else{

                // Node to be deleted is on the right side of the parent
                if(rightpresent == 1){
                    parent.right = curr.left;
                }

                // Node to be deleted is on the left side of the parent
                else{
                    parent.left = curr.left;
                }
            }
        }

        // Only right sub tree
        else if(curr.left == null){

            // Root deleted, right child is new root
            if(curr == Node.root){
                parent.right = Node.root;
            }
            else{

                // Node to be deleted is on the right side of the parent
                if(rightpresent == 1){
                    parent.right = curr.right;
                }

                // Node to be deleted is on the left side of the parent
                else{
                    parent.left = curr.right;
                }
            }
        }

        // Both left and right subtrees
        else{
            Node replace = getReplacement(curr);
            Node temp = curr;

            // Root node replaced
            if(curr == Node.root){
                Node.root = replace;
            }
            else{

				// Node to be deleted and replaced is on the right side of the parent
                if(rightpresent == 1){
                    parent.right = replace;
                }
				// Node to be deleted and replaced is on the left side of the parent
				else{
                    parent.left = replace;
                }
            }
            // Left sub tree added to the new node
            replace.left =  temp.left;
        }
        return true;
    }

    // Return replacement node for the deleted node
    public static Node getReplacement(Node tobedeleted){
        Node curr = tobedeleted.right;
        Node parent = null;;
        Node replace = null;

        // Finds replacement node i.e. smallest node from the right subtree
        while(curr != null){
            parent = replace;
            replace = curr;
            curr = curr.left;
        }

        // Only if the replacement node had right subtree
        if(replace.right != null){
            parent.left = replace.right;
            replace.right = tobedeleted.right;
        }
        return replace;
    }

    public static void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.key);
            display(root.right);
        }
    }

    // Inorder traversal
    public static void main (String[] args) throws java.lang.Exception
    {
        BinarySearch b = new BinarySearch();
        b.insert(3);b.insert(8);b.insert(6);b.insert(2);b.insert(10);b.insert(20);
        b.insert(1);b.insert(4);b.insert(9);b.insert(25);b.insert(15);b.insert(16);
        b.insert(5);b.insert(7);b.insert(51);b.insert(2);b.insert(35);b.insert(21);
        boolean val  = search(45);
        if(val == true){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }
        boolean del  = delete(16);
        if(del == true){
            System.out.println("Element deleted");
        }
        else{
            System.out.println("No element to delete");
        }
        b.display(Node.root);
    }
}