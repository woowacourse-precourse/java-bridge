package domain.player;

import domain.bridge.UserBridge;

import java.util.List;


public class Player {
  private int pick;
  private UserBridge userBridge;

  public Player () {
    this.pick = 0;
    this.userBridge = new UserBridge();
  }

  public void playerPick() {
    pick++;
    userBridge.setBridge();
  }

  public void isRightPick(boolean is_answer) {
    userBridge.printBridge(is_answer);
  }

  public int getPick() {
    return pick;
  }

  public List<String> getUserBridge() {
    return userBridge.getUserBridge();
  }
}
