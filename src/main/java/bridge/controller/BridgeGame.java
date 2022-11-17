package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.Map;
import bridge.domain.User;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeService bridgeService;

    public BridgeGame(InputView inputView, OutputView outputView, BridgeService bridgeService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeService = bridgeService;
    }

    public static BridgeGame create(InputView inputView, OutputView outputView, BridgeService bridgeService) {
        return new BridgeGame(inputView, outputView, bridgeService);
    }

    public void start() {
        outputView.printGameStartMessage();
        outputView.printEnterBridgeLength();
        Bridge bridge = bridgeService.makeBridge(inputView.readBridgeSize());
        User user = new User();
        Map map = new Map();
        System.out.println(bridge.getBridge()); // TEST
        while (true) {
            if (bridge.isCrossOver(user)) {
                break;
            }
            outputView.printEnterSelectMoving();
            user.move(inputView.readMoving());
            map.cross(bridge, user);
            outputView.printMap(map);
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
