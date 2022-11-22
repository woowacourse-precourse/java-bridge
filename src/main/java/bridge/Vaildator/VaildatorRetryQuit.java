package bridge.Vaildator;

import bridge.Constant;

public class VaildatorRetryQuit {

    private static String userInputRetryQuit;

    public VaildatorRetryQuit(String userInputRetryQuit) {
        this.userInputRetryQuit = userInputRetryQuit;
        vaildate();
    }

    private void vaildate() {
        vaildateRQ();

    }

    private void vaildateRQ() {
        if (!(userInputRetryQuit.equals(Constant.RETRY) || userInputRetryQuit.equals(Constant.QUIT))) {
            throw new IllegalArgumentException(Constant.ERROR + Constant.INPUT_WRONG_RETRY_SELECT);
        }

    }

    public static String getUserInputRetryQuit(){
        return userInputRetryQuit;
    }
}
