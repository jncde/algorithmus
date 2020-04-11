package sort;

public class MergeSort {

  public void sort (Comparable[] arr,
                    Comparable[] aux,
                    int l,
                    int r) {

    if (r <= l)
      return;
    int m = l + (r - l) / 2;
    sort (arr, aux, l, r / 2);
    sort (arr, aux, r / 2, r);
    merge (arr, aux, l, m, r);

  }

  private void merge (Comparable[] a,
                      Comparable[] aux,
                      int l,
                      int m,
                      int r) {

    for (int k = l; k <= r; k++)
      aux[k] = a[k];

    int i = l, j = m + 1;
    for (int k = l; k <= r; k++) {
      if (i > m)
        a[k] = aux[j++];
      else if (j > r)
        a[k] = aux[i++];
      else if (less (aux[j], aux[i]))
        a[k] = aux[j++];
      else
        a[k] = aux[i++];
    }

  }

  private boolean less (Comparable a1,
                        Comparable a2) {
    return a1.compareTo (a2) < 0;
  }

}
