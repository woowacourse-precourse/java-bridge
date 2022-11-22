package bridge.view;

import bridge.domain.BridgeGame;
import bridge.handler.InputMoveStepHandler;
import bridge.service.BridgeMoveStepService;

import java.util.List;

public class OutputView {
    PrintView printView = new PrintView();
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    private String moveStep;
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
            System.out.println(printView.MOVE_STEP);
            moveStep = inputView.readGameCommand();
            bridgeGame.move(inputMoveStepHandler.checkValidator(moveStep), bridgeData.get(index), index);
            if(BridgeGame.checkResultFlag == 1 || BridgeGame.checkResultFlag == 2) break;
            succesStepBridge(index, bridgeData);
        }
    }

    private boolean exitLoop() {
        return BridgeGame.checkResultFlag != 1 && BridgeGame.checkResultFlag != 2;
    }

    private void succesStepBridge(int index, List<String> bridgeData) {
        BridgeMoveStepService bridgeMoveStepService = new BridgeMoveStepService();
        if(index == bridgeData.size() - 1 && BridgeGame.checkResultFlag == 0) {
            BridgeGame.checkResultFlag = 2;
            printView.lineSkip();
            System.out.println(printView.THE_GAME_RESULT);
            bridgeMoveStepService.extractBracket(bridgeGame.upSide,bridgeGame.downSide);
            printView.lineSkip();
            bridgeGame.printSuccessOrFailCase();
        }
    }
}
