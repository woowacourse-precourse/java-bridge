package bridge;

import java.util.List;

public class Application {
    private static int idx = 0;
    private static int gameCnt = 1;
    private static int CURRENT_LOCATION;
    private static int BRIDGE_LENGTH;
    private static final int INITIALIZE = 0;
    static BridgeGame bridgeGame = new BridgeGame();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(generator);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Message.start();
            BRIDGE_LENGTH = inputView.readBridgeSize();
            CURRENT_LOCATION = BRIDGE_LENGTH;
            List<String> bridge = bridgeMaker.makeBridge(BRIDGE_LENGTH);
            while (CURRENT_LOCATION-- > 0) {
                String nextMove = inputView.readMoving();
                boolean successOrFail = bridgeGame.move(idx++, bridge, nextMove);
                outputView.printMap();
                outputView.printResult(gameCnt, CURRENT_LOCATION, successOrFail);
                canYouRetry(successOrFail);
            }
        }catch(Exception e) { }
    }

    public static void canYouRetry(boolean successOrFail) {
        if(!successOrFail){
            CURRENT_LOCATION = inputView.readGameCommand(gameCnt, BRIDGE_LENGTH);
            idx = INITIALIZE;
            bridgeGame.bridgeInitialize();
            bridgeGame.getSuccessOrFail();;
            if(CURRENT_LOCATION != 0) gameCnt++;
        }
    }
}