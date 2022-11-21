package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
  private List<String> moveStatus;
  private int tryCount;

  public User() {
    this.moveStatus = new ArrayList<>();
    this.tryCount = 0;
  }

  public void move(String direction) {
    moveStatus.add(direction);
  }

  public boolean isCorrectlyMove(List<String> bridge) {
    final int index = moveStatus.size() - 1;
    if (index < 0) return true;
    return bridge.get(index).equals(moveStatus.get(index));
  }

  public void startNewGame() {
    this.tryCount++;
    this.moveStatus.clear();
  }

  public boolean isArriveFinishLine(int bridgeLength) {
    return bridgeLength == moveStatus.size();
  }

  public List<String> getMoveStatus() {
    return this.moveStatus;
  }

  public int getTryCount() {
    return this.tryCount;
  }
}
