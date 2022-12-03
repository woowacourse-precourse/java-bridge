package bridge.controller;

import bridge.domain.Bridge;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 게임을 시작한다. 길이를 입력받고 그 길이만큼 다리를 만든다.
 */
public class GameStart {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    /**
     * 게임을 시작한다. 길이를 입력받고 그 길이만큼 다리를 만든다.
     *
     * @param bridgeMaker
     * @return 랜덤으로 만들어진 다리
     */
    public static Bridge gameStart(BridgeMaker bridgeMaker) {
        outputView.printStart();
        while (true) {
            try {
                return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
