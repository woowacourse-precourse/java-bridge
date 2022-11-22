package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

  int size;
  List<String> bridge;
  List<List<String>> currentBridge;
  int tryCount;
  GameState success = GameState.SUCCESS;

  final int UP = 0;
  final int DOWN = 1;

  /**
   * 필드 멤버 변수를 초기화하는 생성자
   * @param size
   * @param bridge
   */
  public BridgeGame(int size, List<String> bridge) {
    this.size = size;
    this.bridge = bridge;
    currentBridge = new ArrayList<>();
    for (int i = 0; i < 2; i++) {
      List<String> list = new ArrayList<>();
      for (int j = 0; j < size; j++) {
        list.add("   ");
      }
      currentBridge.add(list);
    }
    tryCount = 1;
  }

  public List<List<String>> getCurrentBridge() {
    return currentBridge;
  }

  public GameState getSuccess() {
    return success;
  }

  public int getTryCount() {
    return tryCount;
  }
  /**
   * 사용자가 칸을 이동할 때 사용하는 메서드
   * <p>
   * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public boolean move(int round, String cmd) {
    int index = getIndex(cmd);
    if (cmd.equals(bridge.get(round))) {
      currentBridge.get(index).set(round, " O ");
      return true;
    }
    currentBridge.get(index).set(round, " X ");
    success = GameState.FAIL;
    return false;
  }


  /**
   * cmd 문자열을 상수 0, 1 값으로 변환하는 메서드
   * @param cmd
   * @return
   */
  private int getIndex(String cmd) {
    if (cmd.equals("U")) {
      return UP;
    }
    return DOWN;
  }


  /**
   * 사용자가 게임을 다시 시도할 때 사용하는 메서드
   * <p>
   * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void retry() {
    tryCount++;
    success = GameState.SUCCESS;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < size; j++) {
        currentBridge.get(i).set(j,"   ");
      }
    }
  }
}
