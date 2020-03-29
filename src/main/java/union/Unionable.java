package union;

public interface Unionable {

  boolean connected(int p,int q);

  void union(int p,int q);

  Unionable init (int number);

}
