package view;

import domain.AllBridge;
import domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static String upper = OutputMessage.START.getOutputMsg();
    public static String lower = OutputMessage.START.getOutputMsg();

    public void addString(String str) {
        if(str.equals("U")) {
            upper += OutputMessage.CORRECT.getOutputMsg();
            lower += OutputMessage.JUMP_BAR.getOutputMsg();
            return;
        }
        lower += OutputMessage.CORRECT.getOutputMsg();
        upper += OutputMessage.JUMP_BAR.getOutputMsg();
    }
}