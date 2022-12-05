package bridge;

import bridge.controller.FrontController;
import bridge.view.OutputView;
import bridge.view.ProxyInputView;
import bridge.view.validation.InputValidation;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = configuration();
        frontController.run();
    }
    static FrontController configuration(){
        return new FrontController(new ProxyInputView(new InputValidation()),new OutputView());
    }

}
