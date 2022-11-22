package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> movement;
    private int tried;

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.movement = new ArrayList<>();
        this.tried = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        movement.add(input);
    }

    public String[] getMapLines() {
        String upLine = makeLineOfMap("U");
        String downLine = makeLineOfMap("D");

        return new String[]{upLine, downLine};
    }

    private String makeLineOfMap(String lineUpOrDown) {
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<movement.size(); i++) {
            String checker = UpDownChecker.fromConditions(bridge.get(i), movement.get(i), lineUpOrDown).getChecker();
            sb.append(checker).append("|");
        }

        if (sb.toString().length() == 1) { sb.append("["); } // bridge가 비었을 때 출력 깔끔하게
        return sb.substring(0, sb.length()-1) + "]";
    }

    public boolean roundOver() {
        List<String> subBridge = bridge.subList(0, movement.size());
        return winTheGame() || !subBridge.equals(movement);
    }

    public boolean winTheGame() {
        return !bridge.isEmpty() && bridge.equals(movement);
    }

    public int getTried() {
        return tried;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (!command.equals("R")) {
            return false;
        }

        movement.clear();
        tried += 1;
        return true;
    }
}
