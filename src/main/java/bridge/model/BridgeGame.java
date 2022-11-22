package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final int size;
    private final List<String> bridge;
    private final List<String> userMoveState = new ArrayList<>();
    private final List<Boolean> userResult = new ArrayList<>();
    private int currentPosition;
    private int tryCount = 1;

    public BridgeGame(int size) {
        this.size = size;
        this.bridge = bridgeFromUserInput();
        this.currentPosition = 0;
    }


    /**
     * 다리 만들기
     */
    public List<String> bridgeFromUserInput() {
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        return bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserMoveState() {
        return userMoveState;
    }

    public List<Boolean> getUserResult() {
        return userResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userInput) {
        boolean moveResult = userInput.equals(bridge.get(currentPosition));
        userResult.add(moveResult);
        userMoveState.add(userInput + "_" + moveResult);
        currentPosition += 1;
        if (currentPosition == size) {
            return false;
        }
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if (userInput.equals("R")) {
            tryCount += 1;
            currentPosition -= 1;
            userResult.remove(currentPosition);
            userMoveState.remove(currentPosition);
            return true;
        }
        return false;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isGameOver() {
        return currentPosition >= size - 1 && userResult.get(currentPosition - 1);
    }


}
