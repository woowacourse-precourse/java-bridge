package bridge.controller;

import bridge.Constants;
import bridge.domain.Bridge;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    private InputController inputController;
    private Bridge bridge;
    private OutputView outputView;
    private List<String> choices;
    private int tryNumbers;
    private boolean pass;

    public Controller() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame();
        inputController = new InputController();
    }

    public void game() throws IllegalArgumentException{
        outputView.InitialMessage();
        int size = makeBridgeObject();
        outputView = new OutputView(bridge);
        tryNumbers = 0;
        pass = false;
        doWhileGameEnd(size);

        printFinalResult(pass, tryNumbers);
    }

    private int makeBridgeObject() {
        int size = inputController.setBridgeSize();
        List<String> bridgeRoads = bridgeMaker.makeBridge(size);
        bridge = new Bridge(bridgeRoads);

        return size;
    }

    private void doWhileGameEnd(int size) {
        boolean retry = false;
        choices = new ArrayList<>();
        do {
            tryNumbers++;
            retry = iterateToCrossEachBridge(size, retry);
        } while (retry);
    }

    private boolean iterateToCrossEachBridge(int size, boolean retry) {
        for (int i = 0 ; i< size; i++) {
            String choice = makeChoice(i);
            if (!(bridgeGame.move(bridge, choice, i))) {
                choices.clear();
                return bridgeGame.retry(inputController.setGameCommand());
            }
            retry = gamePass(i, size);
        }
        return retry;
    }

    private String makeChoice(int i) {
            String choice = inputController.setMoveChoice();
        choices.add(choice);
        outputView.printMap(i, choices);

        return choice;
    }

    private boolean gamePass(int i, int size) {
        if (i==size-1) {
            pass = true;
            boolean retry = bridgeGame.retry(Constants.UserChoices.QUIT_UPPER);

            return retry;
        }
        return true;
    }

    private void printFinalResult(boolean pass , int tryNumbers) {
        System.out.println();
        outputView.printResult(pass, tryNumbers);
    }
}
