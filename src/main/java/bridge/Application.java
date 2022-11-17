package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            // 다리 길이 입력받는 기능
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            int size = inputView.readBridgeSize();
            List<String> bridges = bridgeMaker.makeBridge(size);

            // 플레이어가 이동할 칸을 입력받는 기능
            BridgeGame bridgeGame = new BridgeGame();
            String moveCommand = inputView.readMoving();
            bridgeGame.move(moveCommand);

            // 재시작 / 종료 명령을 입력받는 기능
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);

            outputView.printGameStart();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
