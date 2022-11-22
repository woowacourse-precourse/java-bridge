package bridge;

import java.util.List;

public class BridgeView {
    private final InputView inputView;
    private final OutputView outputView;

    public String readBridgeSize() {
        return inputView.readBridgeSize();
    }

    public String readMoving(){
        return inputView.readMoving();
    }

    public String readGameCommand(){
        return inputView.readGameCommand();
    }

    public void printMap(List<Glass> history, State lastState) {

        outputView.printMap(history, lastState);
    }


    public void printResult(List<Glass> history, State lastState, int play) {
        outputView.printResult(history, lastState, play);
    }


    BridgeView(){
        inputView = new InputView();
        outputView = new OutputView();
    }
}
