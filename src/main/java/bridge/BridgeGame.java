package bridge;

import bridge.repository.BridgeInfo;
import bridge.repository.BridgeResultData;
import bridge.repository.MovingData;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RIGHT_ANSWER = "O";
    private static final String WRONG_ANSWER = "X";
    private static final String NOT_CHOSEN = " ";
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private final List<String> bridge;

    public BridgeGame(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public static String getRetryCommand() {
        return RETRY_COMMAND;
    }

    public static String getQuitCommand() {
        return QUIT_COMMAND;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        MovingData.add(moving);
        BridgeResultData.add(
                convertMovingToAnswer(moving, BridgeInfo.UP_BRIDGE.getLetter()),
                convertMovingToAnswer(moving, BridgeInfo.DOWN_BRIDGE.getLetter())
        );
    }

    private String convertMovingToAnswer(String moving, String bridgeSide) {
        if (!isLose(moving) && moving.equals(bridgeSide)) {
            return RIGHT_ANSWER;
        }
        if (isLose(moving) && moving.equals(bridgeSide)) {
            return WRONG_ANSWER;
        }
        return NOT_CHOSEN;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        MovingData.resetLastMove();
        BridgeResultData.resetLastMove();
    }

    public boolean readRetry(String input) {
        return input.equals(RETRY_COMMAND);
    }

    /**
     * 사용자가 게임을 종료할 때 사용하는 메서드
     */
    public void quit() {
        BridgeResultData.reset();
        MovingData.reset();
    }

    /**
     * 게임 승리 여부를 확인할 때 사용하는 메서드
     */
    public boolean isLose(String moving) {
        return !bridge.get(MovingData.getLastIndex()).equals(moving);
    }

    public boolean isWin(String moving) {
        return !isLose(moving) && bridge.size() == MovingData.getSize();
    }
}
