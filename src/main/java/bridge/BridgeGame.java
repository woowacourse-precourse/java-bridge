package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> userInput;
    private int retryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.userInput = new ArrayList<String>();
        retryCount = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserInput() {
        return userInput;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move) {
        this.userInput.add(move);
    }

    public boolean evaluateMove() {
        String answer = this.bridge.get(this.userInput.size() - 1);
        if (!answer.equals(this.userInput.get(this.userInput.size() - 1))) {
            return true;
        }
        return false;
    }

    public boolean isGameOn() {
        if (userInput.size() == 0) {
            return true;
        }
        if (userInput.get(userInput.size() - 1).equals("Q")) {
            return false;
        }
        if (userInput.size() == bridge.size()) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String input) {
        if (input.equals("R")) {
            userInput = new ArrayList<String>();
            retryCount++;
            return;
        }
        userInput.add("Q");
    }

    public String getGameResult() {
        String result = "";
        result += retryCount + ",";
        result += evaluateResult();

        return result;
    }

    private String evaluateResult() {
        if (userInput.get(userInput.size() - 1).equals("Q")) {
            return "실패";
        }
        return "성공";
    }

    public int getCurrentProgress() {
        return this.userInput.size();
    }

    public String getDirectionAt(int index) {
        return this.userInput.get(index);
    }

    public boolean compareAt(int index) {
        return this.userInput.get(index).equals(this.bridge.get(index));
    }
}
