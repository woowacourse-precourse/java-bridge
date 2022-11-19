package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.util.Constant;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Map;

public class BridgeGameController {
    private final InputController inputController;
    private final OutputController outputController;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputController = new InputController(
                new InputView(),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator())
        );
        this.outputController = new OutputController(new OutputView());
        this.bridgeGame = new BridgeGame();
    }

    public void start(List<String> board, Map<String, Integer> resultBoard) throws IllegalArgumentException {
        int size = inputController.getBridgeSize(inputController.getBridgeSizeInput());
        List<String> bridge = inputController.getBridge(size);

        bridgeGame.initialize(board, resultBoard);
        play(board, bridge, resultBoard);
    }

    private void play(List<String> board,
                      List<String> bridge,
                      Map<String, Integer> resultBoard) throws IllegalArgumentException {
        int result;
        while (isContinue(board, bridge, resultBoard)) {
            bridgeGame.move(board,
                    inputController.getMovingDirection(inputController.getMovingDirectionInput()));
            outputController.getChoiceResult(board, bridge);
        }
        result = bridgeGame.isSuccess(board, bridge);
        resultBoard.put(Constant.SUCCESS_OR_FAIL, result);
        outputController.getFinalResult(board, bridge, resultBoard);
    }

    private boolean isContinue(List<String> board,
                               List<String> bridge,
                               Map<String, Integer> resultBoard) throws IllegalArgumentException {
        int index = board.size() - 1;
        if (index < 0) {
            return true;
        }
        if (!board.get(index)
                .equals(bridge.get(index))) {
            String command = inputController.getGameCommand(inputController.getGameCommandInput());
            return bridgeGame.retry(board, resultBoard, command);
        }
        return board.size() != bridge.size();
    }
}
