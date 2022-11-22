package bridge;

import java.util.List;

public class GameJudge {
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();


    private static List<String> mapAndOX;
    public static boolean successFailMethod(List<String> bridgeList){
        for (int order = 0; order < bridgeList.size(); order++){
            mapAndOX = bridgeGame.move(bridgeList.get(order), order);
            String map = mapAndOX.get(0);
            outputView.printMap(map);
            if (mapAndOX.get(1) == "X"){
                return false;
            }
        }
        return true;
    }

    public static boolean retryJudgeMethod(boolean successFail) {
        if (successFail == true){
            return false;
        }
        String retryOrNotInput = inputView.readGameCommand();
        if (retryOrNotInput == "Q"){
            return false;
        }
        return true;
    }
}
