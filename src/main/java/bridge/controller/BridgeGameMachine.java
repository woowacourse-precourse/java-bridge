package bridge.controller;

import bridge.domain.BridgeRandomNumberGenerator;
import bridge.constants.Command;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeState;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameMachine {
    private static final String FAILURE = "X";
    private static final String EMPTY_VALUE = "";
    private static final int BRIDGE_LENGTH_CALCULATION = 1;

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
        playBridgeGame(bridgeGame);  // void -> BridgeGame (while)
        outputView.printResult(bridgeGame);
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        String playerRetry = EMPTY_VALUE;
        while (bridgeGame.isNotGameEnd(playerRetry)) {
            String bridgeJudgment = bridgeProgress(bridgeGame);

            if (bridgeJudgment.equals(FAILURE)) {
                String gameCommand = bridgeRestartAndEndInput();
                playerRetry = bridgeGame.retry(gameCommand);  // QUIT

                bridgeGame.restartOrQuit(playerRetry);
            }
        }
    }

    private String bridgeRestartAndEndInput() {
        outputView.printGameRestartEnd();
        return inputView.readGameCommand();
    }

    private String bridgeProgress(BridgeGame bridgeGame) {
        String playerMoving = bridgeMovingInput();  // U / D

        String bridgeJudgment = bridgeGame.judgment(playerMoving);  // "o"/"x"
        bridgeGame.addJudgment(playerMoving, bridgeJudgment);

        bridgeGame.move();
        BridgeState bridgePlace = bridgeGame.getBridgeState();
        outputView.printMap(bridgePlace);
        outputView.printNextLine();

        return bridgeJudgment;
    }

    private String bridgeMovingInput() {
        outputView.printMovementInput();
        return inputView.readMoving();
    }

    private List<String> randomBridge(int bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeLength);
    }

    private int bridgeSizeInput() {
        outputView.printGameStartMessage();
        outputView.printInputBridgeLength();

        int bridgeLength = inputView.readBridgeSize();

        outputView.printNextLine();
        return bridgeLength;
    }
}