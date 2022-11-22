package bridge.view;

import bridge.domain.BridgeGame;
import bridge.handler.InputMoveStepHandler;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    PrintView printView = new PrintView();
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    InputMoveStepHandler inputMoveStepHandler = new InputMoveStepHandler();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeData) {
        while(PrintView.checkRestart){
            stepBridge(bridgeData);
            if(!exitLoop()) {break;}
        }
    }

    private boolean exitLoop() {
        return PrintView.checkAnswerIndex != 1 && PrintView.checkAnswerIndex != 2;
    }

    public void stepBridge(List<String> bridgeData) {
        String moveStep = "";
        PrintView.retryCount++;
        for(int index = 0 ; index < bridgeData.size(); index++) {
            if(index != 0) printView.lineSkip();
            System.out.println(printView.MOVE_STEP);
            moveStep = inputView.readGameCommand();
            bridgeGame.move(inputMoveStepHandler.checkValidator(moveStep), bridgeData.get(index), index);
            if(PrintView.checkAnswerIndex == 1 || PrintView.checkAnswerIndex == 2) break;
            successBridge(index, bridgeData);
        }
    }

    private void successBridge(int index, List<String> bridgeData) {
        if(index == bridgeData.size()-1 && PrintView.checkAnswerIndex == 0) {
            PrintView.checkAnswerIndex = 2;
            printView.lineSkip();
            System.out.println(printView.THE_GAME_RESULT);
            bridgeGame.extractBracket(bridgeGame.upSide,bridgeGame.downSide);
            printView.lineSkip();
            bridgeGame.printFailOrSuccessCase();
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
}
