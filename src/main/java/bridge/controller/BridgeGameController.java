package bridge.controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.constant.GameKeyboard.*;

public class BridgeGameController {
    public static final int INIT_BRIDGE_POSITION_INDEX = 0;
    public static final int NEXT_INDEX = 1;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void play() {
        outputView.printGameStart();
        List<String> bridge = makeRandomBridge();
        int bridgePositionIndex = INIT_BRIDGE_POSITION_INDEX;

        BridgeGame bridgeGame = guessCorrectBridge(bridge, bridgePositionIndex);

        outputView.printResult(bridgeGame);
    }

    private List<String> makeRandomBridge() {
        int bridgeSizeInput = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSizeInput);
        return bridge;
    }

    private BridgeGame guessCorrectBridge(List<String> bridge, int bridgePositionIndex) {
        BridgeGame bridgeGame = new BridgeGame();
        while (bridgePositionIndex < bridge.size()) {
            String moving = inputView.readMoving();
            bridgeGame.move(new Bridge(bridge.get(bridgePositionIndex), moving));
            outputView.printMap(bridgeGame, bridgePositionIndex);
            bridgePositionIndex = getBridgePositionIndex(bridgePositionIndex, bridgeGame, bridge);
        }
        return bridgeGame;
    }

    private int getBridgePositionIndex(int bridgePositionIndex, BridgeGame bridgeGame, List<String> bridge) {
        if (isCorrectAnswerBridge(bridgeGame)) {
            bridgePositionIndex = getNextBridgePositionIndex(bridgePositionIndex);
        }
        if (isWrongAnswerBridge(bridgeGame)) {
            bridgePositionIndex = chooseRestartOrQuitIndex(bridgePositionIndex, bridgeGame, bridge);
        }
        return bridgePositionIndex;
    }

    private int chooseRestartOrQuitIndex(int bridgePositionIndex, BridgeGame bridgeGame, List<String> bridge) {
        String restartMessage = inputView.readGameCommand();
        if (isSelectedRestart(restartMessage)) {
            bridgePositionIndex = getBackRestartIndex(bridgePositionIndex, bridgeGame);
        }
        if (isSelectedQuit(restartMessage)) {
            bridgePositionIndex = getBridgeSizeIndex(bridgeGame, bridge, restartMessage);
        }
        return bridgePositionIndex;
    }

    private static boolean isSelectedQuit(String restartMessage) {
        return restartMessage.equals(QUIT.letter());
    }

    private static boolean isSelectedRestart(String restartMessage) {
        return restartMessage.equals(RESTART.letter());
    }

    private int getBridgeSizeIndex(BridgeGame bridgeGame, List<String> bridge, String restartMessage) {
        int bridgePositionIndex;
        outputView.printResult(restartMessage, bridgeGame.getAttemptCount());
        bridgePositionIndex = bridge.size();
        return bridgePositionIndex;
    }

    private static int getNextBridgePositionIndex(int bridgePositionIndex) {
        bridgePositionIndex = bridgePositionIndex + NEXT_INDEX;
        return bridgePositionIndex;
    }

    private static boolean isWrongAnswerBridge(BridgeGame bridgeGame) {
        List<String> myAnswerBridges = bridgeGame.getMyAnswerBridges();
        return myAnswerBridges.contains(WRONG_ANSWER.letter());
    }

    private static boolean isCorrectAnswerBridge(BridgeGame bridgeGame) {
        List<String> myAnswerBridges = bridgeGame.getMyAnswerBridges();
        return !myAnswerBridges.contains(WRONG_ANSWER.letter());
    }

    private int getBackRestartIndex(int bridgePositionIndex, BridgeGame bridgeGame) {
        outputView.retryBridgeMap();
        bridgeGame.retry();
        bridgePositionIndex = INIT_BRIDGE_POSITION_INDEX;
        return bridgePositionIndex;
    }
}
