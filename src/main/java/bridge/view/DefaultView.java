package bridge.view;

import bridge.controller.BridgeController;

public class DefaultView {

    private final BridgeController controller;
    private final InputView inputView;
    private final OutputView outputView;

    public DefaultView(BridgeController controller){
        this.controller = controller;
        inputView = new InputView(controller);
        outputView = new OutputView(controller);
    }

    public void render(){
        try {
            OutputView.printStart();
            inputView.readBridgeSize();
            while (true) {
                inputView.readMoving();
                outputView.printMap();

                if (!controller.checkGame()) {

                    if (!inputView.readGameCommand()) break;
                }
                if (controller.isSame()) break;
            }
            outputView.printResult();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
