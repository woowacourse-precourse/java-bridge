package bridge;

import java.util.List;

public class BridgeView {
    private final InputView inputView;
    private final OutputView outputView;

    public String sizeIO(){
        outputView.printSizeMessage();
        return inputView.readBridgeSize();
    }

    public String moveIO(){
        outputView.printMoveMessage();
        return inputView.readMoving();
    }

    public String commandIO(){
        outputView.printCommandMessage();
        return inputView.readGameCommand();
    }

    public void printStartMessage(){
        outputView.printStartMessage();
    }

    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
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
