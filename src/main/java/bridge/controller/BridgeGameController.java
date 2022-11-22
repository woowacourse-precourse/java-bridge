package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.OutputView.printMap;

public class BridgeGameController {

    private static boolean failFlag;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.failFlag = true;
    }

    public static void setFailFlag(boolean failFlag) {
        BridgeGameController.failFlag = failFlag;
    }

    /**
     * start game
     * */
    public void startGame() {
        outputView.printStart();
        BridgeGame bg = newGame();
        playRound(bg);
        outputView.printResult(failFlag, bg.getTryCount());
    }

    private BridgeGame newGame() {
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bm.makeBridge();
        return new BridgeGame(bridge);
    }

    public static void playRound(BridgeGame bg) {
        setFailFlag(true);
        List<String> moves = new ArrayList<>();
        List<String> bridge = bg.getBridge();

        do {
            moves = bg.move(InputView.readMoving());
            printMap(moves, bridge);
            isFail();
        } while (failFlag && isBridgeEnd(moves, bridge));

        askRetry(bg);
    }

    private static boolean isBridgeEnd(List<String> moves, List<String> bridge) {
        return moves.size() != bridge.size();
    }

    private static void askRetry(BridgeGame bg) {
        if (!failFlag) {
            tryAgain(bg);
        }
    }

    private static void tryAgain(BridgeGame bg) {
        String command = InputView.readGameCommand();
        if (command.equals("R")) {
            bg.retry();
            playRound(bg);
        }
    }

    private static boolean isFail() {
        String bridge = OutputView.getUpDown();
        if (bridge.contains("X")) {
            BridgeGameController.failFlag = false;
        }
        return failFlag;
    }

}
