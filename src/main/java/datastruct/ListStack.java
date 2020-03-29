package datastruct;

public class ListStack<T> implements Stack<T> {

  Node last;

  public ListStack () {

  }

  public T pop () {

    if (!isEmpty ()) {
      T item = last.t;
      last=last.next;
      return item;
    }

    return null;
  }

  public boolean push (T item) {
    Node old = last;
    last = new Node (null, item);
    last.next = old;
    return true;
  }

  public boolean isEmpty () {
    return last==null;
  }

  private class Node{

    Node next;
    T    t;

    public Node (Node next, T t) {
      this.next = next;
      this.t = t;
    }
  }
}
