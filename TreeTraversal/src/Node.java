/**
 * Created by Shivani Shinde on 10-03-2017.
 */
class Node {
    int key;
    Node left;
    Node right;
    static Node root;
    Node(){
        root = null;
    }
    Node(int key){
        this.key = key;
        left = null;
        right = null;
    }
}
