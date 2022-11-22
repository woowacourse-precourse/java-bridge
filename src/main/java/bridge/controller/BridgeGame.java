package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.GameStatus;
import bridge.service.BridgeService;
import bridge.service.GameStatusService;
import bridge.service.MovedBridgeService;
import bridge.util.Command;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeService bridgeService = new BridgeService();
    private final MovedBridgeService movedBridgeService = new MovedBridgeService();
    private final GameStatusService gameStatusService = new GameStatusService();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param moveCommand
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        movedBridgeService.add(moveCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param gameCommand
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return gameCommand.equals(Command.GAME_RETRY_LETTER.getCommand());
    }

    public void setBridge(int readBridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(readBridgeSize);
        bridgeService.save(bridge);
    }

    public void reset() {
        resetMovedBridge();
        resetGameStatus();
    }

    private void resetMovedBridge() {
        movedBridgeService.reset();
    }
    private void resetGameStatus() {
        gameStatusService.reset();
    }

    public GameStatus getGameStatus() {
        return gameStatusService.find();
    }

    public boolean isFinish() {
        return gameStatusService.isFinish();
    }

    public boolean isResult() {
        return gameStatusService.isResult();
    }
}
