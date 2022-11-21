package bridge.controller;

import bridge.constant.Message;
import bridge.model.dto.GameResultDto;
import bridge.model.dto.MoveResultDto;
import bridge.model.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private static final BridgeController bridgeController = new BridgeController();
    private final BridgeService bridgeService = BridgeService.getInstance();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private BridgeController() {
    }

    public static BridgeController getInstance() {
        return bridgeController;
    }

    public void run() {
        createBridge();
        move();
        printResult();
    }

    private void createBridge() {
        System.out.println(Message.START_GAME);
        int bridgeSize = inputView.readBridgeSize();
        bridgeService.createBridge(bridgeSize);
    }

    private void move() {
        boolean isMovableStatus = true;
        while (isMovableStatus) {
            MoveResultDto moveResultDto = moveOneBridge();
            isMovableStatus = moveResultDto.isMovableStatus();
            if (!moveResultDto.isRightLastBridgePick()) {
                String gameCommand = inputView.readGameCommand();
                isMovableStatus = bridgeService.retry(gameCommand);
            }
        }
    }

    private MoveResultDto moveOneBridge() {
        String bridgeType = inputView.readMoving();
        MoveResultDto moveResultDto = bridgeService.move(bridgeType);
        outputView.printMap(moveResultDto.getBridgeMap(), moveResultDto.isRightLastBridgePick());
        return moveResultDto;
    }

    private void printResult() {
        GameResultDto gameResult = bridgeService.readGameResult();
        outputView.printResult(gameResult.getBridgeMap(), gameResult.getSuccessOrFail(), gameResult.getRetryCount());
    }


}
