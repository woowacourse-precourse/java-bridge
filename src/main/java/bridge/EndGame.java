package bridge;

public class EndGame {
  
  
  
  private final Count count;
  private final InputView inputView;
  
  public EndGame(Count count, InputView inputView) {
    this.count = count;
    this.inputView = inputView;
  }
  
  public boolean endGame(int size){
    int steps = count.getSteps();
    if(steps == size){
      return true;
    }
    return false;
  }
  
  public boolean fail(){
    String temp = inputView.readGameCommand();
    if(temp.equals("Q")){
      return true;
    }
    return false;
  }
}
