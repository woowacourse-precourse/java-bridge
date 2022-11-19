package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final String correct = "O";
    public final String difference = " ";

    static int attempt = 1;
    static int bridgeIndex = 0;

    public List<String> upperBridge;
    public List<String> lowerBridge;

    BridgeGame() {
        upperBridge = new ArrayList<>();
        lowerBridge = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> rightBridgeWay, String inputMoveValue) {
        String answer = rightBridgeWay.get(bridgeIndex);

        makeProgressBridge(answer,inputMoveValue);
        bridgeIndex++;
    }

    public void makeProgressBridge(String answer, String inputMoveValue) {
        makeUpperBridge(answer, inputMoveValue);
        makeLowerBridge(answer, inputMoveValue);
    }

    public List<String> makeUpperBridge(String answer, String inputMoveValue) {
        if (inputMoveValue.equals("D")) {
            upperBridge.add(" ");
            return upperBridge;
        }
        upperBridge.add(compareValue(answer, inputMoveValue));

        return upperBridge;
    }

    public List<String> makeLowerBridge(String answer, String inputMoveValue) {
        if (inputMoveValue.equals("U")) {
            lowerBridge.add(" ");
            return lowerBridge;
        }
        lowerBridge.add(compareValue(answer, inputMoveValue));

        return lowerBridge;
    }

    public String compareValue(String answer, String movingValue) {
        if (answer.equals(movingValue)) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String inputReGame) {
        if (inputReGame.equals("R")) {
            bridgeIndex = 0;
            upperBridge = new ArrayList<>();
            lowerBridge = new ArrayList<>();
            attempt++;

            return true;
        }
        return false;
    }


}
