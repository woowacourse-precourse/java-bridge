package bridge.controller;

import bridge.domain.Command;
import bridge.domain.Result;
import bridge.service.BridgeGameService;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameService service;

    public BridgeGame(BridgeGameService service) {
        this.service = service;
    }

    /**
     * 게임을 시작할 때 및 전체적인 게임을 진행하는 메서드
     */
    public void start() {
        service.start();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move() {
        return Result.of(service.move());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Command retry() {
        return Command.of(service.retry());
    }

    /**
     * 게임을 종료하고 최종 결과를 출력하는 메서드
     */
    public void finish() {
        service.finish();
    }
}
