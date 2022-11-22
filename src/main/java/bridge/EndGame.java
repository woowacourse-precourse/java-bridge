package bridge;

public class EndGame {
  
  private static final Count count = new Count();
  
  
  public static boolean endGame(int size){
    int steps = count.getSteps();
    if(steps == size){
      return true;
    }
    return false;
  }
  
  public static boolean fail(){
    System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    InputView inputView = new InputView();
    String temp = inputView.readGameCommand();
    if(temp.equals("Q")){
      return false;
    }
    return true;
  }
}
