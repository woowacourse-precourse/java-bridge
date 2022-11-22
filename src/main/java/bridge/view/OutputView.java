package bridge.view;

import bridge.domain.BridgeGame;
import bridge.handler.InputMoveStepHandler;
import bridge.service.BridgeMoveStepService;

import java.util.List;

public class OutputView {
    PrintView printView = new PrintView();
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    InputMoveStepHandler inputMoveStepHandler = new InputMoveStepHandler();

    public void printMap(List<String> bridgeData) {
        do {
            stepBridge(bridgeData);
        } while (exitLoop());
    }

    public void stepBridge(List<String> bridgeData) {
        BridgeGame.retryCount++;
        for(int index = 0 ; index < bridgeData.size(); index++) {
            if(index != 0) printView.lineSkip();
            stepIntoBridge(bridgeData, index);
            if(BridgeGame.bridgeFlag == 1 || BridgeGame.bridgeFlag == 2) break;
            succesStepBridge(index, bridgeData);
        }
    }

    private void stepIntoBridge(List<String> bridgeData, int index) {
        System.out.println(printView.MOVE_STEP);
        String moveStep = loopInputUpOrDown();
        bridgeGame.move(inputMoveStepHandler.checkValidator(moveStep), bridgeData.get(index), index);
    }

    private String loopInputUpOrDown() {
        try {
            String upOrDown = inputView.readGameCommand();
            inputMoveStepHandler.checkValidator(upOrDown);
            return upOrDown;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return loopInputUpOrDown();
        }
    }

    private void succesStepBridge(int index, List<String> bridgeData) {
        if(index == bridgeData.size() - 1 && BridgeGame.bridgeFlag == 0) {
            successStepIntoBridge();
            printSuccessOrFailCase();
        }
    }

    private void successStepIntoBridge() {
        BridgeMoveStepService bridgeMoveStepService = new BridgeMoveStepService();

        BridgeGame.bridgeFlag = BridgeFlag.SUCCESS.getNumber();
        printView.lineSkip();
        System.out.println(printView.THE_GAME_RESULT);
        bridgeMoveStepService.extractBracket(bridgeGame.upSide,bridgeGame.downSide);
        printView.lineSkip();
    }

    public void printSuccessOrFailCase() {
        if(BridgeGame.bridgeFlag == BridgeFlag.FAIL.getNumber()) {
            printView.lineSkip();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.FAIL);
            System.out.println(printView.TOTAL_COUNT+" "+ BridgeGame.retryCount);
        }
        if(BridgeGame.bridgeFlag == BridgeFlag.SUCCESS.getNumber()) {
            printView.lineSkip();
            System.out.println(printView.SUCCESS_OR_FAIL+" "+ printView.SUCCESS);
            System.out.println(printView.TOTAL_COUNT+" "+ BridgeGame.retryCount);
        }
    }

    private boolean exitLoop() {
        return BridgeGame.bridgeFlag != BridgeFlag.FAIL.getNumber() && BridgeGame.bridgeFlag != BridgeFlag.SUCCESS.getNumber();
    }
}