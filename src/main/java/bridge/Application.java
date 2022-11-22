package bridge;

import java.util.List;
public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    public static void main(String[] args) {
        outputView.startBridgeGame();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        playBridgeGame(bridge);
    }
    private static void playBridgeGame(List<String> bridge){
        int trial = 1;
        String success;

        while (true) {
            success = successFail(bridge);
            if (success == "성공")break;

            if(bridgeGame.retry()){
                trial++;
                continue;
            }
            break;
        }
        outputView.printResult(success, trial);
    }

    private static String successFail(List<String> bridge){
        if (bridgeGame.move(bridge)){
            return "성공";
        }
        return "실패";
    }
}
