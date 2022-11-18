package bridge;

import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeService bridgeService;

    public BridgeGame(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void run() {
        init();

        move();

    }

    public void init() {
        outputView.gameStart();
        Bridge bridge = createBridge();
        bridgeService = new BridgeService(bridge);
    }

    private Bridge createBridge() {
        outputView.inputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        outputView.inputPlayerMove();
        Movement playerMove = inputView.readMoving();
        boolean isSuccess =  bridgeService.movePlayer(playerMove);
        outputView.printMap(bridgeService.getResultCrossOver());
        return isSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
