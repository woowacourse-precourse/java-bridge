package bridge;


import java.util.List;

public class Application {
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    static GameJudge gameJudge = new GameJudge();
    private static int tryNumber = 0;
    private static boolean retryJudge;
    private static String successFail;



    public static void main(String[] args) {
        List<String> bridgeList = initalBridgeListGenerate();
        do{
            bridgeGame.resetMap();
            successFail = gameJudge.successFailMethod(bridgeList);
            retryJudge = gameJudge.retryJudgeMethod(successFail);
            tryNumber++;
        }while(retryJudge);
        outputView.printResult(tryNumber, successFail);
    }

    private static List<String> initalBridgeListGenerate(){
        int inputNumber = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
        return bridgeList;
    }


}


