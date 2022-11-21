package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.Record;
import bridge.util.Constant;
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

    public void start(Record record) throws IllegalArgumentException {
        int size = inputController.getBridgeSize();
        List<String> bridge = getBridge(size);

        bridgeGame.initialize(record);
        play(record, bridge);
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
