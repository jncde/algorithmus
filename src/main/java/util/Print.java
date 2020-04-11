package util;

import java.util.Arrays;
import java.util.List;

public class Print {

  public static <T> String quickSort (T[] a,
                                      int singleWidth,
                                      Integer... emphasize) {
    if (a.length == 0) {
      return "[]";
    }

    StringBuilder result = new StringBuilder ();
    List<Integer> em = Arrays.asList (emphasize);
    String padding = "%" + singleWidth + "s";
    result.append ("[");
    for (int i = 0; i < a.length; i++) {
      String s = a[i].toString ();
      if (em.contains (i)) {
        s = "_" + s;
      }
      result.append (String.format (padding, s));
    }
    result.append ("]");

    return result.toString ();
  }

}
