package math;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathHelper {

  public static int[] kopf      = new int[3000];
  static int          last      = 0;
  static boolean      shouldSay = true;

  public static int GebenZahl () {
    return Integer.parseInt (new Scanner (System.in).nextLine ());
  }

  public static void Say (Object out) {
    if (shouldSay) {
      System.out.println (out);
    }
  }

  public static int[] merkenZahl (int zahl) {
    kopf[last++] = zahl;
    Say ("ich habe mir die Zahl " + zahl + " gemerkt!");
    return kopf;
  }

  public static boolean Habe_Ich_Das_Schon_gesehen (int zahl) {

    Say ("Kennen ich diese zahl?");
    int count = 0;
    Say ("ich kenne schon die Zahlen:");
    if (shouldSay) {
      for (int i = 0; i < last; i++) {
        System.out.print (kopf[i]);
        System.out.print (" , ");
      }
      System.out.println (" ");
    }
    for (int i = 0; i < last; i++) {
      if (kopf[i] == zahl) {
        count++;
      }
    }

    if (count == 2) {

      Say ("Ja, ich kenen diese Zahl, es ergibt sich ein Kreisel:");
      Say ("Alle meine Zahlen");

      for (int i = 0; i < last; i++) {
        Say (kopf[i]);
      }
      return false;
    } else {

      Say ("nein, ich kenne diesen Zahl noch nicht");
      return true;
    }

  }

  public static boolean istGradeZahl (int zahl) {
    return zahl % 2 == 0;
  }

  public static void resetParam () {
    kopf = new int[3000];
    last = 0;
  }

  public static List<Integer> readNumbersFromFile (String DateiName) {
    ArrayList<Integer> numbers = new ArrayList<> ();
    try {
      BufferedReader reader = new BufferedReader (new FileReader (DateiName));

      String line = reader.readLine ();
      while (line != null) {
        numbers.add (Integer.parseInt (line));
        line = reader.readLine ();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace ();
    } catch (IOException e) {
      e.printStackTrace ();
    }

    return numbers;
  }

}
