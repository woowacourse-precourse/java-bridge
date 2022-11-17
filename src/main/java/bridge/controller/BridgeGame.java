package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeFlag;
import bridge.domain.Map;
import bridge.domain.User;
import bridge.service.BridgeService;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeService bridgeService;

    public BridgeGame(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public static BridgeGame create(BridgeService bridgeService) {
        return new BridgeGame(bridgeService);
    }

    public void start() {
        bridgeService.printStartMessage();
        Bridge bridge = bridgeService.makeBridge();
        User user = new User();
        Map map = new Map();
        System.out.println(bridge.getBridge()); // TEST
        while (true) {

            user.move(bridgeService.receiveMoving());
            map.update(bridge, user);
            BridgeFlag gameStatus = bridgeService.getGameStatus(bridge, user);
            bridgeService.printMap(map);
            if (gameStatus != BridgeFlag.NOTHING) {
                break;
            }
        }
        System.out.println("게임 종료");
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
