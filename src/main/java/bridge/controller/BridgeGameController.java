package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.InputView.Command;
import bridge.view.OutputView;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame manager = BridgeGame.getInstance();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private static enum Message {
        GAME_START("다리 건너기 게임을 시작합니다."),
        REQUEST_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
        REQUEST_MOVING_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        REQUEST_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static void run() {
        startBridgeGame();
        playGameUntilFinish();
        outputView.printResult(manager.getMovingStatus(), manager.isGameSuccess(), manager.getAttemptsCount());
    }

    private static void startBridgeGame() {
        outputView.printMessage(Message.GAME_START.getMessage(), "\n");
        int length = getBridgeLength();
        manager.setBridgeStatus(bridgeMaker.makeBridge(length));
    }

    private static void playGameUntilFinish() {
        while (!manager.isGameSuccess()) {
            String movingCommand = getMoving();
            boolean movingSuccess = manager.move(movingCommand);
            outputView.printMap(manager.getMovingStatus(), movingSuccess); // 이동 결과 출력
            if (!movingSuccess && !doRetry()) {
                break;
            }
        }
    }

    private static boolean doRetry() {
        String command = getGameCommand();
        if (command.equals(Command.RETRY.getCommand())) {
            manager.retry();
            return true;
        }
        return false;
    }

    private static int getBridgeLength() {
        while (true) {
            try {
                return inputView.readBridgeSize(Message.REQUEST_BRIDGE_LENGTH.getMessage(), "\n");
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private static String getMoving() {
        while (true) {
            try {
                return inputView.readMoving(Message.REQUEST_MOVING_COMMAND.getMessage(), "\n");
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private static String getGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand(Message.REQUEST_GAME_COMMAND.getMessage(), "\n");
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}
