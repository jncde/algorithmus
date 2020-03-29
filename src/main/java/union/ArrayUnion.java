package union;

import java.util.Arrays;

public class ArrayUnion implements Unionable {

  private int[] id;

  public ArrayUnion(){}


  public void union(int p, int q){

    int pvalue= id[p];
    int qvalue= id[q];
    for (int i = 0; i < id.length ; i++) {
      if(id[i] == pvalue)
        id[i]=qvalue;
    }
  }

  public Unionable init (int nodeNumbers) {
    id = new int[nodeNumbers];
    for (int i = 0; i <nodeNumbers ; i++) {
      id[i]=i;
    }
    return this;
  }

  public boolean connected(int p, int q){
      return id[p] == id[q];
  }

  @Override
  public String toString () {
    return "ArrayUnion{" + "nodes=" + Arrays.toString (id) + '}';
  }
}
