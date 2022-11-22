package bridge.service;

import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ViewService {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public int requestBridgeSize() {
        outputView.askBridgeSize();
        return inputView.readBridgeSize();
    }

    public String requestMovement() {
        outputView.askMovement();
        return inputView.readMovement();
    }

    public String requestDecision() {
        outputView.askDecision();
        return inputView.readDecision();
    }

    public void printMap(int blockIndex, String movement, boolean isCorrect) {
        outputView.printMap(blockIndex, movement, isCorrect);
    }

    public void printResult(User user){
        outputView.printResult(user);
    }

    public void printGameStart(){
        outputView.startBridgeGame();
    }

    public void initMap(){
        outputView.initMap();
    }
}
