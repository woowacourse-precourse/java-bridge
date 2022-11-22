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
        for (int i=0; i<size; i++) {
            // 이동할 칸 입력
            String moving = inputView.readMoving();

            boolean resultMove = bridgeGame.move(bridge, moving, i);
            System.out.println(resultMove);
        }
    }
}
