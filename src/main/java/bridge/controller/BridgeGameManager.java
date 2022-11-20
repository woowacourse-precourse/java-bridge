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
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setTryNumber();

        OutputView.printStart();

        int bridgeSize = inputBridgeSizeRepeat();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> targetBridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(targetBridge);

        int step = 0;
        while (step < targetBridge.size()) {
            // 이동 할 칸 입력받음
            String upDownInput = inputUpDownRepeat();

            System.out.println(upDownInput);

            // 이동 시키키기
            bridgeGame.move(upDownInput);

            // 현재상태 출력
            List<String> preStatus = bridgeGame.getPreStatus();
            OutputView.printMap(targetBridge, preStatus);

            // 만약 새로 간 칸이 잘 못된 칸이라면
            if (!targetBridge.get(step).equals(upDownInput)) {

                String retryAnswer = inputRetryRepeat();

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
        OutputView.printMap(targetBridge, bridgeGame.getPreStatus());
        OutputView.printSuccessFailure(targetBridge, bridgeGame.getPreStatus());
        OutputView.printTryNumber(bridgeGame.getTryNumber());

        bridgeGame.resetTryNumber();
    }

    private int inputBridgeSizeRepeat() {
        int bridgeSize;
        while (true) {
            try {
                bridgeSize = InputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        return bridgeSize;
    }

    private String inputUpDownRepeat() {
        String upDownInput;
        while (true) {
            try {
                upDownInput = InputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 이동할 칸은 U 또는 D 여야 합니다.");
            }
        }
        return upDownInput;
    }

    private String inputRetryRepeat() {
        String retryAnswer;
        while (true) {
            try {
                retryAnswer = InputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 재시작/종료는 Q 또는 R이어야 합니다.");
            }
        }
        return retryAnswer;
    }
}
