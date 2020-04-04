package math;

import static math.MathHelper.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aufgabe6 {

  public static void main (String[] args) {
    String inputFile = System.getProperty ("user.dir") + "/algorithmus/src/main/resources/MathAufgabe6.txt";
    String outputFile = System.getProperty ("user.dir") + "/algorithmus/src/main/resources/result.txt";
    Say ("Hallo Suri");
    Say ("Geben bitte 1, wenn du die Zahlen geben wollten.");
    Say ("Geben bitte 2, wenn du die Zahlen aus einer Datei auslesen wollten.");

    int choice = GebenZahl ();

    if (choice == 1) {
      calculateSingleConsoleInput ();
    } else if (choice == 2) {
      calculateBachDate (inputFile, outputFile);
    } else {
      System.out.println ("please give 1 or 2!");
    }

  }

  private static void calculateBachDate (java.lang.String fileName,
                                         String outputFileName) {
    List<Integer> numbers = readNumbersFromFile (fileName);
    List<String> result = new ArrayList<> ();
    shouldSay = false;
    for (Integer number: numbers) {
      resetParam ();
      result.add (calculateForNumber (number));
    }
    writeToFile (result, outputFileName);
  }

  private static void writeToFile (List<String> result,
                                   String outputFileName) {
    File myObj = new File (outputFileName);
    try {
      FileWriter myWriter = new FileWriter (myObj);
      for (String row: result) {
        myWriter.write (row);
      }
      myWriter.close ();
    } catch (IOException e) {
      e.printStackTrace ();
    }
  }

  private static void calculateSingleConsoleInput () {
    Say ("Suri, please tell me, which number would you calculate?");

    int zahl1 = GebenZahl ();

    Say ("Thank you, you have tipped the number: " + zahl1);

    Say ("Should i say something??? ");

    String s = new Scanner (System.in).nextLine ();
    if (s.equalsIgnoreCase ("No")) {
      shouldSay = false;
    }
    String result = calculateForNumber (zahl1);

    System.out.println (result);
  }

  private static String calculateForNumber (int zahl1) {
    int inputNumber = zahl1;
    merkenZahl (zahl1);

    do {

      if (istGradeZahl (zahl1)) {
        zahl1 = zahl1 / 2;
      } else {
        zahl1 = zahl1 + 9;
        zahl1 = zahl1 / 2;
      }
      merkenZahl (zahl1);

    } while (Habe_Ich_Das_Schon_gesehen (zahl1));

    return output (inputNumber);
  }

  private static String output (int inputNumber) {
    StringBuilder outPut = new StringBuilder ();
    outPut.append (inputNumber + " : ");
    for (int i = 0; i < last; i++) {
      if (i != 0) {
        outPut.append ("->");
      }
      outPut.append (kopf[i]);
    }
    outPut.append (System.getProperty ("line.separator"));

    return outPut.toString ();
  }

}
