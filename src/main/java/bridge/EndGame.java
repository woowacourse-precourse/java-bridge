package bridge;

public class EndGame {
  
  private final Count count;
  
  public EndGame(Count count) {
    this.count = count;
  }
  
  public boolean endGame(int size){
    int steps = count.getSteps();
    if(steps == size){
      return true;
    }
    return false;
  }
}
