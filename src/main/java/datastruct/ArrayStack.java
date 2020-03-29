package datastruct;

public class ArrayStack<T> implements Stack<T> {

  T[] stack;
  int last;
  public ArrayStack(int length){
    stack= (T[]) new Object[length];
    last=-1;
  }

  public T pop () {
    if(last!=-1){
      return stack[last--];
    }
    return null;
  }

  public boolean push (T item) {
      if(last!=stack.length-1){
        stack[++last]=item;
        return true;
      }
      return false;
  }

  public boolean isEmpty () {
    return last==-1;
  }
}
