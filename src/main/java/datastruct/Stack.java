package datastruct;

public interface Stack<T> {
  T pop();

  boolean push(T item);

  boolean isEmpty();

}
