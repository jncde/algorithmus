import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import union.ArrayUnion;
import union.QuickUnion;
import union.Unionable;

public class ArrayUnionUT {


  @Test
  public void testArrayUnion(){
    ArrayUnion t = new ArrayUnion ();
    testArrayUnion (t);
    System.out.println (t.toString ());
  }

  @Test
  public void testTreeUnion(){
    QuickUnion t = new QuickUnion ();
    testArrayUnion (t);
    System.out.println (t.toString ());
  }


  public <T extends  Unionable>void testArrayUnion(T  t){
    Unionable union=null;

    BufferedReader reader;
    try {
      reader = new BufferedReader (new FileReader ("./src/main/resources/UnionData.txt"));
      String line = reader.readLine ();
      Boolean firstline=true;
      while (line!=null){

        if(firstline){
            union=t.init (Integer.parseInt (line));
          firstline=false;
        }else {
          String[] lineNumbers = line.split (",");
          int p=Integer.parseInt (lineNumbers[0]);
          int q=Integer.parseInt (lineNumbers[1]);
          if(!union.connected (p,q)){
            union.union (p,q);
            System.out.println (String.format ("%d uniion %d",p,q));
          }
        }
      line=reader.readLine ();

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace ();
    } catch (IOException e) {
      e.printStackTrace ();
    }

  }



}
