package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리 길이를 입력해주세요.");
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean retry = true;
        while(retry) {
            boolean result = true;
            while (result) {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                String moving = inputView.readMoving();
                result = bridgeGame.move(moving);
            }
            retry = bridgeGame.retry();
        }
    }
}
