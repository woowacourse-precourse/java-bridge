package bridge.controller;

import bridge.domain.bridgebuilder.BridgeGame;
import bridge.domain.oxbridgebuilder.OXBridge;
import bridge.domain.resources.Bridge;
import bridge.domain.resources.ReOrQuit;
import bridge.domain.resources.UpOrDown;
import bridge.utils.FirstInstanceBuilder;
import bridge.utils.UDRQInstanceBuilder;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private static final int RETURN_TO_BEGINNING = -1;
    private static final int END_GAME = 21;
    private static final int FIRST_TRY = 1;

    InputView inputView;
    OutputView outputView;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void prepareGame() {
        Bridge answerBridge = buildAnswerBridge();
        OXBridge oxBridge = buildUserBridge();
        runGame(answerBridge, oxBridge, FIRST_TRY);
    }

    private void runGame(Bridge answerBridge, OXBridge oxBridge, int tries) {
        for (int i = 0; i < answerBridge.size(); i++) {
            if (!isInputUDCorrect(answerBridge, oxBridge)) {
                i = returnToZeroOrQuit(makeRQ(), oxBridge, tries++);
                oxBridge = buildUserBridge();
            }
            if (i == answerBridge.size() - 1) {
                printSuccess(oxBridge, tries);
            }
        }
    }

    private boolean isInputUDCorrect(Bridge answerBridge, OXBridge oxBridge) {
        boolean correctOrWrong = isInputCorrect(answerBridge, oxBridge, makeUD());
        printBridge(oxBridge);
        return correctOrWrong;
    }

    private boolean isInputCorrect(Bridge answerBridge, OXBridge oxBridge, UpOrDown upOrDown) {
        return BridgeGame.move(answerBridge, oxBridge, upOrDown);
    }

    private int returnToZeroOrQuit(ReOrQuit reOrQuit, OXBridge oxBridge, int tries) {
        if (wannaRetry(reOrQuit)) {
            return RETURN_TO_BEGINNING;
        }
        return beforeEndingGame(oxBridge, tries);
    }

    private int beforeEndingGame(OXBridge oxBridge, int tries) {
        printLose(oxBridge, tries);
        return END_GAME;
    }

    private static boolean wannaRetry(ReOrQuit reOrQuit) {
        return BridgeGame.retry(reOrQuit.getInputRQ());
    }

    private void printLose(OXBridge oxBridge, int tries) {
        printResult(oxBridge);
        outputView.printLose(tries);
    }

    private void printSuccess(OXBridge oxBridge, int tries) {
        printResult(oxBridge);
        outputView.printSuccess(tries);
    }

    private void printBridge(OXBridge oxBridge) {
        outputView.printMap(oxBridge.toString());
    }

    private void printResult(OXBridge oxBridge) {
        outputView.printResult(oxBridge.toString());
    }

    private void printStart() {
        outputView.printStartMessage();
    }

    private OXBridge buildUserBridge() {
        return FirstInstanceBuilder.buildOXBridge();
    }

    private Bridge buildAnswerBridge() {
        printStart();
        return FirstInstanceBuilder.buildAnswerBridge(inputView.readBridgeSize(), inputView, outputView);
    }

    private UpOrDown makeUD() {
        return UDRQInstanceBuilder.makeUDGlass(inputView.readMoving(), inputView, outputView);
    }

    private ReOrQuit makeRQ() {
        return UDRQInstanceBuilder.makeRQDecision(inputView.readGameCommand(), inputView, outputView);
    }
}
