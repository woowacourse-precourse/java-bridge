package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.data.BridgeGame;
import bridge.data.UserBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameSystem {
    private String state = "C";
    private int count = 0;
    private int attempt = 1;
    private int saveSize;

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeMaker make = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final BridgeGame game  = new BridgeGame();

    public void inputBridgeLength() {
        outputView.printWelcome();
        saveSize = inputView.readBridgeSize();
        game.saveBridge(make.makeBridge(saveSize));
    }

    public void calculate() {
        while (!state.equals("Q") && count < saveSize) {
            if( state.equals("R")) {
                attempt += game.retry();
            }
            printBridgeState(game.move(count,choiceMove()));
            state = updateState();
        }
    }

    public void result() {
        String challenge = "성공";
        if (state.equals("Q")) {
            challenge = "실패";
        }
        outputView.printResult(challenge, attempt, game.getUserBridge());
    }

    private String choiceMove() {
        outputView.printChoice();
        return inputView.readMoving();
    }

    private void printBridgeState(UserBridge userBridge) {
        outputView.printMap(userBridge.getUpBridge(), "");
        outputView.printMap(userBridge.getDownBridge(), "\n");
    }

    private String updateState() {
        if (!game.getCorrect()){
            count = 0;
            outputView.printContinue();
            return inputView.readGameCommand();
        }
        count++;
        return "C";
    }
}
