package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startGame() {
        outputView.printGameStart();
    }

    public void makeBridge() {
        while (true) {
            try {
                int size = inputView.readBridgeSize();
                bridgeGame = new BridgeGame(size);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public void run(){
        while (true){
            chooseStep();
            if (bridgeGame.isOver()) {
                break;
            }
            bridgeGame.retry();
        }
    }

    private boolean checkOverCondition() {
        if (bridgeGame.checkFinalStep()) {
            return true;
        }
        return askQuit();
    }

    private boolean askQuit() {
        while (true) {
            try {
                String command = inputView.readGameCommand();
                validateCommand(command);
                return command.equals("Q");
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void validateCommand(String command) {
        if (!COMMAND_INPUT.contains(command)) {
            throw new IllegalArgumentException("R또는 Q만 입력할 수 있습니다.");
        }
    }

    private void chooseStep(){
        while (true) {
            try {
                String step = inputView.readMoving();
                bridgeGame.move(step);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void showResult() {
        outputView.printMap(bridgeGame.getResult());
    }


}
