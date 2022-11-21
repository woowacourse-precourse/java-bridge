package bridge.controller;

import bridge.constant.Message;
import bridge.model.dto.GameResultDto;
import bridge.model.dto.MoveResultDto;
import bridge.model.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private static final BridgeController bridgeController = new BridgeController();
    private static final BridgeService bridgeService = BridgeService.getInstance();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

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
            isMovableStatus = requestRestartGame(moveResultDto);
        }
    }

    private boolean requestRestartGame(MoveResultDto moveResultDto) {
        boolean isMovableStatus = moveResultDto.isMovableStatus();
        if (!moveResultDto.isRightLastBridgePick()) {
            String gameCommand = inputView.readGameCommand();
            isMovableStatus = bridgeService.retry(gameCommand);
        }
        return isMovableStatus;
    }

    private MoveResultDto moveOneBridge() {
        String bridgeType = inputView.readMoving();
        MoveResultDto moveResultDto = bridgeService.move(bridgeType);
        List<Integer> bridgeMap = bridgeService.readBridgeMap();
        outputView.printMap(bridgeMap, moveResultDto.isRightLastBridgePick());
        return moveResultDto;
    }

    private void printResult() {
        GameResultDto gameResult = bridgeService.readGameResult();
        List<Integer> bridgeMap = bridgeService.readBridgeMap();
        outputView.printResult(bridgeMap, gameResult.getSuccessOrFail(), gameResult.getRetryCount());
    }


}
