package bridge.Vaildator;

public class VaildatorRetryQuit {

    public static String userInputRetryQuit;
    public VaildatorRetryQuit(String userInputRetryQuit) {
        this.userInputRetryQuit = userInputRetryQuit;
        vaildate();
    }

    private void vaildate() {
        vaildateRQ();

    }

    private void vaildateRQ() {
        if (!(userInputRetryQuit.equals("R")|| userInputRetryQuit.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해주세요.");
        }

    }
}
