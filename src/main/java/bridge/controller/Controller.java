package bridge.controller;

import bridge.domain.Bridge;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private Bridge bridge;
    private OutputView outputView;
    private int tryNumbers;
    private boolean pass;
    List<String> choices;

    public Controller() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame();
    }

    public void game() throws IllegalArgumentException{
        int size = makeBridgeObject();
        outputView = new OutputView(bridge);
        tryNumbers = 0;
        pass = false;

        doWhileGameEnd(size);

        printFinalResult(pass, tryNumbers);
    }

    private int makeBridgeObject() {
        int size = InputController.setBridgeSize();
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
                return bridgeGame.retry(InputController.setGameCommand());
            }
            retry = gamePass(i, size);
        }
        return retry;
    }

    private String makeChoice(int i) {
        String choice = InputController.setMoveChoice();
        choices.add(choice);
        outputView.printMap(i, choices);

        return choice;
    }

    private boolean gamePass(int i, int size) {
        if (i==size-1) {
            pass = true;
            boolean retry = bridgeGame.retry("Q");

            return retry;
        }
        return true;
    }

    private void printFinalResult(boolean pass , int tryNumbers) {
        System.out.println();
        outputView.printResult(pass, tryNumbers);
    }
}
