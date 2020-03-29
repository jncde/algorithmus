package datastruct;

public class ListStack<T> implements Stack<T> {

  Node last;

  public ListStack () {

  }

  public T pop () {

    if(last!=null){
      Node lastTemp=last;
      last=last.next;
      return lastTemp.t;
    }

    return null;
  }

  public boolean push (T item) {

    Node newNode = new Node (null,item);

    if(last == null){
      last =newNode;
    }else{
      Node old= last;
      last =newNode;
      last.next=old;
    }
    return true;
  }

  public boolean isEmpty () {
    return last==null;
  }

  private class Node{
    public Node next;
    public T t;

    public Node (Node next, T t) {
      this.next = next;
      this.t = t;
    }
  }
}
