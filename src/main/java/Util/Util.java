package Util;

import Model.Map;
import View.InputView;
import View.OutputView;

public class Util {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public String determineWhereToGo() {
        outputView.printWhereToGoInputRequest();
       return inputView.readMoving();
    }

    public int determineBridgeSize() {
        outputView.printBridgeLengthInputRequest();
        return inputView.readBridgeSize();
    }

    public boolean determineIfContinue() {
        outputView.printContinueOrEndRequest();
        return inputView.readGameCommand();
    }

}
