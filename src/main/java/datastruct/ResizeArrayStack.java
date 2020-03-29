package datastruct;

import java.util.Arrays;

public class ResizeArrayStack<T> implements Stack<T> {

  T[] stack;
  int last;

  public ResizeArrayStack (int length) {
    stack = (T[]) new Object[length];
    last = -1;
  }

  public T pop () {

    if (!isEmpty ()) {
      shrinkStack ();
      return stack[last--];
    }
    return null;
  }

  private void shrinkStack () {
    if (last == stack.length / 4) {
      T[] newStack = (T[]) new Object[stack.length / 2];
      for (int i = 0; i <= last; i++) {
        newStack[i] = stack[i];
      }
      System.out.println (String.format ("stack-size is decreased from %d to %d", stack.length, stack.length / 2));
      System.out.println ("before shrinking" + this.toString ());
      stack = newStack;
      System.out.println ("after shrinking" + this.toString ());
    }
  }

  public boolean push (T item) {
    if (last == stack.length - 1) {
      increaseStackSize ();
    }
    stack[++last] = item;
    return true;
  }

  private void increaseStackSize () {
    int length = stack.length;
    T[] newStack = (T[]) new Object[2 * length];
    for (int i = 0; i < length; i++) {
      newStack[i] = stack[i];
    }
    System.out.println (String.format ("stack-size is increased from %d to %d", length, 2 * length));
    System.out.println (this.toString ());
    stack = newStack;
    System.out.println (this.toString ());

  }

  public boolean isEmpty () {
    return last == -1;
  }

  @Override
  public String toString () {
    return "ResizeArrayStack{" + "stack=" + Arrays.toString (stack) + ", last=" + last + '}';
  }
}
