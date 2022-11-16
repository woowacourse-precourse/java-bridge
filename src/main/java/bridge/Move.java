package bridge;

public enum Move {
  UP(0),
  DOWN(1);

  private final int index;
  Move(int index){
    this.index=index;
  }

  public int getIndex() {
    return index;
  }
}
