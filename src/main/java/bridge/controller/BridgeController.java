package bridge.controller;

import bridge.domain.bridgebuilder.BridgeGame;
import bridge.domain.oxbridgebuilder.OXBridge;
import bridge.domain.resources.Bridge;
import bridge.domain.resources.ReOrQuit;
import bridge.domain.resources.Tries;
import bridge.domain.resources.UpOrDown;
import bridge.utils.FirstInstanceBuilder;
import bridge.utils.UDRQInstanceBuilder;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private static final int RETURN_TO_BEGINNING = -1;
    private static final int END_GAME = 21;
    private static final String NEW_LINE = "";

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void prepareGame() {
        Bridge answerBridge = buildAnswerBridge();
        newLineForTheStart();
        OXBridge oxBridge = buildOXBridge();
        Tries tries = new Tries();
        runGame(answerBridge, oxBridge, tries);
    }

    private void runGame(Bridge answerBridge, OXBridge oxBridge, Tries tries) {
        for (int bridgeIndex = 0; bridgeIndex < answerBridge.size(); bridgeIndex++) {
            BridgeGame.move(answerBridge, oxBridge, makeUD());
            printBridge(oxBridge);
            if (!oxBridge.isCorrectOrWrong()) {
                bridgeIndex = returnToZeroOrQuit(makeRQ(), oxBridge, tries);
                oxBridge = buildOXBridge();
            }
            if (bridgeIndex == answerBridge.size() - 1) {
                printSuccess(oxBridge, tries);
            }
        }
    }

    private int returnToZeroOrQuit(ReOrQuit reOrQuit, OXBridge oxBridge, Tries tries) {
        if (wannaRetry(reOrQuit)) {
            tries.oneMoreTry();
            return RETURN_TO_BEGINNING;
        }
        return beforeEndingGame(oxBridge, tries);
    }

    private int beforeEndingGame(OXBridge oxBridge, Tries tries) {
        printLose(oxBridge, tries);
        tries.initializeTries();
        return END_GAME;
    }

    private static boolean wannaRetry(ReOrQuit reOrQuit) {
        return BridgeGame.retry(reOrQuit.getInputRQ());
    }

    private void newLineForTheStart() {
        outputView.print(NEW_LINE);
    }

    private void printLose(OXBridge oxBridge, Tries tries) {
        printResult(oxBridge);
        outputView.printLose(tries.getTries());
    }

    private void printSuccess(OXBridge oxBridge, Tries tries) {
        printResult(oxBridge);
        outputView.printSuccess(tries.getTries());
        tries.initializeTries();
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
        return FirstInstanceBuilder.buildAnswerBridge(inputView.readBridgeSize());
    }

    private UpOrDown makeUD() {
        return UDRQInstanceBuilder.makeUDGlass(inputView.readMoving(), inputView, outputView);
    }

    private ReOrQuit makeRQ() {
        return UDRQInstanceBuilder.makeRQDecision(inputView.readGameCommand(), inputView, outputView);
    }
}
