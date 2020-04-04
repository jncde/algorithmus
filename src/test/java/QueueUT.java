import org.junit.Assert;
import org.junit.Test;

import datastruct.ListQuerue;
import datastruct.Queue;

public class QueueUT {

  @Test
  public void ListQueue () {

    Queue<String> queue = new ListQuerue<> ();
    queue.enqueue ("1");
    queue.enqueue ("2");
    queue.enqueue ("3");
    queue.enqueue ("4");
    Assert.assertEquals ("1", queue.dequeue ());
    Assert.assertEquals ("2", queue.dequeue ());
    Assert.assertEquals ("3", queue.dequeue ());
    Assert.assertEquals ("4", queue.dequeue ());
    Assert.assertNull (queue.dequeue ());
    queue.enqueue ("5");
    queue.enqueue ("6");
    Assert.assertEquals ("5", queue.dequeue ());
    Assert.assertEquals ("6", queue.dequeue ());
    Assert.assertEquals (null, queue.dequeue ());

  }

}
