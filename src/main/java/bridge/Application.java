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
            outputView.printMap(bridge, bridge);
            for (int i = 0; i < bridgeSize; i++) {
                String moving = inputView.readMoving();
                userRoute.add(moving);
                // 사용자가 가려고 하는 곳이 막힌 곳이면 실패 : 게임 반복 여부 확인
                if (!bridgeGame.move(bridge.get(i), moving)) {
                    outputView.printMap(bridge, userRoute);
                    // 종료 여부 확인
                    String gameCommand = inputView.readGameCommand();
                    // 종료
                    if (gameCommand.equals("Q")) {
                        gameState = false;
                    }
                    break;
                }

                // 사용자가 가려고 한 곳이 올바른 길이면
                if (bridgeGame.move(bridge.get(i), moving)) {
                    outputView.printMap(bridge, userRoute);
                }
                // 끝까지 성공 했을 경우
                if (i == bridgeSize - 1) {
                    outputView.printMap(bridge, userRoute);
                    gameState = false;
                }
            }
        }
        // TODO 최종 게임 결과 출력
        outputView.printResult("실패", count);
    }
}
