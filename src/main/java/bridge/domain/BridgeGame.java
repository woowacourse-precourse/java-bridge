package bridge.domain;

import bridge.constants.Command;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String SUCCESS = "O";
    private static final String FAILURE = "X";

    private static final int GAME_INITIAL_VALUE = 1;
    private static final int START_BRIDGE = 0;

    private final BridgeState bridgeState = new BridgeState();
    private final List<String> designBridge;

    private int gameCount = GAME_INITIAL_VALUE;
    private int bridgeIndex = START_BRIDGE;
    private boolean gameSuccess = true;

    public BridgeGame(List<String> designBridge) {
        this.designBridge = designBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type),
     * 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다. BridgeGame 클래스에서
     * InputView, OutputView 를 사용하지 않는다.
     */
    public void move() {
        bridgeIndex++;
    }

    public void addJudgment(String playerMoving, String judgement) {
        bridgeState.addBridge(playerMoving, judgement);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type),
     * 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry(String gameCommand) {
        if (gameCommand.equals(Command.RE_START.relevantCommand())) {
            bridgeState.reset();
            return Command.RE_START.relevantCommand();
        }
        return gameCommand;
    }

    public String judgment(String playerMoving) {
        if (playerMoving.equals(designBridge.get(bridgeIndex))) {
            return SUCCESS;
        }
        return FAILURE;
    }

    public void restartOrQuit(String playerRetry) {
        if (playerRetry.equals(Command.RE_START.relevantCommand())) {
            bridgeIndex = START_BRIDGE;
            gameCount++;
            return;
        }
        gameSuccess = false;
    }

    public boolean isNotGameEnd(String playerRetry) {
        return !playerRetry.equals(Command.END.relevantCommand())
                && bridgeIndex < designBridge.size();
    }

    public int totalGameCount() {
        return gameCount;
    }

    public BridgeState currentBridgeState() {
        return bridgeState;
    }

    public boolean determiningSuccess() {
        return gameSuccess;
    }
}