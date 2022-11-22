package domain.player;

import domain.bridge.UserBridge;
import view.InputView;

public class Player {
  private UserBridge userBridge;

  public Player () {
    this.userBridge = new UserBridge();
  }

  public void playerPick() {
    userBridge.setBridge();
  }

  public void isRightPick(boolean is_answer) {
    userBridge.printBridge(is_answer);
  }

  public UserBridge getUserBridge() {
    return userBridge;
  }

  public String wantRetry() {
    InputView inputView = new InputView();
    String res;

    System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    try {
      res = inputView.readGameCommand();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      throw new IllegalArgumentException();
    }
    return res;
  }
}
