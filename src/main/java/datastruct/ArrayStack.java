package datastruct;

public class ArrayStack<T> implements Stack<T> {

  private T[] stack;
  private int N = 0;
  public ArrayStack(int length){
    stack= (T[]) new Object[length];
  }

  public T pop () {
    if (N != 0) {
      T pop = stack[--N];
      stack[N] = null;
      return pop;
    }
    return null;
  }

  public boolean push (T item) {
    if (N != stack.length) {
      stack[N++] = item;
        return true;
      }
      return false;
  }

  public boolean isEmpty () {
    return N == 0;
  }
}
