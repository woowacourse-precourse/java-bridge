package bridge;


import bridge.enummodel.ErrorMessageEnum;
import bridge.enummodel.GameResultEnum;
import bridge.processor.ValidatorProcessorImpl;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame(new ValidatorProcessorImpl(), new BridgeMaker(new BridgeRandomNumberGenerator()));
    private static int retryNumber = 1;
    private static final int upSide = 0;
    private static final int downSide = 1;


    public void init() {
        outputView.initGame();
        run(bridgeGame.makeBridge(inputBridgeSize()), new ArrayList<>());
    }

    public void run(List<String> bridge, List<String> inputCommand) {
        List<String> addedInputCommand = bridgeGame.addCommandInput(inputCommand, inputView.readMoving());
        List<List<String>> result = bridgeGame.move(bridge, addedInputCommand);
        outputView.printMap(result.get(upSide), result.get(downSide));
        isMatchSize(bridge, addedInputCommand, result);
    }

    private void isMatchSize(List<String> bridge, List<String> inputCommand, List<List<String>> result) {
        boolean failGame = result.get(upSide).contains(GameResultEnum.CHECK.getValue(false)) ||
                result.get(downSide).contains(GameResultEnum.CHECK.getValue(false));
        if (failGame) checkRetry(bridge, result);
        if (bridge.size() == result.get(upSide).size()) outputView.printResult(result, retryNumber, true);
        if (!failGame && bridge.size() != result.get(upSide).size()) run(bridge, inputCommand);
    }

    private int inputBridgeSize() {
        while (true) {
            try {
                return bridgeGame.convertBridgeSize(inputView.readBridgeSize());

            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessageEnum.NOT_VALIDATE_SIZE.getValue());
            }
        }
    }

    private void checkRetry(List<String> bridge, List<List<String>> result) {
        String command = inputView.readGameCommand();
        if (bridgeGame.retry(command)) {
            retryNumber++;
            run(bridge, new ArrayList<>());
        }
        if (!bridgeGame.retry(command)) {
            outputView.printResult(result, retryNumber, false);
        }
    }
}
