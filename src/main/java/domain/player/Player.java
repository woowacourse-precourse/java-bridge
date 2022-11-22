package domain.player;

import domain.bridge.UserBridge;
import domain.bridge.view.InputView;

public class Player {
  private int pick;
  private UserBridge userBridge;

  public Player () {
    this.pick = 0;
    this.userBridge = new UserBridge();
  }

  public void playerPick() {
//    pick++;
    userBridge.setBridge();
  }

  public void isRightPick(boolean is_answer) {
    userBridge.printBridge(is_answer);
  }

  public int getPick() {
    return pick;
  }

  public UserBridge getUserBridge() {
    return userBridge;
  }

  public String wantRetry() {
    InputView inputView = new InputView();

    System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    return inputView.readGameCommand();
  }
}
