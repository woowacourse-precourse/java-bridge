package bridge;


import bridge.InputControl.BridgeInputControl;
import bridge.InputControl.UserInput;
import java.util.List;

public class Application {
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();

    static UserInput userInput;
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
        BridgeInputControl bridgeInputControl = new BridgeInputControl();
        bridgeInputControl.setBridgeSize();
        int inputNumber = userInput.userInputBridgeSize;
        bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
    }


    private static void mainBridgeGame(){
        do{
            bridgeGame.resetMap();
            successFail = mainGame(bridgeList);
            retryJudge = bridgeGame.retry(successFail);
            tryNumber++;
        }while(retryJudge);
    }

    private static String mainGame(List<String> bridgeList) {
        for (int order = Constant.ZERO; order < bridgeList.size(); order++) {
            StringBuilder map = bridgeGame.move(bridgeList.get(order), order);
            outputView.printMap(map.toString()); // 이거 수정해야함
            if (judgementFail()) {
                return Constant.FAIL;
            }
        }
        return Constant.SUCCESS;
    }

    private static boolean judgementFail() {
        if (bridgeGame.getOX().equals(Constant.WRONG)) {
            return true;
        }
        return false;
    }

}


