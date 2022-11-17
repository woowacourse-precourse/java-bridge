package bridge.domain;

import bridge.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> randomBridge;
    public List<String> passHistory;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGame (List<String> randomBridge) {
        this.randomBridge = randomBridge;
        this.passHistory = new ArrayList<>();
    }

    public boolean move(String choiceUpAndDown) {
        clearBridge();

        if (!canPass(choiceUpAndDown)) return retry();

        if (passHistory.size() == randomBridge.size()) {
            Application.outcome = true;
            return false;
        }

        return true;
    }

    private void clearBridge() {

        if (passHistory.contains("DX") || passHistory.contains("UX")) {
            passHistory.clear();
        }
    }

    private boolean canPass (String choiceUpAndDown) {
        this.passHistory.add(choiceUpAndDown);

        return randomBridge.get(passHistory.size()-1).equals(choiceUpAndDown);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        Application app = new Application();
        Application.outcome = false;
        Application.attempt += 1;

        addFailTrace();

        return app.selectRetry(passHistory);
    }

    private void addFailTrace () {

        if(passHistory.get(passHistory.size()-1).equals("U")) {
            passHistory.set(passHistory.size()-1, "UX");
        }

        if(passHistory.get(passHistory.size()-1).equals("D")) {
            passHistory.set(passHistory.size()-1, "DX");
        }
    }
}
