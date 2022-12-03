package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.constant.Constant.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public List<List<String>> bridges;

    public BridgeGame() {
        this.bridges = List.of(new ArrayList<>(), new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String direction, String answer) {
        String result = addOorX(direction, answer);
        if(direction.equals(UP.getValue())) {
            bridges = bridgeUp(bridges, result);
            return bridges;
        }
        bridges = bridgeDown(bridges, result);
        return bridges;
    }

    public List<List<String>> bridgeUp(List<List<String>> bridges, String result) {
        List<String> bridgeUp = bridges.get(0);
        List<String> bridgeDown = bridges.get(1);

        bridgeUp.add(result);
        bridgeDown.add(BLANK.getValue());

        return bridges;
    }

    public List<List<String>> bridgeDown(List<List<String>> bridges, String result) {
        List<String> bridgeUp = bridges.get(0);
        List<String> bridgeDown = bridges.get(1);

        bridgeUp.add(BLANK.getValue());
        bridgeDown.add(result);

        return bridges;
    }

    public String addOorX(String direction, String answer) {
        if(direction.equals(answer)) {
            return O.getValue();
        }
        return X.getValue();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(int attempt, String quit) {
        if(quit.equals(RESTART.getValue())) {
            attempt++;
        }
        return attempt;
    }

    public void clearBridges() {
        this.bridges = List.of(new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (List<String> bridge : this.bridges) {
            sb.append("[");
            sb.append(bridgeToString(bridge));
            sb.append("]");
            sb.append("\n");
        }
        return sb.toString();
    }

    private String bridgeToString(List<String> bridge) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < bridge.size(); j++) {
            sb.append(" ").append(bridge.get(j)).append(" ");
            if (j < bridge.size() - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }
}
