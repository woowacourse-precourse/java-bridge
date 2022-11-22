package bridge;

import java.util.List;

public class BridgeCheck {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public static String isRightBridge(List<String> bridgeInfo, int i){
        String movement = InputView.readMoving();
        OutputView.printMap(bridgeInfo, i, movement);
        if (!bridgeInfo.equals(movement)){
            return InputView.readGameCommand(i);
        }

        return "";
    }

    public static void BridgeCheckIfIZero(List<String> bridgeInfo, String movement){
        if (bridgeInfo.get(0).equals(movement)){
            OutputView.printMapIfIZero(bridgeInfo);
        }
        if (!bridgeInfo.get(0).equals(movement)){
            OutputView.printMapIfIZeroNotEqual(movement);
        }
    }
}
