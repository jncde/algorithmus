package datastruct;

public interface Queue<T> {

  void enqueue (T t);

  T dequeue ();

  boolean isEmpty ();
}
