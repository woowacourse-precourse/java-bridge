package bridge;

import bridge.controller.FrontController;
import bridge.domain.Bridge;
import bridge.domain.BridgeConst;
import bridge.domain.BridgeGame;
import bridge.view.Input;
import bridge.view.OutputView;
import bridge.view.ProxyInputView;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = configuration();
        frontController.run();
    }
    static FrontController configuration(){
        return new FrontController(new ProxyInputView(new InputValidation()),new OutputView());
    }

}
