package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int attempt = 0;

        outputView.printStart();

        int size = 0;
        while (size == 0) {
            try {
                outputView.printInputBridgeSize();
                size = inputView.readBridgeSize();
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
                        outputView.printInputMoving();
                        moving = inputView.readMoving();
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                }

                userMoving.add(moving);

                // 다리 결과 출력
                outputView.printMap(bridge, userMoving);

                // 다리 상태 변경
                bridgeGame.changeStatus(bridge, userMoving);
            }

            String command = "";
            Status gameStatus = bridgeGame.getStatus();

            if (gameStatus == Status.FAIL) {
                while (command.equals("")) {
                    try {
                        outputView.printInputCommand();
                        command = inputView.readGameCommand();
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            }

            // 종료를 원하는 경우 최종 결과 출력
            if (!command.equals("R")) {
                outputView.printFinalGameResult();
                outputView.printResult(bridge, userMoving);
                outputView.printGameStatus(gameStatus);
                outputView.printAllAttempts(attempt);
                break;
            }
        }
    }
}
