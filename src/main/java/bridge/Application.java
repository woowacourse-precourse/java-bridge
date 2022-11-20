package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static String printGameStart = "다리 건너기 게임을 시작합니다.";
    static BridgeNumberGenerator bridgeNumberGenerator;
    static List<String> bridge = new ArrayList<>();
    static String moveBridge = "";
    public static void main(String[] args) {
        System.out.println(printGameStart);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        for(int i=0;i<bridge.size();i++){
            outputView.printMap(i,bridgeGame.move(bridge,i,inputView.readMoving()));

        }



    }
}
