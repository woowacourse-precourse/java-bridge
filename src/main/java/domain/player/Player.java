package domain.player;

import bridge.UserBridge;
import view.InputView;

import static constant.ApplicationMessage.ASK_RETRY;

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

    System.out.println(ASK_RETRY);
    try {
      res = inputView.readGameCommand();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      throw new IllegalArgumentException();
    }
    return res;
  }
}
