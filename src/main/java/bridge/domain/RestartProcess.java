package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

public class RestartProcess {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    public boolean restart() {
        outputView.printRestart();
        String destination = inputView.readGameCommand();
        if(destination.equals("Q")){
            return false;
        }
        if(destination.equals("R"))
        {
            return true;
        }
        return true;
    }
}
