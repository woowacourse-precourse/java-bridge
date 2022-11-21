package bridge;

import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge computerBridge;

    BridgeGame(Bridge computerBridge) {
        this.computerBridge = computerBridge;
    }

    public void playStart() {
        int tryCounts = BridgeValue.getTryCounts();
        Bridge nextBridge = move(new Bridge(new ArrayList<>()));

        if (!checkMoveAble(nextBridge)) {
            retry(nextBridge, tryCounts);
            return;
        }
        play(nextBridge, tryCounts);
    }

    public void play(Bridge userBridge, int tryCounts) {

        Bridge nextBridge = move(userBridge);
        if (!checkMoveAble(nextBridge)) {
            retry(nextBridge, tryCounts);
            return;
        }
        if (computerBridge.checkSuccess(nextBridge)) {
            draw(nextBridge, tryCounts);
            return;
        }
        play(nextBridge, tryCounts);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private Bridge move(Bridge userBridge) {
        return computerBridge.move(userBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry(Bridge userBridge, int tryCounts) {

        boolean isRetry = checkRetry(userBridge);

        if (isRetry) {
            userBridge.removeLastState();
            play(userBridge, tryCounts+1);
            return;
        }
        draw(userBridge, tryCounts);
    }

    private void draw(Bridge userBridge, int tryCounts) {
        computerBridge.drawResult(userBridge, tryCounts);
    }

    private boolean checkMoveAble(Bridge userBridge) {
        int lastIndex = userBridge.getLastIndex();
        boolean checkMoveAble = computerBridge.compareStates(lastIndex, userBridge);
        return checkMoveAble;
    }

    private boolean checkRetry(Bridge userBridge) {
        return userBridge.checkRetry();
    }
}
