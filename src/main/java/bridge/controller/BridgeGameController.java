package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.Record;
import bridge.util.ResultConstant;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputController inputController;
    private final OutputController outputController;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputController = new InputController(new InputView(), new OutputView());
        this.outputController = new OutputController(new OutputView());
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
    }

    public void start(int size, Record record) {
        List<String> bridge = getBridge(size);
        bridgeGame.initialize(record);
        play(record, bridge);
    }

    private List<String> getBridge(int size) {
        return bridgeMaker.makeBridge(size);
    }

    private void play(Record record, List<String> bridge) {
        while (isContinue(record, bridge)) {
            bridgeGame.move(record, inputController.getMovingDirection());
            outputController.getChoiceResult(record, bridge);
        }
        record.putInResultBoard(ResultConstant.SUCCESS_OR_FAIL, bridgeGame.isSuccess(record, bridge));
        outputController.getFinalResult(record, bridge);
    }

    private boolean isContinue(Record record, List<String> bridge) {
        int index = record.getBoardSize() - 1;
        if (index < 0) {
            return true;
        }
        if (!record.equalsToBoard(index, bridge.get(index))) {
            return bridgeGame.retry(record, inputController.getGameCommand());
        }
        return record.getBoardSize() != bridge.size();
    }
}
