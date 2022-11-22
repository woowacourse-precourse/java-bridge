package bridge.controller;

import bridge.domain.Attempt;
import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Status;
import bridge.service.BridgeGameService;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private final Attempt attempt;
    private final BridgeGameService bridgeGameService;

    public BridgeGame() {
        attempt = new Attempt();
        bridgeGameService = new BridgeGameService();
    }

    /**
    * 게임 진행을 위한 초기화 시 사용하는 메서드
    * */
    public void start() {
        bridge = new Bridge(bridgeGameService.initializeGame());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * @return Status
     */
    public Status move() {
        attempt.increase();
        return Status.of(bridgeGameService.proceedGame(bridge));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * @return Command
     */
    public Command retry() {
        return Command.of(bridgeGameService.restartGame());
    }

    /**
    * 사용자가 게임을 종료하는 경우 최종 결과를 출력할 때 사용하는 메서드
    * */
    public void finish(Status status) {
        bridgeGameService.printResult(status, bridge, attempt);
    }
}
