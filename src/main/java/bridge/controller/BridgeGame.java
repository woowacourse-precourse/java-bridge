package bridge.controller;

import bridge.domain.BridgeGameStatus;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.domain.GameCommand.QUIT;
import static bridge.domain.GameCommand.RESTART;
import static bridge.exception.ExceptionType.INPUT_WRONG_COMMAND;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final List<String> playerMove = new ArrayList<>();
    private List<String> gameBridge;
    private int runCount;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        runCount = 0;
    }

    public BridgeGameStatus getBridgeGameStatus() {
        return new BridgeGameStatus(playerMove, gameBridge, runCount);
    }

    /**
     * 게임 시작 직후 다리를 생성할 때 사용하는 메서드
     * @param bridgeSize
     */
    public void initialize(int bridgeSize) {
        gameBridge = bridgeMaker.makeBridge(bridgeSize);
    }
    
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param moving
     * <p>입력 받은 Moving 객체의 방향을 playerMove 변수에 추가한다</p>
     */
    public void move(Moving moving) {
        playerMove.add(moving.getDirection());
    }
    
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param retryCommand
     * @return
     * <p>RESTART : return true</p>
     * <p>QUIT : false</p>
     */
    public boolean retry(GameCommand retryCommand) {
        if (retryCommand == RESTART) {
            playerMove.clear();
            return true;
        }
        if (retryCommand == QUIT) return false;
        throw new IllegalArgumentException(INPUT_WRONG_COMMAND.getMessage());
    }

    public void addRunCount() {
        this.runCount++;
    }

    public boolean canMoveContinue() {
        if (isMoveEnd()) return false;
        if (isMoveFail()) return false;
        return true;
    }

    private boolean isMoveEnd() {
        return playerMove.size() == gameBridge.size();
    }

    private boolean isMoveFail() {
        final int moveIndex = playerMove.size() - 1;
        return !Objects.equals(gameBridge.get(moveIndex), playerMove.get(moveIndex));
    }
}
