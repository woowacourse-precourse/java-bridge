package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        System.out.println("다리 건너기 게임을 시작합니다");

        System.out.println("다리의 길이를 입력해주세요");

        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        int gameCount = 0;

        while (true) {
            gameCount++;
            boolean matchingFlag = true;
            Bridge userBridge = new Bridge(new ArrayList<>(), new ArrayList<>());

            for (String s : bridge) {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

                String nextStep = inputView.readMoving();

                if (!nextStep.equals(s)) {
                    matchingFlag = false;
                }

                bridgeGame.move(userBridge, nextStep, matchingFlag);

                outputView.printMap(userBridge);

                if (!matchingFlag) {
                    break;
                }

            }

            if (matchingFlag) {
                outputView.printResult(userBridge, gameCount, matchingFlag);
                break;
            }

            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String retryCommand = inputView.readGameCommand();

            if (bridgeGame.retry(retryCommand)) {
                outputView.printResult(userBridge, gameCount, matchingFlag);
                break;
            }
        }
    }
}
