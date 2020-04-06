package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Insertion<T> {

  public void sort (T[] array,
                    Comparator<T> comparator) {
    System.out.println ("begin insertion sort");
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j > 0; j--) {
        if (comparator.compare (array[j], array[j - 1]) < 0) {
          T temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
          System.out.println (Arrays.toString (array));
        }
      }
    }

  }

}
