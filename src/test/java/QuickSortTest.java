import org.junit.Assert;
import org.junit.Test;

import sort.QuickSort;
import sort.Shuffle;
import util.Print;

public class QuickSortTest {

  @Test
  public void testSort () {

    Integer[] arr = createShuffledArray (20);
    QuickSort<Integer> quickSort = new QuickSort<Integer> ();
    long start = System.currentTimeMillis ();
    quickSort.sort (arr, 0, arr.length - 1);
    System.out.printf ("it takes %s mili seconds ", System.currentTimeMillis () - start);

    for (int i = 0; i < 20; i++) {
      Assert.assertEquals ((Integer) i, arr[i]);
    }

  }

  private Integer[] createShuffledArray (int sortedArrayLength) {
    Integer[] arr = Shuffle.knutShuffle (sortedArrayLength);
    System.out.println ("Before sorting:");
    Integer[] index = createIndexArray (sortedArrayLength);
    System.out.println (String.format (" index    : %s", Print.quickSort (index, 5)));
    System.out.println (String.format (" %2s %2s %2s : %s", "i", "j", "k", Print.quickSort (arr, 5)));
    return arr;
  }

  @Test
  public void worstCase () {
    Integer[] alreadySorted = createIndexArray (3000);
    QuickSort<Integer> quickSort = new QuickSort<> ();
    long start = System.currentTimeMillis ();
    quickSort.sort (alreadySorted, 0, alreadySorted.length - 1);
    System.out.printf ("last time : %d milisecond %n", System.currentTimeMillis () - start);
    Print.quickSort (alreadySorted, 4);

  }

  @Test
  public void selectKMin () {

    // find the k -th smallest element
    int k = 11;

    Integer[] arr = createShuffledArray (20);
    QuickSort<Integer> quickSort = new QuickSort<> ();
    long start = System.currentTimeMillis ();
    quickSort.select (arr, k, 0, arr.length - 1);
    long lastTime = System.currentTimeMillis () - start;
    System.out.println (String.format (" %2s %2s %2s : %s", "i", k, k, Print.quickSort (arr, 5, 0, k)));
    System.out.printf ("the k min is: %d  %n", arr[k]);
    System.out.printf ("last time : %d milisecond %n", lastTime);

  }

  @Test
  public void selectKMin2 () {

    // find the k -th smallest element
    int k = 11;

    Integer[] arr = createShuffledArray (20);
    QuickSort<Integer> quickSort = new QuickSort<> ();
    long start = System.currentTimeMillis ();
    Comparable<Integer> select = quickSort.select (arr, k);
    long lastTime = System.currentTimeMillis () - start;
    System.out.println (String.format (" %2s %2s %2s : %s", "i", k, k, Print.quickSort (arr, 5, 0, k)));
    System.out.printf ("the k min is: %d  %n", select);
    System.out.printf ("last time : %d milisecond %n", lastTime);

  }

  private Integer[] createIndexArray (int length) {
    Integer[] index = new Integer[length];
    for (int i = 0; i < index.length; i++) {
      index[i] = i;
    }
    return index;
  }

}
