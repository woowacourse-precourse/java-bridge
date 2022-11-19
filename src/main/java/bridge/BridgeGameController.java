package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.utils.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private BridgeGame game;
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGameController() {
        this.game = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static BridgeGameController init() {
        return new BridgeGameController();
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다"); // 위치 여기가 맞을까?
        Bridge bridge = this.makeBridge();
    }

    private Bridge makeBridge() {
        try {
            Integer bridgeSize = inputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e ) {
            return makeBridge();
        }
    }
}
