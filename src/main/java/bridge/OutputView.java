package bridge;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    List<String> trialMap_down = BridgeGame.trialMap_down;
    List<String> trialMap_up = BridgeGame.trialMap_up;
    List<String> recordUpTable = new ArrayList<>();
    List<String> recordDownTable = new ArrayList<>();

    public void startMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
