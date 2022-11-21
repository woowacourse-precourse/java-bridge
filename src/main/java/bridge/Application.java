package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    private static int tryNumber = 0;
    private static boolean retryJudge;
    private static boolean successFail;

    private static List<String> mapAndOX;


    public static void main(String[] args) {
        int inputNumber = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
        do{
            bridgeGame.resetMap();
            successFail = successFailMethod(bridgeList);
            retryJudge = retryJudgeMethod(successFail);
            tryNumber++;
        }while(retryJudge);
        outputView.printResult(tryNumber, successFail);
    }

    private static boolean retryJudgeMethod(boolean successFail) {
        if (successFail == true){
            return false;
        }
        String retryOrNotInput = inputView.readGameCommand();
        if (retryOrNotInput == "Q"){
            return false;
        }
        return true;
    }

    private static boolean successFailMethod(List<String> bridgeList){
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

}


