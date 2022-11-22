package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeState;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameMachine {
    private static final String FAILURE = "X";
    private static final String EMPTY_VALUE = "";

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int bridgeLength = bridgeSizeInput();
        List<String> designBridge = randomBridge(bridgeLength);

        BridgeGame bridgeGame = new BridgeGame(designBridge);
        playBridgeGame(bridgeGame);

        outputView.printResult(bridgeGame);
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        String playerRetry = EMPTY_VALUE;

        while (bridgeGame.isNotGameEnd(playerRetry)) {
            String bridgeJudgment = playerBridgeAddAndCurrentStatus(bridgeGame);
            playerRetry = bridgeFailureCases(bridgeGame, playerRetry, bridgeJudgment);
        }
    }

    private String bridgeFailureCases(BridgeGame bridgeGame,
            String playerRetry, String bridgeJudgment) {

        if (bridgeJudgment.equals(FAILURE)) {
            String gameCommand = bridgeRestartAndEndInput();
            playerRetry = bridgeGame.retry(gameCommand);
            bridgeGame.restartOrQuit(playerRetry);
        }
        return playerRetry;
    }

    private String bridgeRestartAndEndInput() {
        return inputView.inputGameCommand();
    }

    private String playerBridgeAddAndCurrentStatus(BridgeGame bridgeGame) {
        String bridgeJudgment = addPlayerBridge(bridgeGame);
        BridgeState bridgePlace = bridgeGame.currentBridgeState();

        outputView.printMap(bridgePlace);
        outputView.printNextLine();
        return bridgeJudgment;
    }

    private String addPlayerBridge(BridgeGame bridgeGame) {
        String playerMoving = bridgeMovingInput();
        String bridgeJudgment = bridgeGame.judgment(playerMoving);

        bridgeGame.addJudgment(playerMoving, bridgeJudgment);
        bridgeGame.move();

        return bridgeJudgment;
    }

    private int bridgeSizeInput() {
        outputView.printGameStartMessage();
        int bridgeLength = inputView.inputBridgeSize();

        outputView.printNextLine();
        return bridgeLength;
    }

    private List<String> randomBridge(int bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeLength);
    }

    private String bridgeMovingInput() {
        return inputView.inputMoving();
    }
}