package bridge.View;

import static bridge.View.ViewConstants.*;

public class StaticView {

    public void gameStartMsg() {
        System.out.println(GAME_START.getMessage());
    }

    public void askSizeMsg() {
        System.out.println(ASK_SIZE.getMessage());
    }

    public void askMoveMsg() {
        System.out.println(ASK_MOVE.getMessage());
    }

    public void askRetryMsg() {
        System.out.println(ASK_RETRY.getMessage());
    }

    public void gameResultMsg() {
        System.out.println(FINAL_RESULT.getMessage());
    }

    public void successOrFailMsg() {
        System.out.println(SUCCESS_OR_FAIL.getMessage());
    }

    public void tryNumMsg() {
        System.out.println(TRY_NUM.getMessage());
    }
}
