import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import sort.Insertion;
import sort.Shuffle;

public class InsertionTest {

  @Test
  public void InsertTest () {

    Integer[] arr = Shuffle.knutShuffle (20);
    System.out.println ("Before sorting:");
    System.out.println (Arrays.toString (arr));
    Insertion<Integer> insertion = new Insertion<> ();
    insertion.sort (arr, Comparator.naturalOrder ());
    System.out.println ("after insertion sorting:");
    System.out.println (Arrays.toString (arr));

    for (int i = 0; i < 20; i++) {
      Assert.assertEquals ((Integer) i, arr[i]);
    }

  }

}
