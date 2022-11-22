package bridge;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();

        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            System.out.println("다리의 길이를 입력해주세요.");

            int size = inputView.readBridgeSize();
            if(size == 0)
                return;
            List<String> answerBridge = bridgeMaker.makeBridge(size);
            bridgeGame.move(answerBridge);

        }catch (IOException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
