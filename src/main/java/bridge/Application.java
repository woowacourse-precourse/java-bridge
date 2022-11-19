package bridge;

import java.util.List;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeMakerImpl bridgeMakerImpl = new BridgeMakerImpl();
    private static final String CROSS_FAILED = "X";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static List<String> answerBridge;
    private static UsersBridgeCrossStatus userStatus;
    private static int theNumberOfTrials;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void init() {
        theNumberOfTrials = 1;
        makeBridges(getSizeInput());
        processEntireRounds();
    }

    private static int getSizeInput() {
        outputView.printInitialMessages();
        int bridgeSize = inputView.readBridgeSize();
        Validation.validateSize(bridgeSize);
        return bridgeSize;
    }

    private static void makeBridges(int bridgeSize) {
        answerBridge = bridgeMakerImpl.makeAnswerBridge(bridgeSize);
        userStatus = bridgeMakerImpl.makeInitialBridge(bridgeSize);
    }

    private static void processEntireRounds() {
        for (int round = 1; round <= userStatus.getSize(); round++) {
            outputView.printMessageToGetSpaceToMove();
            if (processEachRound(round).equals(CROSS_FAILED)) {
                retryOrQuit();
                return;
            }
        }
        outputView.printResult(theNumberOfTrials); // 다리 건너기 성공 or 게임 재시도하지 않고 종료
    }

    private static String processEachRound(int round) {
        String selectedSpace = inputView.readMoving();
        String movingResult = bridgeGame.move(round, answerBridge, selectedSpace); // O or X

        userStatus.addCrossingResult(Space.getValueByRepresented(selectedSpace), round, movingResult);
        outputView.printMap(userStatus);

        return movingResult;
    }

    private static void retryOrQuit() {
        outputView.printMessageAfterFailure();
        String retryOrQuit = inputView.readGameCommand();
        if (retryOrQuit.equals(RETRY)) {
            theNumberOfTrials++;
            userStatus.resetCurrentBridge();
            processEntireRounds();
        } else if (retryOrQuit.equals(QUIT)) {
            outputView.printResult(theNumberOfTrials);
        }
    }
}
