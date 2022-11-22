package domain.bridge;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static constant.ApplicationMessage.PUT_MOVE;

public class UserBridge implements Bridge {
  private List<String> user_bridge;
  boolean is_answer;

  public UserBridge () {
    user_bridge = new ArrayList<>();
  }

  @Override
  public void setBridge() {
    InputView inputView = new InputView();

    System.out.println(PUT_MOVE);
    try {
      addUserBridge(inputView.readMoving());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      throw new IllegalArgumentException();
    }
  }

  private void addUserBridge(String move) {
    user_bridge.add(move);
  }

  public void printBridge(boolean is_answer) {
    OutputView outputView = new OutputView();
    this.is_answer = is_answer;

    outputView.printMap(user_bridge, is_answer);
  }

  public List<String> getUserBridge() {
    return user_bridge;
  }

  public boolean getIsAnswer() {
    return is_answer;
  }
}
