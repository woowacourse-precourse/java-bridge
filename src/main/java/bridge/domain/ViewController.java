package bridge.domain;

import bridge.util.InputValidator;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

import java.util.List;

public class ViewController {
    InputView inputView;
    OutputView outputView;
    InputValidator inputValidator;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        inputValidator = new InputValidator();
    }

    public void printBeginning(){
        System.out.println(Message.MESSAGE_BEGINNING);
    }

    public int readBridgeSize(){
        String bridgeLength = "";
        boolean flag = true;
        return inputView.readBridgeSizeUntilValidate(bridgeLength, flag);
    }


    public String readMoving(){
        String moving = "";
        boolean flag = true;
        return inputView.readMovingUntilValidate(moving, flag);
    }

    public String readGameCommand(){
        String command = "";
        boolean flag = true;
        return inputView.readGameCommandUntilValidate(command, flag);
    }

    public void printMap(List<String> bridge, int len, boolean flag){
        outputView.printMap(bridge, len, flag);
    }

    public void printResult(boolean flag, int count){
        outputView.printResult(flag, count);
    }
}
