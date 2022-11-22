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

    private static List<String> bridgeList;



    public static void main(String[] args) {
        initalBridgeListGenerate();
        mainBridgeGame();
        outputView.printResult(tryNumber, successFail);
    }

    private static void initalBridgeListGenerate(){
        int inputNumber = inputView.readBridgeSize();
        bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
    }

    private static void mainBridgeGame(){
        do{
            bridgeGame.resetMap();
            successFail = bridgeGame.mainGame(bridgeList);
            retryJudge = bridgeGame.retryJudgeMethod(successFail);
            tryNumber++;
        }while(retryJudge);
    }

}


