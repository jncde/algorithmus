package datastruct;

public class ListQuerue<String> implements Queue<String> {

  Node first;
  Node last;

  public ListQuerue (int length) {
  }

  public void enqueue (String string) {

  }

  public String dequeue () {
    return null;
  }

  public boolean isEmpty () {
    return first == last;
  }

  private class Node {

    String item;
    Node   next;
  }

}
