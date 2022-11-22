package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사이즈 입력
        System.out.println("다리 건너기 게임을 시작합니다./n");
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        // 다리 생성
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);

        // 이동 확인
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        int i = 0;
        while (true) {
            String moving = inputView.readMoving();
            boolean result = bridgeGame.move(bridge, moving, i);

            // 틀렸을 때, 종료
            if (result == false) {
                boolean retry = bridgeGame.retry();
                if (retry == false) {
                    break;
                }
                i = 0;
            }

            // 성공
            if (i == size) {
                break;
            }
            i++;
        }
    }
}
