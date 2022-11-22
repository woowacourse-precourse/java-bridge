package bridge;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static final String MESSAGE_START = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_INPUT_LENGTH_OF_BRIDGE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_INPUT_MOVE_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(MESSAGE_START);
        bridgeGame.setBridge(readBridgeSize());
        do {
            bridgeGame.reset();
            playGame();
        } while (isFinishProgram());

        outputView.printResult(bridgeGame.getGameStatus(), bridgeGame.printMap());
    }

    private static void playGame() {
        do {
            bridgeGame.move(readMoveCommand());
            outputView.printMap(bridgeGame.printMap());
        } while (!bridgeGame.isFinish());
    }

    private static boolean isFinishProgram() {
        if (bridgeGame.isResult()) {
            return false;
        }
        return bridgeGame.retry(readRetryCommand());
    }

    private static String readRetryCommand() {
        System.out.println(MESSAGE_INPUT_RETRY_COMMAND);
        return inputView.readGameCommand();
    }

    private static String readMoveCommand() {
        System.out.println(MESSAGE_INPUT_MOVE_COMMAND);
        return inputView.readMoving();
    }

    private static int readBridgeSize() {
        System.out.println(MESSAGE_INPUT_LENGTH_OF_BRIDGE);
        return inputView.readBridgeSize();
    }
}