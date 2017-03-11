/**
 * Created by Shivani Shinde on 10-03-2017.
 */
class Node
{
    int key;
    Node left;
    Node right;
    public static Node root;

    // Constructor
    public Node(){
        root = null;
    }

    // Constructor
    public Node(int key){
        this.key = key;
        left = null;
        right = null;
    }
}