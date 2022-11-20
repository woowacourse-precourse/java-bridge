package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputMaker inputMaker;
    private final OutputMaker outputMaker;

    public BridgeGame(InputMaker inputMaker, OutputMaker outputMaker) {
      this.inputMaker = inputMaker;
      this.outputMaker = outputMaker;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, int cnt) {
      char[][] maps = initialMap(bridge.size());
      for(int idx = 0; idx < bridge.size(); idx++) {
        makeMaps(maps, idx, bridge.get(idx));
        if(maps[0][idx] == 'X' || maps[1][idx] == 'X') {
          return retry(bridge, maps, idx, cnt);
        }
      }
      outputMaker.printResult(maps, bridge.size() - 1, true, cnt);
      return true;
    }

    public char[][] initialMap(int size) {
      char[][] maps = new char[2][size];

      for(int idx = 0; idx < 2; idx++) {
        Arrays.fill(maps[idx], ' ');
      }
      return maps;
    }

    public void makeMaps(char[][] maps, int idx, String ch) {
      String input = inputMaker.readMove();
      if(ch.equals(input)) {
        makeO(maps, input, idx);
      }
      if(!ch.equals(input)) {
        makeX(maps, input, idx);
      }
      outputMaker.printMap(maps, idx);
    }

    public void makeX(char[][] maps, String input, int idx) {
      if(input.equals("U")) {
        maps[0][idx] = 'X';
        return;
      }
      maps[1][idx] = 'X';
    }

    public void makeO(char[][] maps, String input, int idx) {
      if(input.equals("U")) {
        maps[0][idx] = 'O';
        return;
      }
      maps[1][idx] = 'O';
    }

  /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(List<String> bridge, char[][] maps, int idx, int cnt) {
      String comm = inputMaker.readRetry();
      if(comm.equals("R")) {
        return move(bridge, cnt + 1);
      }
      outputMaker.printResult(maps, idx, false, cnt);
      return false;
    }
}
