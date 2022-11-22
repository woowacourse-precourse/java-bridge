package bridge;

import java.util.List;

public class GameJudge {
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();


    private static List<String> mapAndOX;

    public static boolean retryJudgeMethod(String successFail) {
        if (successFail == "성공"){
            return false;
        }
        String retryOrNotInput = inputView.readGameCommand();
        if (retryOrNotInput == "Q"){
            return false;
        }
        return true;
    }
}
