package bridge.view;

import bridge.constants.Message;

public class OutputView {

    public void printStart() {
        System.out.println(Message.START_GAME.getValue());
        emptyLine();
    }

    public void printBridge(StringBuilder upBridge, StringBuilder downBridge) {
        System.out.println(upBridge);
        System.out.println(downBridge);
        emptyLine();
    }

    public void printFinalGame() {
        System.out.println(Message.RESULT_GAME.getValue());
    }

    public void printResult(boolean success, int cnt) {
        System.out.println(Message.SUCCESS_WHETHER.getValue() + printSuccessWhether(success));
        System.out.println(Message.TRY_COUNT.getValue() + cnt);
    }

    private String printSuccessWhether(boolean successGame) {
        if (successGame) {
            return Message.SUCCESS.getValue();
        }
        return Message.FAIL.getValue();
    }

    public void emptyLine() {
        System.out.println(Message.EMPTY.getValue());

    }


}
