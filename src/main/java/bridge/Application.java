package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int attempt = 0;

        OutputView.printStart();

        int size = 0;
        while (size == 0) {
            try {
                OutputView.printInputBridgeSize();
                size = InputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(size);

        while (true) {
            attempt++;
            BridgeGame bridgeGame = new BridgeGame();
            List<String> userMoving = new ArrayList<>();

            while (bridgeGame.getStatus().isProceeding()) {
                String moving = "";
                while (moving.equals("")) {
                    try {
                        OutputView.printInputMoving();
                        moving = InputView.readMoving();
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                }

                userMoving.add(moving);

                // 다리 결과 출력
                OutputView.printMap(bridge, userMoving);

                // 다리 상태 변경
                bridgeGame.changeStatus(bridge, userMoving);
            }

            String command = "";
            Status gameStatus = bridgeGame.getStatus();

            if (gameStatus == Status.FAIL) {
                while (command.equals("")) {
                    try {
                        OutputView.printInputCommand();
                        command = InputView.readGameCommand();
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            }

            // 종료를 원하는 경우 최종 결과 출력
            if (!command.equals("R")) {
                OutputView.printFinalGameResult();
                OutputView.printResult(bridge, userMoving);
                OutputView.printGameStatus(gameStatus);
                OutputView.printAllAttempts(attempt);
                break;
            }
        }
    }
}
