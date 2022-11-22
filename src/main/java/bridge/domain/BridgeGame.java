package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int currentPosition = 0;
    private int tryCount = 1;
    private List<String> userPath = new ArrayList<>();
    private List<Boolean> userPathAnswer = new ArrayList<>();
    private final Bridge bridge;

    public BridgeGame(int bridgeSize) {
        bridge = new Bridge(bridgeSize);
    }

    public boolean determineMove(String command) {
        if (compare(command)) {
            return move(command);
        }
        userPath.add(command);
        userPathAnswer.add(false);
        return false;
    }

    public boolean determineRetry(String command) {
        if (command.equals("R")) {
            return retry();
        }
        return false;
    }

    public boolean isEndPosition(int bridgeSize) {
        return currentPosition == bridgeSize;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String command) {
        System.out.println("BridgeGame.move()");
        userPath.add(command);
        userPathAnswer.add(true);
        currentPosition++;
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        userPath = new ArrayList<>();
        userPathAnswer = new ArrayList<>();
        currentPosition = 0;
        tryCount++;
        return true;
    }

    private boolean compare(String command) {
        return bridge.get(currentPosition).equals(command);
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public List<String> getUserPath() {
        return this.userPath;
    }

    public List<Boolean> getUserPathAnswer() {
        return this.userPathAnswer;
    }
}
