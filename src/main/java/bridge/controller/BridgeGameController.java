package bridge.controller;

import static bridge.command.GameCommand.*;
import static bridge.util.Constant.*;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.View;
import java.util.List;

public class BridgeGameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private String userInput;

    public BridgeGameController(View view, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = view.getInputView();
        this.outputView = view.getOutputView();
        this.bridgeGame = bridgeGame;
    }

    // 게임을 최종적으로 진행하는 기능
    public void run() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        playGame(bridge);
    }


}