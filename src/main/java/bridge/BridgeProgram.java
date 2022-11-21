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
        inputView.gameStart();
        BridgeGame bridgeGame = inputBridgeSize();
        StepResponseDto stepResponseDto = null;
        do {
            stepResponseDto = inputMoving(bridgeGame);
            outputView.printMap(stepResponseDto);
        } while (checkWhetherRetry(bridgeGame, stepResponseDto));
        outputView.printResult(stepResponseDto);
    }

    private boolean checkWhetherRetry(final BridgeGame bridgeGame, final StepResponseDto stepResponseDto) {
        if (!stepResponseDto.isSuccess()) {
            return inputGameCommand(bridgeGame);
        }
        return !stepResponseDto.isFinal();
    }

    private BridgeGame inputBridgeSize(){
        while (true) {
            try {
                return new BridgeGame(inputView.readBridgeSize());
            } catch (IllegalArgumentException | IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private StepResponseDto inputMoving(BridgeGame bridgeGame) {
        while (true) {
            try {
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException | IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private boolean inputGameCommand(BridgeGame bridgeGame) {
        while (true) {
            try {
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException | IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }


}
