package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> bridge) {
      char[][] maps = initialMap(bridge.size());
      for(int idx = 0; idx < bridge.size(); idx++) {
        String input = new InputView().readMoving();
        makeMaps(maps, idx, input, bridge.get(idx));
        new OutputView().printMap(maps, idx);

      }
    }

  public char[][] initialMap(int size) {
    char[][] maps = new char[2][size];

    for(int idx = 0; idx < 2; idx++) {
      Arrays.fill(maps[idx], ' ');
    }
    return maps;
  }

  public void makeMaps(char[][] maps, int idx, String input, String ch) {
    if(ch.equals(input)) {
      if(ch.equals("U")) {
        maps[0][idx] = 'O';
      } else {
        maps[1][idx] = 'O';
      }
    } else {
      if(input.equals("U")) {
        maps[0][idx] = 'X';
      } else {
        maps[1][idx] = 'X';
      }
    }
  }

  /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
