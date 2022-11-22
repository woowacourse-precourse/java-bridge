package bridge;

import java.util.List;

public class GameJudge {
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();


    private static List<String> mapAndOX;
    public static String successFailMethod(List<String> bridgeList){
        for (int order = 0; order < bridgeList.size(); order++){
            mapAndOX = bridgeGame.move(bridgeList.get(order), order);
            String map = mapAndOX.get(0);
            outputView.printMap(map);
            if (mapAndOX.get(1) == "X"){
                return "실패";
            }
        }
        return "성공";
    }

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
