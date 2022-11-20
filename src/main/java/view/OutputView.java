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

    public void printMap() {
        upperFix();
        lowerFix();
        System.out.println(upper);
        System.out.println(lower);
    }

    public void addString(String str) {
        if(str.equals("U")) {
            upper += OutputMessage.CORRECT.getOutputMsg();
            lower += OutputMessage.JUMP_BAR.getOutputMsg();
            return;
        }
        lower += OutputMessage.CORRECT.getOutputMsg();
        upper += OutputMessage.JUMP_BAR.getOutputMsg();
    }

    public void addXString(String str) {
        if(str.equals("U")) {
            upper += OutputMessage.JUMP_BAR.getOutputMsg();
            lower += OutputMessage.WRONG.getOutputMsg();
            return;
        }
        lower += OutputMessage.JUMP_BAR.getOutputMsg();
        upper += OutputMessage.WRONG.getOutputMsg();
    }

    public void upperFix() {
        upper = upper.replace(OutputMessage.END.getOutputMsg(),OutputMessage.BAR.getOutputMsg());
        upper = upper.substring(0,upper.length()-1);
        upper += OutputMessage.END.getOutputMsg();
    }

    public void lowerFix() {
        lower = lower.replace(OutputMessage.END.getOutputMsg(),OutputMessage.BAR.getOutputMsg());
        lower = lower.substring(0,lower.length()-1);
        lower += OutputMessage.END.getOutputMsg();
    }
}