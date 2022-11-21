package bridge.controller;

import bridge.dto.BridgeResultResponseDto;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView = new InputView();

    private final OutputView outputView = new OutputView();

    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public void run() {
        initGame();
        playGame();
        finishGame();
    }

    private void initGame() {
        outputView.printWithLine(OutputView.START_GAME);
        outputView.printWithLine(OutputView.INPUT_SIZE);
        int size = inputView.readBridgeSize();
        bridgeService.generate(size);
    }

    private void playGame() {
        do {
            inputMoving();
            outputView.printMap(bridgeService.showBridge());
            if (checkMoving()) {
                break;
            }
        } while (!bridgeService.isAllAnswer());
    }

    private void finishGame() {
        outputView.printWithLine(OutputView.GAME_RESULT);
        outputView.printMap(bridgeService.showBridge());
        BridgeResultResponseDto resultDto = bridgeService.showResult();
        outputView.printResult(resultDto.getTryCount(), resultDto.getResult());
    }

    private void inputMoving() {
        outputView.printWithLine(OutputView.INPUT_MOVING);
        String moving = inputView.readMoving();
        bridgeService.move(moving);
    }

    private boolean checkMoving() {
        if (bridgeService.isFailToAnswer()) {
            return isRestartOrQuit();
        }
        return false;
    }

    private boolean isRestartOrQuit() {
        outputView.printWithLine(OutputView.INPUT_COMMAND);
        String command = inputView.readGameCommand();
        if (command.equals("R")) {
            bridgeService.retry();
            return false;
        }
        return true;
    }
}
