package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeAnswer;
import bridge.model.BridgeGame;
import bridge.model.BridgeLength;
import bridge.utils.BasicBridgeInputAlphabetParser;
import bridge.utils.BasicBridgeInputNumericParser;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeControl {

    private static InputView inputView;
    private static OutputView outputView;
    private static String latestOutput;
    private static int tryCount = 1;

    private static final int UP_DOWN_MODE = 1;
    private static final int RETRY_MODE = 2;
    private static final int END_MODE = 3;
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";

    public BridgeControl() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void execute() {

        BridgeLength bridgeLength = generateLength();
        BridgeAnswer bridgeAnswer = generateAnswer(bridgeLength);
        bridgeAnswer.printAnswerInBeginForTest();
        userInputCircle(bridgeAnswer);
    }

    public static BridgeLength generateLength() {
        try {
            String userInput = inputView.readBridgeSize();
            return BasicBridgeInputNumericParser.parseBridgeLengthAmount(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return BridgeControl.generateLength();
        }
    }

    private BridgeAnswer generateAnswer(BridgeLength bridgeLength) {
        return BridgeAnswer.using(new BridgeRandomNumberGenerator(), bridgeLength);
    }

    private void userInputCircle(BridgeAnswer bridgeAnswer) {
        BridgeGame userGenerateGame = generateGameActionUpDown(UP_DOWN_MODE);
        int compareResult = userGenerateGame.move(bridgeAnswer);
        reachAnswerCase(bridgeAnswer, compareResult);
        upDownInputCase(bridgeAnswer, compareResult);
        wrongInputCase(bridgeAnswer, compareResult);
    }

    private void wrongInputCase(BridgeAnswer bridgeAnswer, int compareResult) {
        if (compareResult == 3) {
            outputView.printMap(bridgeAnswer.printAnswer(3));
            latestOutput = bridgeAnswer.printAnswer(3);
            retryCircle(bridgeAnswer);
        }
    }

    private void upDownInputCase(BridgeAnswer bridgeAnswer, int compareResult) {
        if (compareResult == 2) {
            outputView.printMap(bridgeAnswer.printAnswer(2));
            latestOutput = bridgeAnswer.printAnswer(2);
            userInputCircle(bridgeAnswer);
        }
    }

    private static void reachAnswerCase(BridgeAnswer bridgeAnswer, int compareResult) {
        if (compareResult == 1) {
            latestOutput = bridgeAnswer.printAnswer(1);
            outputView.printResult(bridgeAnswer.printFinalResult(latestOutput, tryCount, SUCCESS));
        }
    }

    private void retryCircle(BridgeAnswer bridgeAnswer) {
        BridgeGame userGenerate = generateGameActionReplay(RETRY_MODE);
        wantToRetryCase(bridgeAnswer, userGenerate);
        wantToEndCase(bridgeAnswer, userGenerate);
    }

    private static void wantToEndCase(BridgeAnswer bridgeAnswer, BridgeGame userGenerate) {
        if (!userGenerate.retry(bridgeAnswer)) {
            outputView.printResult(bridgeAnswer.printFinalResult(latestOutput, tryCount, FAILURE));
        }
    }

    private void wantToRetryCase(BridgeAnswer bridgeAnswer, BridgeGame userGenerate) {
        if (userGenerate.retry(bridgeAnswer)) {
            tryCount++;
            userInputCircle(bridgeAnswer);
        }
    }

    public static BridgeGame generateGameActionUpDown(int mode) {
        BridgeGame bridgeGame;
        try {
            bridgeGame = BasicBridgeInputAlphabetParser.parseBridgeGameInput(inputView.readMoving(), mode);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return BridgeControl.generateGameActionUpDown(mode);
        }
        return bridgeGame;
    }

    public static BridgeGame generateGameActionReplay(int mode) {
        BridgeGame bridgeGame;
        try {
            bridgeGame = BasicBridgeInputAlphabetParser.parseBridgeGameInput(inputView.readRetry(), mode);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return BridgeControl.generateGameActionReplay(mode);
        }
        return bridgeGame;
    }
}
