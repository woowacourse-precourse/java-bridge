package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<String> userRoute = new ArrayList<>();

        boolean gameState = true;
        int count = 0;
        while (gameState) {
            count++;
            userRoute = new ArrayList<>();

            // TODO 원활한 개발을 위해 추가. 추후 삭제
            outputView.printMap(bridge, bridge);

            for (int i = 0; i < bridgeSize; i++) {
                String moving = inputView.readMoving();
                userRoute.add(moving);
                outputView.printMap(bridge, userRoute);

                // 사용자가 잘 못 된 길을 가면 실패
                if (!bridge.get(i).equals(moving)) {
                    if ("Q".equals(inputView.readGameCommand()))
                        gameState = false;
                    break;
                }

                // 마직막 까지 성공 했을 경우
                if (i == bridgeSize - 1) {
                    gameState = false;
                }
            }
        }
        outputView.printResult(bridge, userRoute, count);
    }
}
