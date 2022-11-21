package bridge.Controller;

import static bridge.Utils.Constant.GameCommand.QUIT;
import static bridge.Utils.Constant.GameCommand.RETRY;

import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.Bridge;
import bridge.Domain.BridgeMaker;
import bridge.Utils.Constant.GameCommand;
import bridge.View.TotalView;
import java.util.List;

public class BridgeController {

    private final BridgeMaker bridgeMaker;
    private final TotalView view;

    public BridgeController() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        view = new TotalView();
    }

    public List<String> getAnswerBridge() {
        int bridgeSize = view.startAndGetBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public Bridge addMovingToBridge(Bridge bridge) {
        bridge.addMoving(view.getMoving());
        return bridge;
    }

    public GameCommand getCommand() {
        String command = view.getCommand();
        if (command.equals(QUIT.toString())) {
            return QUIT;
        }
        return RETRY;
    }

    public void printResultByBridge(Bridge bridge) {
        view.printResult(bridge.getResult());
    }

    public void printQuitMessageByBridge(Bridge bridge, Boolean isSuccess, int playCount) {
        view.quit(bridge.getResult(), isSuccess, playCount);
    }
}
