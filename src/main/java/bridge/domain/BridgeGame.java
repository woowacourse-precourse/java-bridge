package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.InputController;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    private final List<String> bridge;
    private final Player player;
    private int totalTry;

    public BridgeGame(int size) {
        bridge = bridgeMaker.makeBridge(size);
        player = new Player(bridge);
        totalTry = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        InputController.checkMove(player);
    }

    public void play() {
        do {
            move();
        } while (!player.isCompleted() && player.isSuccess());
        if (!player.isSuccess()) {
            retry();
            return;
        }
        if (player.isSuccess()) {
            complete();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String condition = InputController.checkGameCommend(player);
        if (condition.equals("R")) {
            play();
        }
        if (condition.equals("Q")) {
            complete();
        }
    }

    public void complete() {
        player.complete();
    }
}
