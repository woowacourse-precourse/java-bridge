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
    System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    String temp = inputView.readGameCommand();
    if(temp.equals("Q")){
      return true;
    }
    return false;
  }
}
