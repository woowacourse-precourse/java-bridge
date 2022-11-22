package bridge.view;

import bridge.enums.Glass;
import bridge.enums.State;
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
        outputView.printErrorMessage(errorMessage);
    }


    public void printMap(String map) {

        outputView.printMap(map);
    }

    public void printResult(String result) {
        outputView.printResult(result);
    }


    public BridgeView(){
        inputView = new InputView();
        outputView = new OutputView();
    }
}
