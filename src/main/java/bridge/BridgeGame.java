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
    private final List<String> bridge;

    public BridgeGame(InputMaker inputMaker, OutputMaker outputMaker, List<String> bridge) {
      this.inputMaker = inputMaker;
      this.outputMaker = outputMaker;
      this.bridge = bridge;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int cnt) {
      List<List<String>> maps = initialMap();
      for(int idx = 0; idx < bridge.size(); idx++) {
        makeMaps(maps, bridge.get(idx));
        if(maps.get(0).get(idx).equals("X") || maps.get(1).get(idx).equals("X")) {
          return retry(maps, cnt);
        }
      }
      outputMaker.printResult(maps, true, cnt);
      return true;
    }

    public List<List<String>> initialMap() {
      List<List<String>> maps = new ArrayList<>();

      maps.add(new ArrayList<>());
      maps.add(new ArrayList<>());
      return maps;
    }

    public void makeMaps(List<List<String>> maps, String ch) {
      String input = inputMaker.readMove();
      if(ch.equals(input)) {
        makeO(maps, input);
      }
      if(!ch.equals(input)) {
        makeX(maps, input);
      }
      outputMaker.printMap(maps);
    }

    public void makeX(List<List<String>> maps, String input) {
      if(input.equals("U")) {
        maps.get(0).add("X");
        maps.get(1).add(" ");
        return;
      }
      maps.get(1).add("X");
      maps.get(0).add(" ");
    }

    public void makeO(List<List<String>> maps, String input) {
      if(input.equals("U")) {
        maps.get(0).add("O");
        maps.get(1).add(" ");
        return;
      }
      maps.get(1).add("O");
      maps.get(0).add(" ");
    }

  /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(List<List<String>> maps, int cnt) {
      String comm = inputMaker.readRetry();
      if(comm.equals("R")) {
        return move(cnt + 1);
      }
      outputMaker.printResult(maps, false, cnt);
      return false;
    }
}
