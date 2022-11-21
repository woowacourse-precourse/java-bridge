package view;

import model.BridgeGame;
import model.BridgeState;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap() {
        upperFix();
        lowerFix();
        System.out.println(BridgeState.upper);
        System.out.println(BridgeState.lower);
    }

    public void upperFix() {
        BridgeState.upper = BridgeState.upper.replace(OutputMessage.END.getOutputMsg(),OutputMessage.BAR.getOutputMsg());
        BridgeState.upper = BridgeState.upper.substring(0, BridgeState.upper.length()-1);
        BridgeState.upper += OutputMessage.END.getOutputMsg();
    }

    public void lowerFix() {
        BridgeState.lower = BridgeState.lower.replace(OutputMessage.END.getOutputMsg(),OutputMessage.BAR.getOutputMsg());
        BridgeState.lower = BridgeState.lower.substring(0, BridgeState.lower.length()-1);
        BridgeState.lower += OutputMessage.END.getOutputMsg();
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(OutputMessage.GAME_RESULT.getOutputMsg());
        printMap();
        if(bridgeGame.getSuccess()) {
            System.out.println(OutputMessage.WIN_GAME.getOutputMsg());
            System.out.println(OutputMessage.TRY.getOutputMsg() + bridgeGame.getAttempts());
            return;
        }
        System.out.println(OutputMessage.LOSE_GAME.getOutputMsg());
        System.out.println(OutputMessage.TRY.getOutputMsg() + bridgeGame.getAttempts());
    }
}