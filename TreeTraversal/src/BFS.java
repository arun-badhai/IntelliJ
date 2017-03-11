import java.util.ArrayList;

/**
 * Created by Shivani Shinde on 10-03-2017.
 */
public class BFS {
    static ArrayList<Node> list = new ArrayList<>();
    public static void main (String[] args) throws java.lang.Exception {
        BFS bfs = new BFS();

        bfs.insert(4);bfs.insert(7);
        bfs.insert(16);bfs.insert(43);
        bfs.insert(14);bfs.insert(17);
        bfs.insert(6);bfs.insert(12);
        bfs.insert(3);bfs.insert(7);
        bfs.insert(1);bfs.insert(4);

        list.add(Node.root);
        display(Node.root);
    }
    public static void display(Node root){
        System.out.print(list.get(0).key+ " ");
        if(root.left != null) {
            list.add(root.left);
        }
        if(root.right != null) {
            list.add(root.right);
        }
        list.remove(0);
        if(!list.isEmpty()){
            display(list.get(0));
        }
        else{
            return;
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
