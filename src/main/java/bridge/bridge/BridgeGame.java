package bridge.bridge;

import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private List<String> bridge;
    private final List<String> userInput;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new ArrayList<>();
        this.userInput = new ArrayList<>();
    }

    /**
     * 다리를 생성하는 메서드입니다.
     * @param size 다리의 크기
     */
    public void makeBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드입니다.
     * @param direction 사용자가 입력한 방향
     */
    public void move(String direction) {
        userInput.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        userInput.clear();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserInput() {
        return userInput;
    }
}
