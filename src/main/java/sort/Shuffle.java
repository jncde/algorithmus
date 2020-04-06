package sort;

import java.util.Random;

public class Shuffle {

  public static Integer[] knutShuffle (int length) {

    Integer[] arr = new Integer[length];

    // init
    for (int i = 0; i < length; i++) {
      arr[i] = i;
    }

    Random random = new Random ();

    for (int i = 0; i < length; i++) {
      int r = random.nextInt (i + 1);
      if (r != i) {
        int temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;
      }
    }

    return arr;

  }

}
