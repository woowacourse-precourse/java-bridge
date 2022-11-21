package bridge.controller;

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
        outputView.printWithLine(OutputView.START_GAME);
        outputView.printWithLine(OutputView.INPUT_SIZE);
        int size = inputView.readBridgeSize();
        bridgeService.generate(size);
        playGame(size);
        outputView.print(OutputView.GAME_RESULT);
        outputView.printResult(size, bridgeService.isAllAnswer(size));
    }

    public void playGame(int size) {
        do {
            move();
            outputView.printMap(bridgeService.showBridge());
        // 결과 출력
            if (bridgeService.isFailToAnswer()) {
                outputView.printWithLine(OutputView.INPUT_COMMAND);
                String command = inputView.readGameCommand();
                if (command.equals("R")) {
                    bridgeService.retry();
                } else if (command.equals("Q")) {
                    outputView.printResult(bridgeService.quit(size), bridgeService.isAllAnswer(size));
                    break;
                }
            }
        } while (!bridgeService.isAllAnswer(size));
    }

    private void move(){
        outputView.printWithLine(OutputView.INPUT_MOVING);
        String moving = inputView.readMoving();
        bridgeService.move(moving);
    }
}
