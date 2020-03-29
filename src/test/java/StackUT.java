import org.junit.Assert;
import org.junit.Test;

import datastruct.ArrayStack;
import datastruct.ListStack;
import datastruct.ResizeArrayStack;
import datastruct.Stack;

public class StackUT {


  @Test
  public void ArrayStack(){

    ArrayStack<Integer> stack = new ArrayStack<Integer> (5);
    testStack (stack, 5);

  }

  @Test
  public void ListStack(){

    Stack<Integer> stack = new ListStack<Integer> ();
    testStack (stack, 10);

  }

  @Test
  public void ResizeArrayStack () {

    Stack<Integer> stack = new ResizeArrayStack<Integer> (5);
    testStack (stack, 10);

  }

  private void testStack (Stack<Integer> stack,
                          int size) {
    Assert.assertTrue (stack.isEmpty ());

    for (int i = 0; i < size; i++) {
      stack.push (i);
      System.out.println (String.format ("%s push %s to stack", stack.getClass ().getSimpleName (), i));
    }

    for (int i = 0; i < size; i++) {
      int stackLast = size - 1 - i;
      Assert.assertEquals (new Integer (stackLast), stack.pop ());
      System.out.println (String.format ("%s pop %s from stack", stack.getClass ().getSimpleName (), stackLast));
    }

  }

}
