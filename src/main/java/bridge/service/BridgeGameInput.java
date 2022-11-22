package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class BridgeGameInput {

    InputView inputView = new InputView();

    OutputView outputView = new OutputView();
    BridgeGameService bridgeGameService = new BridgeGameService();

    public int getBridgeSize() {
        String bridgeSize=inputView.readBridgeSize();
        bridgeGameService.isNumericInput(bridgeSize);
        bridgeGameService.isValidBridgeRange(Integer.parseInt(bridgeSize));
        return Integer.parseInt(bridgeSize);
    }

    public String getMoving() {
        String inputMoving = inputView.readMoving();
        bridgeGameService.isValidMovingInput(inputMoving);

        return inputMoving;
    }

    public String getCommand() {
        String inputCommand = inputView.readGameCommand();
        bridgeGameService.isValidCommand(inputCommand);

        return inputCommand;
    }

    public void getBridgePrint(HashMap<Integer, List<String>> resultMap) {
        outputView.printMap(resultMap);
    }

    public void getResultPrint(String result, int retrycount, HashMap<Integer, List<String>> resultMap) {
        outputView.printResult(result, retrycount, resultMap);
    }
}
