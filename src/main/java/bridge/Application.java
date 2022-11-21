package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    private static int tryNumber = 0;
    private static boolean retryJudge;

    private static List<String> mapAndOX;


    public static void main(String[] args) {
        int inputNumber = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
        do{
            retryJudge = keepGoingJudge(bridgeList);
            tryNumber++;
        }while(retryJudge)


        outputView.printResult(tryNumber, mapAndJudge.get(1));
    }

    private static boolean keepGoingJudge(List<String> bridgeList){
        for (int order = 0; order < bridgeList.size(); order++){
            mainGame(bridgeList.get(order), order);

            if (mapAndOX.get(1) == "X"){
                inputView.readGameCommand();

            }
        }
    }
private static void retryOrNotInput(String gameCommand){

        if(gameCommand == "R"){
            return
        }
}

    private static void mainGame(String bridgeAnswer, int order){
        String upDownUserInput = inputView.readMoving();
        mapAndOX = bridgeGame.move(bridgeAnswer, upDownUserInput, order);
        String map = mapAndOX.get(0);
        outputView.printMap(map);
        mapAndOX.get(1);
    }
}


