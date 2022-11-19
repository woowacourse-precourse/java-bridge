package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeProgram {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private BridgeProgram(){
    }

    private static class BridgeHolder{
        private static final BridgeProgram INSTANCE = new BridgeProgram();
    }

    public static BridgeProgram getInstance() {
        return BridgeHolder.INSTANCE;
    }

    public void start(){
    }
}
