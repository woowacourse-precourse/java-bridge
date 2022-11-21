package bridge;

import bridge.controller.NatureController;
import bridge.view.ErrorView;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.ViewFaçade;

public class Application {

    public static void main(String[] args) {
        try{
            ViewFaçade viewFaçade = new ViewFaçade(new InputView(), new OutputView(), new NatureController());
            viewFaçade.start();
        }catch (IllegalArgumentException e){
            new ErrorView().printErrorMessage(e.getMessage());
        }
    }
}
