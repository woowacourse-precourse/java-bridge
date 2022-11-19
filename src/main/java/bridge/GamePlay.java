package bridge;

import java.util.List;

public class GamePlay {

    InputView inputView = new InputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();

    public void run(){
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge); // 삭제
        String result = null;
        boolean restart = true;
        int gameCount = 0;
        while (restart) {
            gameCount++;
            for (int i = 0; i < bridgeSize; i++) {
                String moving = inputView.readMoving();
                result = bridgeGame.move(moving, bridge, i);
                outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge(), i);
                if (result.equals("X")){
                    restart = inputView.readGameCommand();
                    bridgeGame.retry();
                    break;
                }
                restart = false;
            }
        }
        outputView.printResult(result, gameCount, bridgeGame);
    }
}
