package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.Record;
import bridge.util.Constant;
import bridge.util.ExceptionMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputController inputController;
    private final OutputController outputController;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputController = new InputController(new InputView());
        this.outputController = new OutputController(new OutputView());
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
    }

    public void start(String sizeInput, Record record) throws IllegalArgumentException {
        List<String> bridge;
        int size = convertToNumber(sizeInput);
        isValidBridgeSize(size);

        bridge = getBridge(size);
        bridgeGame.initialize(record);
        play(record, bridge);
    }

    private int convertToNumber(String sizeInput) {
        int result;
        try {
            result = Integer.parseInt(sizeInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.CANNOT_CONVERT_TO_NUMBER);
        }
        return result;
    }

    private void isValidBridgeSize(int size) throws IllegalArgumentException {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }

    private List<String> getBridge(int size) throws IllegalArgumentException {
        return bridgeMaker.makeBridge(size);
    }

    private void play(Record record,
                      List<String> bridge) throws IllegalArgumentException {
        int result;
        while (isContinue(record, bridge)) {
            bridgeGame.move(record, inputController.getMovingDirection());
            outputController.getChoiceResult(record, bridge);
        }
        result = bridgeGame.isSuccess(record, bridge);
        record.putInResultBoard(Constant.SUCCESS_OR_FAIL, result);
        outputController.getFinalResult(record, bridge);
    }

    private boolean isContinue(Record record,
                               List<String> bridge) throws IllegalArgumentException {
        int index = record.getBoardSize() - 1;
        if (index < 0) {
            return true;
        }
        if (!record.equalsToBoard(index, bridge.get(index))) {
            String command = inputController.getGameCommand();
            return bridgeGame.retry(record, command);
        }
        return record.getBoardSize() != bridge.size();
    }
}
