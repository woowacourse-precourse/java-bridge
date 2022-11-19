package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameManager {
    public void run() {
        int bridgeSize;

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start();

        OutputView.printStart();

        while (true) {
            try {
                bridgeSize = InputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }


        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> targetBridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(targetBridge);

        int step = 0;
        while (step < targetBridge.size()) {
            // 이동 할 칸 입력받음
            String upDown = InputView.readMoving();
            System.out.println(upDown);

            // 이동 시키키기
            bridgeGame.move(upDown);

            // 현재상태 출력
            List<String> preStatus = bridgeGame.getPreStatus();
            OutputView.printMap(targetBridge, preStatus);

            // 만약 새로 간 칸이 잘 못된 칸이라면
            if (!targetBridge.get(step).equals(upDown)) {
                String retryAnswer = InputView.readGameCommand();

                if (retryAnswer.equals("R")) {
                    bridgeGame.back(step);
                    bridgeGame.retry();
                    continue;
                }

                if (retryAnswer.equals("Q")) {
                    break;
                }
            }
            step++;
        }

        OutputView.printResult();
        // 여기다가 다리 상태 출력
        OutputView.printMap(targetBridge, bridgeGame.getPreStatus());
        OutputView.printSuccessFailure(targetBridge, bridgeGame.getPreStatus());
        OutputView.printTryNumber(bridgeGame.getTryNumber());

        bridgeGame.end();
    }
}
