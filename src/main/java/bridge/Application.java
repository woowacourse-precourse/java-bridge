package bridge;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static final boolean START = true;
    public static void main(String[] args) {
        List<String> bridge;
        int bridgeSize;
        boolean state = START;

        while(state){ // retry
            //사이즈 입력
            bridgeSize = inputView.readBridgeSize();
            // bridge를 만듦
            bridge = bridgeMaker.makeBridge(bridgeSize);
            // bridge를 이용한 게임 생성
            BridgeGame bridgeGame = new BridgeGame(bridge);
            // bridge move
            boolean ingameState = true;
            while(ingameState){//move
                String direction = inputView.readMoving();
                ingameState = bridgeGame.move(direction);
//                outputView.printMap();
            }
//            outputView.printResult();

            state = bridgeGame.retry();


        }


    }
}
