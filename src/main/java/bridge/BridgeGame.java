package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> bridge;

    public BridgeGame(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }

    public BridgeGame(List<String> bridgeMaker) {
        bridge = bridgeMaker;
    }

    ArrayList<String> userInput = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean move(String choice) {
        userInput.add(choice);
        if (userInput.size() == bridge.size()) {
            return false;
        }
        if (bridge.get(userInput.size() - 1).equals(choice)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String> inputHistory() {
        List<String> moveHistory = new ArrayList<>();
        for (int i = 0; i < userInput.size(); i++) {
            moveHistory.add(returnResultValue(i));
        }
        return moveHistory;
    }

    public boolean isSuccess() {
        if (bridge.size() != userInput.size()) {
            return false;
        }
        String s = returnResultValue((userInput.size() - 1));
        if (s.equals("U") || s.equals("D")) {
            return true;
        }
        return false;
    }

    public String returnResultValue(int i) {
        if (userInput.get(i).equals(bridge.get(i))) {
            return userInput.get(i);
        }
        if (!userInput.get(i).equals(bridge.get(i)) && userInput.get(i).equals("U")) {
            return "UF";
        }
        return "DF";
    }

    public boolean isMoveFinish() {
        if (userInput.size() == 0)
            return false;
        if (userInput.size() == bridge.size())
            return true;
        if (!userInput.get(userInput.size() - 1).equals(bridge.get(userInput.size() - 1)))
            return true;
        return false;
    }

    public boolean retry(String command) {
        if (command.equals("R")) {
            userInput.clear();
            return true;
        }
        if (command.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

}
