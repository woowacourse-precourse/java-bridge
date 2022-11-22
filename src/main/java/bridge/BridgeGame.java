package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    final List<String> bridge;
    final List<String> movement;
    int tried;

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.movement = new ArrayList<>();
        this.tried = 0;
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

    private String makeLineOfMap(String UorD) {
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<movement.size(); i++) {
            if (!movement.get(i).equals( bridge.get(i) )) { // 일치하지 않으면 마지막 move
                sb.append(" X |");
                break;
            }
            if (movement.get(i).equals(UorD)) sb.append(" O ");
            if (!movement.get(i).equals(UorD)) sb.append("   "); // else 사용하면 더 깔끔함
            sb.append("|");
        }
        return sb.substring(0, sb.length()-1) + "]";
    }

    public boolean roundOver() {
        List<String> subBridge = bridge.subList(0, movement.size());
        if (!winTheGame() && subBridge.equals(movement) ) {
            return false;
        }

        return true;
    }

    public boolean winTheGame() {
        return bridge.equals(movement);
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
        return true;
    }
}
