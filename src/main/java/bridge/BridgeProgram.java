package bridge;

import bridge.controller.BridgeGame;
import bridge.dto.StepResponseDto;
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
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        StepResponseDto stepResponseDto = null;
        do {
            stepResponseDto = bridgeGame.move(inputView.readMoving());
            outputView.printMap(stepResponseDto);
        } while (checkWhetherRetry(bridgeGame, stepResponseDto));
        outputView.printResult(stepResponseDto);
    }

    private boolean checkWhetherRetry(BridgeGame bridgeGame, StepResponseDto stepResponseDto) {
        if (!stepResponseDto.isSuccess()) {
            return bridgeGame.retry(inputView.readGameCommand());
        }
        return !stepResponseDto.isFinal();
    }
}
