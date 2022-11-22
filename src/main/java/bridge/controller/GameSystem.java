package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.data.BridgeGame;
import bridge.data.UserBridge;
import bridge.valid.InputValid;
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
    private final InputValid inputvalid = new InputValid();

    private String input;
    private String userChoice;
    private String repeat;

    public void welcome() {
        outputView.printWelcome();
    }

    public void inputBridgeLength() {
        outputView.printTryLengthInput();
        input = inputView.readBridgeSize();
        if (inputvalid.checkLengthValid(input) == false) {
            System.out.println("check");
            inputBridgeLength();
            System.out.println("end");
        }
        System.out.println("input: " + input);
        saveSize = Integer.parseInt(input);
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
        userChoice = inputView.readMoving();
        if (inputvalid.checkChoice(userChoice) == false) {
            choiceMove();
        }
        return userChoice;
    }

    private void printBridgeState(UserBridge userBridge) {
        outputView.printMap(userBridge.getUpBridge(), "");
        outputView.printMap(userBridge.getDownBridge(), "\n");
    }

    private String updateState() {
        count += game.getCorrect();
        if(game.getCorrect() == 0) {
            return inputState();
        }
        return "C";
    }

    private String inputState() {
        outputView.printContinue();
        repeat = inputView.readGameCommand();
        if(inputvalid.checkCommand() == false){
            inputState();
        }
        return repeat;
    }
}
