package bridge;

import java.util.List;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final String CROSS_FAILED = "X";
    private static List<String> answerBridge;
    private static UsersBridgeCrossStatus userStatus;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void processGame() {
        int bridgeSize = getSize();
        makeBridges(bridgeSize);
        for (int round = 1; round < bridgeSize; round++) {
            outputView.printMessageToGetSpaceToMove();
            if (!processEachRound(round)) {
                retryOrQuit();
            }
        }
        outputView.printResult();
    }

    private static int getSize() {
        outputView.printInitialMessages();
        int bridgeSize = inputView.readBridgeSize();
        Validation.validateLength(bridgeSize);
        return bridgeSize;
    }

    private static void makeBridges(int bridgeSize) {
        BridgeMakerImpl bridgeMakerImpl = new BridgeMakerImpl();
        answerBridge = bridgeMakerImpl.makeAnswerBridge(bridgeSize);
        userStatus = bridgeMakerImpl.makeInitialBridge(bridgeSize);

    }

    private static boolean processEachRound(int round) {
        String selectedSpace = inputView.readMoving();
        String movingResult = bridgeGame.move(round, answerBridge, selectedSpace);
        userStatus.addCrossingResult(Space.getValueByRepresented(selectedSpace), round, movingResult);
        outputView.printMap(userStatus);
        if (movingResult.equals(CROSS_FAILED)) {
            return false;
        }
        return true;
    }

    private static void retryOrQuit() {
        outputView.printMessageAfterFailure();
        String retryOrQuit = inputView.readGameCommand();
        Validation.validateResponseAfterFailure(retryOrQuit);
    }
}
