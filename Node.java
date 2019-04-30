/**
  Represent a node that holds...
  o  cargo of interest to the user
  o  reference to the next node in the list
 */

public class Node {
    private Object cargo;
    private Node   nextNode;
    private Node   lastNode;

    private final int NEXT_NODE = 0;
    private final int LAST_NODE = 1;


    /**
      Construct an instance
     */
    public Node( Object cargo) {
        this.cargo = cargo;
        // default value is fine for Node.next
    }
    public Node( Object cargo, Node nextNode, int nextNodeOrLastNode) {
        this( cargo);
        if (nextNodeOrLastNode == NEXT_NODE) {
          this.nextNode = nextNode;
          if (nextNode != null)
            nextNode.lastNode = this;
          }
        else {
          this.lastNode = nextNode;
          if (nextNode != null)
            lastNode.nextNode = this;
        }
    }

    /**
      @return a string representation of this instance
     */
    public String toString() {
        String result =
            cargo.toString()  // polymorphically use appropriately toString!
          + " id " // include a usually-unique identifier for this node
          + super.toString()
          ;

        // Show rest of chain of nodes
        if( nextNode == null)
             result += " [no next]";
        else result += " --> " + nextNode;
        return result;
    }

    // classic accessor and mutator
    public Node getNextNode() {
        return nextNode;
    }

    public Node getLastNode() {
      return lastNode;
    }

    public Node setNextNode( Node nextNode) {
        Node saveForReturn = this.nextNode;
        this.nextNode = nextNode;
        return saveForReturn;
    }

    public Node setLastNode(Node lastNode) {
      Node saveForReturn = this.lastNode;
      this.lastNode = lastNode;
      return saveForReturn;
    }

    public Object getCargo() {
        return cargo;
    }

    public Object setCargo( Object newValue) {
        Object saveForReturn = cargo;
        cargo = newValue;
        return saveForReturn;
    }
}
