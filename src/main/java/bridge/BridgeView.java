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

    public void printStartMessage(){
        outputView.printStartMessage();
    }
    public void printSizeMessage(){
        outputView.printSizeMessage();
    }
    public void printMoveMessage(){
        outputView.printMoveMessage();
    }
    public void printCommandMessage(){
        outputView.printCommandMessage();
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
