import org.junit.Assert;
import org.junit.Test;

import datastruct.ArrayStack;
import datastruct.ListStack;
import datastruct.Stack;

public class StackUT {


  @Test
  public void ArrayStack(){

    ArrayStack<Integer> stack = new ArrayStack<Integer> (5);
    testStack (stack);

  }

  @Test
  public void ListStack(){

    Stack<Integer> stack = new ListStack<Integer> ();
    testStack (stack);

  }

  private void testStack (Stack<Integer> stack) {
    Assert.assertTrue (stack.isEmpty ());
    stack.push (5);
    stack.push (4);
    stack.push (3);
    stack.push (2);
    stack.push (1);

    Assert.assertEquals (new Integer (1),stack.pop ());
    Assert.assertEquals (new Integer (2),stack.pop ());
    Assert.assertEquals (new Integer (3),stack.pop ());
    Assert.assertEquals (new Integer (4),stack.pop ());
    Assert.assertEquals (new Integer (5),stack.pop ());
    Assert.assertNull (stack.pop ());
  }

}
