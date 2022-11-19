package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();

        System.out.println("다리 건너기 게임을 시작합니다");

        System.out.println("다리의 길이를 입력해주세요");

        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        Bridge userBridge = new Bridge(new ArrayList<>(), new ArrayList<>());

        for (String s : bridge) {
            String nextStep = inputView.readMoving();

            boolean matchingFlag = true;

            if (!nextStep.equals(s)) {
                matchingFlag = false;
            }

            bridgeGame.move(userBridge, nextStep, matchingFlag);

            System.out.println(userBridge);
        }
    }
}
