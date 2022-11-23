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
        if (!bridgeGameService.isNumericInput(bridgeSize)) {
            getBridgeSize();
        }
        if (!bridgeGameService.isValidBridgeRange(Integer.parseInt(bridgeSize))){
            getBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    public String getMoving() {
        String inputMoving = inputView.readMoving();
        if (!bridgeGameService.isValidMovingInput(inputMoving)){
            getMoving();
        }
        return inputMoving;
    }

    public String getCommand() {
        String inputCommand = inputView.readGameCommand();
        if (!bridgeGameService.isValidCommand(inputCommand)) {
            getCommand();
        }
        return inputCommand;
    }

    public void getBridgePrint(HashMap<Integer, List<String>> resultMap) {
        outputView.printMap(resultMap);
    }

    public void getResultPrint(String result, int retrycount, HashMap<Integer, List<String>> resultMap) {
        outputView.printResult(result, retrycount, resultMap);
    }
}
