package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.Print;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.BridgeGame.round;

public class BridgeGameController {
    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private int bridgeSize;
    private List<String> bridge;
    private String userInput;
    private String userRetryInput;
    private List<String> mark = new ArrayList<>();
    private boolean crossPossible;

    public void setGame() {
        Print.gameStartMessage();
        setBridgeLength();
        bridge = bridgeGame.make(bridgeSize);
    }

    public void setBridgeLength() { /*입력값 받기*/
        int retryCheckNumber = 1;
        while (retryCheckNumber != 0) {
            Print.requestBridgeLengthMessage();
            try {
                bridgeSize = inputView.readBridgeSize();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
    }

    public void playGame() {
        do {
            userInput = validateMoveInput();
            bridgeGame.move();
            crossPossible = bridgeGame.check(userInput, bridge);
            printSemiResult(crossPossible);
            if (!crossPossible) {
                userRetryInput = validateRetryInput();
                makeClearCondition();
            }
        }while (round != bridge.size());
    }

    private void makeClearCondition() {
        mark.clear();
        boolean retryInput = bridgeGame.retry(userRetryInput, bridgeSize);
        if (retryInput) {
            OutputView.upSide = "";
            OutputView.downSide = "";
        }
    }


    public void printSemiResult(boolean crossPossible) {
        if (crossPossible == false) { mark.add("X"); }
        if (crossPossible == true) { mark.add("O"); }
        outputView.printMap(bridge, mark);
    }

    public void getGameResult() {
        outputView.printResult();
        bridgeGame.getResult(mark, bridge);
    }

    public String validateMoveInput(){
        int retryCheckNumber = 1;
        while (retryCheckNumber != 0) {
            Print.requestPickAPartOfBridgeMessage();
            try {
                userInput = inputView.readMoving();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
        return userInput;
    }

    public String validateRetryInput(){
        int retryCheckNumber = 1;
        while (retryCheckNumber != 0) {
            Print.askRetryMessage();
            try {
                userRetryInput = inputView.readGameCommand();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
        return userRetryInput;
    }

}
