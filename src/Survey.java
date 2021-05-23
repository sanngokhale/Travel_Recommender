
//binary tree
class Node {
    public String que;
    Node no;
    Node yes;

    Node(String que) {
        this.que = que;
        yes = null;
        no = null;
    }

}

class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }

    public void setTree(){
        root.que="Does any member have severe medical condition?";
        root.no.que="";
        root.yes.que="";
        
    }
}

