/**
 * Created by Shivani Shinde on 10-03-2017.
 */
public class DFS {
    public static void main (String[] args) throws java.lang.Exception {
        DFS dfs = new DFS();

        dfs.insert(4); dfs.insert(7); dfs.insert(16);
        dfs.insert(43); dfs.insert(14); dfs.insert(17);
        dfs.insert(6); dfs.insert(12); dfs.insert(3);
        dfs.insert(7); dfs.insert(1); dfs.insert(4);

        inOrder(Node.root);
        System.out.println();
        preOrder(Node.root);
        System.out.println();
        postOrder(Node.root);
    }
    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key+ " ");
            inOrder(root.right);
        }
    }
    public static void preOrder(Node root){
        if(root != null){
            System.out.print(root.key+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key+ " ");
        }
    }
    public static void insert(int key){
        Node node = new Node(key);
        if(Node.root == null){
            Node.root = node;
            return;
        }
        Node parent = Node.root;
        Node child = Node.root;
        while(true) {
            parent = child;
            if (key >= child.key) {
                child = parent.right;
                if (child == null) {
                    parent.right = node;
                    return;
                }
            } else {
                child = parent.left;
                if (child == null) {
                    parent.left = node;
                    return;
                }
            }
        }
    }
}