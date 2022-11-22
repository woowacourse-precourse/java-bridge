package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    int trialCount = 0;
    List<String> bridge = new ArrayList<>();
    List<String> userInput = new ArrayList<>();


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userMovement) {
        this.userInput.add(userMovement);

        for (int i = 0; i < this.userInput.size(); i++) {
            if (!userInput.get(i).equals(this.bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.trialCount++;
        this.userInput.clear();
    }

    public void initBridge(int size) {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<String> getUserInput() {
        return this.userInput;
    }

    public int getTrialCount() {
        return this.trialCount;
    }
}
