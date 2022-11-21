package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static String printGameStart = "다리 건너기 게임을 시작합니다.";
    static BridgeNumberGenerator bridgeNumberGenerator;
    static InputView inputView;
    static OutputView outputView;
    static BridgeMaker bridgeMaker;
    static BridgeGame bridgeGame;
    static List<String> bridge;
    static String gameCommand = "";
    static int count = 1;
    public static void main(String[] args) {
        System.out.println(printGameStart);
        gameInit();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        for(int i=0;i<bridge.size();i++){
            String upDown = inputView.readMoving();
            bridgeGame.playing(bridge,upDown,i);
            outputView.printMap(bridgeGame.getCurrentUpState(),bridgeGame.getCurrentDownState());

            if(bridgeGame.success(bridge))
                outputView.printSuccessResult(bridgeGame.getCurrentUpState(),bridgeGame.getCurrentDownState());

            if(bridgeGame.fail(i))
                gameCommand = inputView.readGameCommand();

            if(gameCommand.equals("R")){
                bridgeGame.retry(gameCommand);
                i=-1;
                count++;
                gameCommand = "";
            }

            if(gameCommand.equals("Q")){
                outputView.printFailResult(bridgeGame.getCurrentUpState(),bridgeGame.getCurrentDownState());
                break;
            }

        }
        System.out.println("총 시도한 횟수: "+ count);
    }
    public static void gameInit(){
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame();
        bridge = new ArrayList<>();
    }


}
