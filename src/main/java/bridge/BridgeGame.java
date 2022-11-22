package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * InputView, OutputView를 사용할 수 없다.
 */
public class BridgeGame {

    private List<String> answerBridge;
    private int tries; // 시도
    private int bridgeLen; // 다리 길이
    private BridgeMaker constructor;

    BridgeGame() {
        answerBridge = new ArrayList<>();
        tries = 0;
        bridgeLen = 0;
        constructor = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public int getTries() {
        return tries;
    }

    public int getBridgeLen() {
        return bridgeLen;
    }

    public void setBridgeLen(int input) {
        this.bridgeLen = input;
    }

    public List<String> getAnswerBridge() {
        return answerBridge;
    }

    public void setAnswerBridge() {
        constructor.makeBridge(bridgeLen);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }
}