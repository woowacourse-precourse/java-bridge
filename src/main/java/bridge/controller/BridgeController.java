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

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void prepareGame() {
        Bridge answerBridge = buildAnswerBridge();
        OXBridge oxBridge = buildOXBridge();

        runGame(answerBridge, oxBridge);
    }

    private void runGame(Bridge answerBridge, OXBridge oxBridge) {
        for (int bridgeIndex = 0; bridgeIndex < answerBridge.size(); bridgeIndex++) {
            BridgeGame.move(answerBridge, oxBridge, makeUD());
            printBridge(oxBridge);
            if (!oxBridge.isCorrectOrWrong()) {
                bridgeIndex = returnToZeroOrQuit(makeRQ(), oxBridge);
                oxBridge = buildOXBridge();
            }
            if (bridgeIndex == answerBridge.size() - 1) {
                printSuccess(oxBridge);
            }
        }
    }

    private int returnToZeroOrQuit(ReOrQuit reOrQuit, OXBridge oxBridge) {
        if (wannaRetry(reOrQuit)) {
            return RETURN_TO_BEGINNING;
        }
        return beforeEndingGame(oxBridge);
    }

    private int beforeEndingGame(OXBridge oxBridge) {
        printLose(oxBridge);
        return END_GAME;
    }

    private static boolean wannaRetry(ReOrQuit reOrQuit) {
        return BridgeGame.retry(reOrQuit.getInputRQ());
    }

    private void printLose(OXBridge oxBridge) {
        printResult(oxBridge);
        outputView.printLose(oxBridge.getTries());
    }

    private void printSuccess(OXBridge oxBridge) {
        printResult(oxBridge);
        outputView.printSuccess(oxBridge.getTries());
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

    private OXBridge buildOXBridge() {
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
