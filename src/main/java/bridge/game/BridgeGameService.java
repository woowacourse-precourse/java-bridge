package bridge.game;

import bridge.util.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 진행하는 클래스
 */
public class BridgeGameService {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    /**
     * 사용자로부터 이동할 칸을 입력 받는 메서드
     */
    public void getBridgeSize() {
        outputView.printStartGame();
        outputView.printAskBridgeLength();
        String bridgeSize = inputView.readBridgeSize();
        Validator.validateBridgeSize(bridgeSize);
    }

    /**
     * 다리 칸을 랜덤 생성하는 메서드
     */
    public void generateBridge() {

    }

}
