package bridge.controller;

import static bridge.domain.BridgeGame.generateBridge;
import static bridge.domain.BridgeGame.move;
import static bridge.domain.BridgeGame.retry;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;
import bridge.domain.GameCommand;
import bridge.domain.SizeOfBridge;
import bridge.service.InputViewService;
import bridge.utils.Constants;
import bridge.view.OutputView;
import java.util.Objects;

public class BridgeGameController {

    private final OutputView outputView;
    private final InputViewService inputViewService;

    public BridgeGameController() {
        this.outputView = new OutputView();
        this.inputViewService = new InputViewService();
    }

    public void run() {
        printStartGame();
        Bridge bridge = set();
        restartGame(bridge, new BridgeGameResult());
    }

    private Bridge set() {
        SizeOfBridge sizeOfBridge = inputViewService.getReadBridgeSize();

        return generateBridge(sizeOfBridge);
    }

    private void playGame(Bridge bridge, BridgeGameResult bridgeGameResult) {
        startGame(bridge, bridgeGameResult);
        if (bridgeGameResult.isMissMatch()) {
            inputRestartGame(bridge, bridgeGameResult);
        }
    }

    private void startGame(Bridge bridge, BridgeGameResult bridgeGameResult) {
        for (String bridgeStep : bridge.getBridge()) {
            bridgeGameResult.append(move(bridgeStep, inputViewService.getReadMoving()));
            printMatchResult(bridgeGameResult);
            if (bridgeGameResult.isMissMatch()) {
                break;
            }
        }
        checkEndGame(bridgeGameResult, !bridgeGameResult.isMissMatch());
    }

    private void inputRestartGame(Bridge bridge, BridgeGameResult bridgeGameResult) {
        GameCommand gameCommand = inputViewService.getReadGameCommand();

        if (isRetry(bridgeGameResult, gameCommand)) {
            bridgeGameResult.setNumberOfRetries();
            restartGame(bridge, new BridgeGameResult(bridgeGameResult.getNumberOfRetries()));
        }
        checkEndGame(bridgeGameResult, Objects.equals(gameCommand.getGameCommand(), Constants.QUIT));
    }

    private void restartGame(Bridge bridge, BridgeGameResult bridgeGameResult) {
        playGame(bridge, bridgeGameResult);
    }

    private static boolean isRetry(BridgeGameResult bridgeGameResult, GameCommand gameCommand) {
        return bridgeGameResult.isMissMatch() && retry(gameCommand);
    }

    private void checkEndGame(BridgeGameResult bridgeGameResult, boolean end) {
        if (end) {
            showGameResult(bridgeGameResult);
        }
    }

    private void printStartGame() {
        outputView.printStartMessage();
    }

    private void printMatchResult(BridgeGameResult bridgeGameResult) {
        outputView.printMap(bridgeGameResult);
    }

    private void showGameResult(BridgeGameResult bridgeGameResult) {
        outputView.printGameResult(bridgeGameResult);
    }
}
