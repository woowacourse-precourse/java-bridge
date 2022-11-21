package view;

import model.BridgeGame;
import model.BridgeState;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMap(String upper,String lower) {
        System.out.println(upper);
        System.out.println(lower);
    }

    public void printResult(BridgeGame bridgeGame,String upper,String lower) {
        System.out.println(OutputMessage.GAME_RESULT.getOutputMsg());
        printMap(upper,lower);
        if(bridgeGame.getSuccess()) {
            System.out.println(OutputMessage.WIN_GAME.getOutputMsg());
            System.out.println(OutputMessage.TRY.getOutputMsg() + bridgeGame.getAttempts());
            return;
        }
        System.out.println(OutputMessage.LOSE_GAME.getOutputMsg());
        System.out.println(OutputMessage.TRY.getOutputMsg() + bridgeGame.getAttempts());
    }
}