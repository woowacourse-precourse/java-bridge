package bridge.view;

import bridge.domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    OrderView orderView = new OrderView();
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeData) {
        while(orderView.checkRestart){
            stepBridge(bridgeData);
            if(!exitLoop()) {break;}
        }
    }

    private boolean exitLoop() {
        if(orderView.checkAnswerIndex == 1 || orderView.checkAnswerIndex == 2) {
            return false;
        }
        return true;
    }

    public void stepBridge(List<String> bridgeData) {
        orderView.retryCount++;
        for(int index = 0 ; index < bridgeData.size(); index++) {
            if(index != 0) orderView.lineSkip();
            System.out.println(orderView.MOVE_STEP);
            bridgeGame.move(inputView.readMoving(), bridgeData.get(index), index);
            if(orderView.checkAnswerIndex == 1 || orderView.checkAnswerIndex == 2) break;
            successBridge(index, bridgeData);
        }
    }

    private void successBridge(int index, List<String> bridgeData) {
        if(index == bridgeData.size()-1 && orderView.checkAnswerIndex == 0) {
            orderView.checkAnswerIndex = 2;
            orderView.lineSkip();
            System.out.println(orderView.THE_GAME_RESULT);
            bridgeGame.extractBracket(bridgeGame.upSide,bridgeGame.downSide);
            orderView.lineSkip();
            bridgeGame.printFailOrSuccessCase();
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
}
