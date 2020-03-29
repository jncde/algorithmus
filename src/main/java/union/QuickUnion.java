package union;

import java.util.Arrays;

/**
 * Weighted quick-union
 *
 * why is tree deep is maximium lgN?
 */
public class QuickUnion implements Unionable {

  private Integer[] id;
  private Integer[] size;


  public QuickUnion (){}


  public void union(int p, int q){

    int proot = getRoot (p);
    int qroot = getRoot (q);

    if(proot==qroot) return;

    if(size[proot]<size[qroot]){
      size[qroot]+=size[proot];
      id[p]=q;
    }else{
      size[proot]+=size[qroot];
      id[q]=p;
    }

  }

  public Unionable init (int nodeNumbers) {
    id = new Integer[nodeNumbers];
    size= new Integer[nodeNumbers];
    for (int i = 0; i <nodeNumbers ; i++) {
      id[i]=i;
      size[i]=1;
    }
    return this;
  }

  public boolean connected(int p, int q){
      return getRoot(p)==getRoot(q);
  }

  public int getRoot(int i){
    while (i != id[i]){
      i= id[i];
    }
    return i;
  }

  @Override
  public String toString () {
    return "ArrayUnion{" + "nodes=" + Arrays.toString (id) + '}';
  }
}
