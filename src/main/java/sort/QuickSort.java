package sort;

import util.Print;

/**
 * inplace sort, instable, simple bestcase O(n) worstcase O(n2)
 */
public class QuickSort<T> {

  public void sort (Comparable<T>[] a, int lo, int hi) {

    if (hi <= lo)
      return;

    int j = partition (a, lo, hi);
    sort (a, lo, j - 1);
    sort (a, j + 1, hi);

  }

  private int partition (Comparable<T>[] a, int lo, int hi) {

    int i = lo;
    int j = hi + 1;

    Comparable<T> kv = a[i];

    while (true) {

      while (less (a[++i], kv))
        if (i == hi)
          break;

      while (less (kv, a[--j]))
        if (j == lo)
          break;

      if (i >= j)
        break;

      echange (a, i, j);
      printRow (a, i, j, kv);
    }

    echange (a, lo, j);

    return j;

  }

  public Comparable<T> select (Comparable<T>[] a, int k) {

    int lo = 0, hi = a.length - 1;

    while (lo < hi) {
      int j = partition (a, lo, hi);
      if (j < k) {
        lo = j + 1;
      } else if (j > k) {
        hi = j - 1;
      } else {
        return a[k];
      }
    }

    return a[k];

  }

  /**
   * return the k min
   *
   * @param a
   * @param k
   * @return
   */
  public void select (Comparable<T>[] a, int k, int lo, int hi) {

    if (hi <= lo)
      return;

    int i = lo;
    int j = hi + 1;

    while (true) {

      while (less (a[++i], a[lo])) {
        if (i == hi)
          break;
      }

      while (less (a[lo], a[--j])) {
        if (j == lo)
          break;
      }

      if (j <= i)
        break;
      echange (a, i, j);
    }

    if (k == j)
      return;
    else if (k < j) {
      select (a, k, lo, j - 1);
    } else {
      select (a, k, j + 1, hi);
    }

  }

  private void echange (Comparable<T>[] a, int i, int j) {
    Comparable<T> temp = a[i];
    a[i] = a[j];
    a[j] = temp;

  }

  private boolean less (Comparable<T> t1, Comparable<T> kv) {
    return t1.compareTo ((T) kv) == -1;
  }

  public void printRow (Comparable<T>[] a, int i, int j, Comparable<T> partitionItem) {
    if (a.length < 50)
      System.out.println (String.format (" %2s %2s %2s : %s", i, j, partitionItem, Print.quickSort (a, 5, i, j)));
  }

}
