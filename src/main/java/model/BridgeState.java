package model;

import view.OutputMessage;

public class BridgeState {
    public static String upper = OutputMessage.START.getOutputMsg();
    public static String lower = OutputMessage.START.getOutputMsg();
    public static void addString(String str) {
        if(str.equals("U")) {
            upper += OutputMessage.CORRECT.getOutputMsg();
            lower += OutputMessage.JUMP_BAR.getOutputMsg();
            return;
        }
        lower += OutputMessage.CORRECT.getOutputMsg();
        upper += OutputMessage.JUMP_BAR.getOutputMsg();
    }

    public static void addXString(String str) {
        if(str.equals("U")) {
            upper += OutputMessage.JUMP_BAR.getOutputMsg();
            lower += OutputMessage.WRONG.getOutputMsg();
            return;
        }
        lower += OutputMessage.JUMP_BAR.getOutputMsg();
        upper += OutputMessage.WRONG.getOutputMsg();
    }
}
