package bridge.view;

import bridge.domain.BridgeGame;
import bridge.handler.InputMoveStepHandler;

import java.util.List;

public class OutputView {
    PrintView printView = new PrintView();
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    private String moveStep;
    InputMoveStepHandler inputMoveStepHandler = new InputMoveStepHandler(moveStep);

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
            if(BridgeGame.checkAnswerIndex == 1 || BridgeGame.checkAnswerIndex == 2) break;
            succesStepBridge(index, bridgeData);
        }
    }

    private boolean exitLoop() {
        return BridgeGame.checkAnswerIndex != 1 && BridgeGame.checkAnswerIndex != 2;
    }

    private void succesStepBridge(int index, List<String> bridgeData) {
        if(index == bridgeData.size() - 1 && BridgeGame.checkAnswerIndex == 0) {
            BridgeGame.checkAnswerIndex = 2;
            printView.lineSkip();
            System.out.println(printView.THE_GAME_RESULT);
            bridgeGame.extractBracket(bridgeGame.upSide,bridgeGame.downSide);
            printView.lineSkip();
            bridgeGame.printFailOrSuccessCase();
        }
    }
}
