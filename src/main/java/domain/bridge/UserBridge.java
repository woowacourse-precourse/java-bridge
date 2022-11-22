package domain.bridge;

import domain.bridge.view.InputView;
import domain.bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class UserBridge implements Bridge {
  private List<String> user_bridge;
  boolean is_answer;

  public UserBridge () {
    user_bridge = new ArrayList<>();
  }

  @Override
  public void setBridge() {
    InputView inputView = new InputView();

    System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    addUserBridge(inputView.readMoving());
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
