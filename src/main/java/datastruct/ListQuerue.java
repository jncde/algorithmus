package datastruct;

public class ListQuerue<String> implements Queue<String> {

  Node first;
  Node last;

  public void enqueue (String item) {
    Node oldLast = last;
    last = new Node ();
    last.next = null;
    last.item = item;

    if (isEmpty ()) {
      first = last;
    } else {
      oldLast.next = last;
    }
  }

  public String dequeue () {
    if (first != null) {
      String temp = first.item;
      first = first.next;
      if (isEmpty ()) {
        last = null;
      }
      return temp;
    }

    return null;
  }

  public boolean isEmpty () {
    return first == null;
  }

  private class Node {
    String item;
    Node   next;
  }

}
