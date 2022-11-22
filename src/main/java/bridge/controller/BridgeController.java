package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeAnswer;
import bridge.model.BridgeLength;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.Sentence;
import bridge.utils.BasicBridgeInputAlphabetParser;
import bridge.utils.BasicBridgeInputNumericParser;

public class BridgeController {

    private int tryCount = 1;
    private static final int UP_DOWN_MODE = 1;
    private static final int RETRY_MODE = 2;
    private static final int REACHED_END = 1;
    private static final int COMPARE_SAME = 2;
    private static final int COMPARE_DIFFERENT = 3;

    private static InputView inputView;
    private static OutputView outputView;
    private static String latestOutput;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void execute() {
        outputView.printResult(Sentence.BEGIN_GAME.getValue());
        BridgeLength bridgeLength = generateLength();
        outputView.printResult(Sentence.BLANK_LINE.getValue());
        BridgeAnswer bridgeAnswer = generateAnswer(bridgeLength);
        userInputCircle(bridgeAnswer);
    }

    private static BridgeLength generateLength() {
        try {
            return BasicBridgeInputNumericParser.parseBridgeLengthAmount(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return BridgeController.generateLength();
        }
    }

    private BridgeAnswer generateAnswer(final BridgeLength bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return BridgeAnswer.using(bridgeMaker, bridgeLength);
    }

    private void userInputCircle(final BridgeAnswer bridgeAnswer) {
        BridgeGame userGenerateGame = generateGameActionUpDown(UP_DOWN_MODE);
        int compareResult = userGenerateGame.move(bridgeAnswer);
        checkCompareResult(bridgeAnswer, compareResult);
    }

    private void checkCompareResult(final BridgeAnswer bridgeAnswer, final int compareResult) {
        reachAnswerCase(bridgeAnswer, compareResult);
        upDownInputCase(bridgeAnswer, compareResult);
        wrongInputCase(bridgeAnswer, compareResult);
    }

    private void reachAnswerCase(final BridgeAnswer bridgeAnswer, final int compareResult) {
        if (compareResult == REACHED_END) {
            latestOutput = getRecentResult(bridgeAnswer, REACHED_END);
            outputView.printMap(latestOutput);
            getFinalResult(Sentence.SUCCESS.getValue());
        }
    }

    private void upDownInputCase(final BridgeAnswer bridgeAnswer, final int compareResult) {
        if (compareResult == COMPARE_SAME) {
            renewLatestOutput(bridgeAnswer, COMPARE_SAME);
            userInputCircle(bridgeAnswer);
        }
    }

    private void wrongInputCase(final BridgeAnswer bridgeAnswer, final int compareResult) {
        if (compareResult == COMPARE_DIFFERENT) {
            renewLatestOutput(bridgeAnswer, COMPARE_DIFFERENT);
            retryCircle(bridgeAnswer);
        }
    }

    private void renewLatestOutput(final BridgeAnswer bridgeAnswer, final int compareSame) {
        latestOutput = getRecentResult(bridgeAnswer, compareSame);
        outputView.printMap(latestOutput);
    }

    private String getRecentResult(final BridgeAnswer bridgeAnswer, final int message) {
        return bridgeAnswer.printCurrentBridgeStatus(message).toString();
    }

    private void retryCircle(final BridgeAnswer bridgeAnswer) {
        BridgeGame userGenerate = generateGameActionReplay(RETRY_MODE);
        wantToRetryCase(bridgeAnswer, userGenerate);
        wantToEndCase(bridgeAnswer, userGenerate);
    }

    private void wantToEndCase(final BridgeAnswer bridgeAnswer, final BridgeGame userGenerate) {
        if (!userGenerate.retry(bridgeAnswer)) {
            getFinalResult(Sentence.FAILURE.getValue());
        }
    }

    private void wantToRetryCase(final BridgeAnswer bridgeAnswer, final BridgeGame userGenerate) {
        if (userGenerate.retry(bridgeAnswer)) {
            tryCount++;
            userInputCircle(bridgeAnswer);
        }
    }

    private static BridgeGame generateGameActionUpDown(final int mode) {
        try {
            return BasicBridgeInputAlphabetParser.parseBridgeGameInput(inputView.readMoving(), mode);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return BridgeController.generateGameActionUpDown(mode);
        }
    }

    private static BridgeGame generateGameActionReplay(final int mode) {
        try {
            return BasicBridgeInputAlphabetParser.parseBridgeGameInput(inputView.readRetry(), mode);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return BridgeController.generateGameActionReplay(mode);
        }
    }

    private void getFinalResult(final String successOrFail) {
        outputView.printResultMessage(latestOutput);
        getGameSuccessORFail(successOrFail);
    }

    private void getGameSuccessORFail(final String successOrFail) {
        outputView.printSuccessOrFailMessage(successOrFail);
        getTotalTrial();
    }

    private void getTotalTrial() {
        outputView.printTotalTrial(tryCount + "");
    }
}
