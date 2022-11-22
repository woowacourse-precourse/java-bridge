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
        gameStart();
        for(int i=0;i<bridge.size();i++){
            String upDown = inputView.readMoving();
            currentBridgeState(bridge,upDown,i);
            gameResult(bridge,i);
            i = selectGameReStart(bridge.size(),i);
        }
        System.out.println("총 시도한 횟수: "+ count);
    }

    private static int selectGameReStart(int bridgeSize,int index) {
        if(gameCommand.equals("R"))
            return(gameReStart());
        if(gameCommand.equals("Q")){
            outputView.printFailResult(bridgeGame.getCurrentUpState(),bridgeGame.getCurrentDownState());
            return bridgeSize-1;
        }
        return index;
    }

    private static void gameStart() {
        System.out.println(printGameStart);
        gameInit();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private static int gameReStart() {
        bridgeGame.retry(gameCommand);
        count++;
        gameCommand = "";
        return -1;
    }

    private static void gameResult(List<String> bridge, int i) {
        if(bridgeGame.success(bridge))
            outputView.printSuccessResult(bridgeGame.getCurrentUpState(),bridgeGame.getCurrentDownState());
        if(bridgeGame.fail(i))
            gameCommand = inputView.readGameCommand();
    }

    public static void gameInit(){
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame();
        bridge = new ArrayList<>();
    }

    public static void currentBridgeState(List<String> bridge,String upDown,int index){
        bridgeGame.playing(bridge,upDown,index);
        outputView.printMap(bridgeGame.getCurrentUpState(),bridgeGame.getCurrentDownState());
    }


}
