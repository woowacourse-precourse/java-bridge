package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println(GAME_START);

        Bridge answerBridge = makeAnswerBridge(bridgeMaker);
    }

    private Bridge makeAnswerBridge( BridgeMaker bridgeMaker) {
        Bridge answerBridge;
        try {
            answerBridge = setAnswerBridge(bridgeMaker);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            answerBridge = makeAnswerBridge(bridgeMaker);
        }
        return answerBridge;
    }

    private Bridge setAnswerBridge(BridgeMaker bridgeMaker) {
        int bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
