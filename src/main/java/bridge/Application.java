package bridge;

import bridge.BridgeGame.CorrectWrong;
import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    private static int tryNumber = 0;
    private static boolean retryOrNot = true;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int inputNumber = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
        //최초 1회 구현

        while(retryOrNot){
            bridgeGame.resetMap();
            retryOrNot = false;
            for (int order = 0; order < bridgeList.size(); order++){
                String upDownUserInput = inputView.readMoving();
                String map = bridgeGame.move(bridgeList, upDownUserInput, order);
                outputView.printMap(map);

                if (map.contains("X")){
                    if ( inputView.readGameCommand().equals("R")){
                        retryOrNot = true;
                        break;
                    }
                    break;
                }
            }

            tryNumber++;
        }



        outputView.printResult(tryNumber, );



    }
}
