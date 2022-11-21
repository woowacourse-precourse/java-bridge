package bridge.controller;

import static bridge.BridgeGame.generateBridge;
import static bridge.BridgeGame.move;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;
import bridge.domain.SizeOfBridge;
import bridge.utils.Constants;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Objects;

public class BridgeGameController {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.printStartMessage();
        Bridge bridge = set();
        playGame(bridge);
    }

    private Bridge set() {
        SizeOfBridge sizeOfBridge = inputView.readBridgeSize();

        return generateBridge(sizeOfBridge);
    }

    private void playGame(Bridge bridge) {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();

        startGame(bridge, bridgeGameResult);
        inputRestartGame(bridge, bridgeGameResult);
    }

    private void startGame(Bridge bridge, BridgeGameResult bridgeGameResult) {
        for (String bridgeStep : bridge.getBridge()) {
            bridgeGameResult.append(move(bridgeStep, inputView.readMoving()));
            outputView.printMap(bridgeGameResult);
            if (bridgeGameResult.isMissMatch()) {
                break;
            }
        }
    }

    private void inputRestartGame(Bridge bridge, BridgeGameResult bridgeGameResult) {
        if (bridgeGameResult.isMissMatch() && isGameCommandRestart()) {
            playGame(bridge);
        }
    }

    private boolean isGameCommandRestart() {
        return Objects.equals(inputView.readGameCommand().getGameCommand(), Constants.RESTART);
    }
}
