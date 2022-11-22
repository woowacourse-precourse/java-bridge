package bridge.controller;

import bridge.domain.Bridge;
import bridge.service.BridgeService;
import bridge.service.GameService;
import bridge.service.RoundService;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private final GameService gameService;
    private final BridgeService bridgeService;
    private final RoundService roundService;

    public BridgeGame(GameService gameService, BridgeService bridgeService, RoundService roundService) {
        this.gameService = gameService;
        this.bridgeService = bridgeService;
        this.roundService = roundService;
    }

    public void start() {
        gameService.initializeGame();
        bridge = bridgeService.initializeBridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        for (int i = 0; i < bridge.getSize(); i++) {
            roundService.getMoving();
            if (!roundService.getResult(bridge)) {
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
    public boolean retry() {
        String command = gameService.pauseGame();
        if (command.equals("R")) {
            roundService.initializeRound();
            return true;
        }
        return false;
    }
}
