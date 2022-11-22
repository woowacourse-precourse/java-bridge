package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> bridge;
    List<String> userInput;
    int attempts;
    int nextLocation;
    GameStatus type;

    enum GameStatus {
        실패, 성공, 진행중
    }

    /**
     * 게임을 처음 시작할 때 사용하는 메서드
     */
    public void init(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
        userInput = new ArrayList<>();
        attempts = 1;
        nextLocation = 0;
        type = GameStatus.진행중;
    }

    /**
     * 사용자가 이동한 칸이 움직일 수 있는 칸인지 확인할 때 사용하는 메서드
     */
    public boolean isMovable(String command) {
        return command.equals(bridge.get(nextLocation));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        userInput.add(command);
        if (isMovable(command)) {
            nextLocation++;
            updateStatus();
            return;
        }
        type = GameStatus.실패;
    }

    public void updateStatus() {
        if (nextLocation == bridge.size()) {
            type = GameStatus.성공;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        if (command.equals("R")) {
            userInput = new ArrayList<>();
            attempts++;
            nextLocation = 0;
            type = GameStatus.진행중;
            return;
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(renderUpperRow(bridge, userInput));
        sb.append(renderLowerRow(bridge, userInput));
        return sb.toString();
    }

    public String renderUpperRow(List<String> bridge, List<String> userInput) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < userInput.size(); i++) {
            sb.append(getUpperRowElem(bridge, userInput, i));
            if (i != userInput.size() - 1) sb.append("|");
        }
        sb.append("]\n");
        return sb.toString();
    }

    public String getUpperRowElem(List<String> bridge, List<String> userInput, int index) {
        if (bridge.get(index).equals("U") && userInput.get(index).equals("U")) {
            return " O ";
        }
        if (bridge.get(index).equals("D") && userInput.get(index).equals("U")) {
            return " X ";
        }
        return "   ";
    }

    public String renderLowerRow(List<String> bridge, List<String> userInput) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < userInput.size(); i++) {
            sb.append(getLowerRowElem(bridge, userInput, i));
            if (i != userInput.size() - 1) sb.append("|");
        }
        sb.append("]\n");
        return sb.toString();
    }

    public String getLowerRowElem(List<String> bridge, List<String> userInput, int index) {
        if (bridge.get(index).equals("D") && userInput.get(index).equals("D")) {
            return " O ";
        }
        if (bridge.get(index).equals("U") && userInput.get(index).equals("D")) {
            return " X ";
        }
        return "   ";
    }
}
