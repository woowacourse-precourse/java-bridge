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

    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(View view, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = view.getInputView();
        this.outputView = view.getOutputView();
        this.bridgeGame = bridgeGame;
    }

    private boolean isRetry(List<String> bridge, String userInput) {
        if (bridgeGame.checkGameSuccess(userInput, bridge).equals(SUCCESS)) {
            return false;
        }
        String replay = inputView.readGameCommand();
        if (replay.equals(Restart.getGameCommand())) {
            return true;
        }
        return false;
    }
}
