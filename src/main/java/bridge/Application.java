package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static InputView input=new InputView();
    private  static  OutputView output=new OutputView();
    private static BridgeMaker bridgeMaker=new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame;
    static List<String> bridge=new ArrayList<>();
    public static void main(String[] args) {
        bridge = bridgeMaker.makeBridge(input.readBridgeSize());
        BridgeGame bridgeGame=new BridgeGame(bridge);
        bridgeGame.makeMap();
        while(bridgeGame.end()){
            bridgeGame.move(input.readMoving());
            output.printMap(bridgeGame.getMap());
           if(!continueGame())//게임 종료 조건
               break;
        }
        output.printResult(bridgeGame);
    }

    private static boolean continueGame() {
        if(bridgeGame.incorrect()){//틀렸으면
            String str=input.readGameCommand();
            if (str=="R") //R눌렀을때
                bridgeGame.retry();
            if(str=="Q")//Q눌렀을때
                return false;//게임이 종료되도록 false 반환
        }
        return true;
    }
}
