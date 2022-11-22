package bridge;

import java.util.Objects;

public class Application {

    static BridgeGame bridgeGame;
    static Status status;
    static InputView inputView;
    static OutputView outputView;

    /**
     * 게임을 진행하는 데 필요한 필드를 초기화하는 함수다.
     */
    private static void init() {
        inputView = new InputView();
        outputView = new OutputView();
        outputView.printGameStartMessage();
        outputView.printNewLine();
        outputView.printInputBridgeSizeMessage();
        Integer length = readBridgeSizeNotException();
        outputView.printNewLine();
        bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()), length);
    }

    /**
     * @return 입력 예외가 발생하지 않은 다리 길이
     * 예외가 발생하지 않을 때까지 다리 길이를 입력받는 함수
     */
    private static int readBridgeSizeNotException() {
        Integer length = null;
        do {
            try {
                length = inputView.readBridgeSize();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException);
            }
        } while (Objects.isNull(length));
        return length;
    }

    /**
     * 다음단계로 넘어가는 함수다.
     */
    private static void next() {
        outputView.printInputMoveMessage();
        String next = readMovingNotException();
        status = bridgeGame.move(next);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getMove());
        outputView.printNewLine();
        if (status == Status.FAIL) {
            failStep();
        }
    }

    /**
     * @return 입력 예외가 발생하지 않은 다음 위치
     * 예외가 발생하지 않을 때까지 다음 위치를 입력받는 함수
     */
    private static String readMovingNotException() {
        String next = null;
        do {
            try {
                next = inputView.readMoving();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException);
            }
        } while (Objects.isNull(next));
        return next;
    }

    /**
     * 실패 시 입력을 받아 게임을 재시작 하거나 상태를 실패로 고정한다.
     */
    private static void failStep() {
        outputView.printRestartMessage();
        String restart = readExitCommandNotException();
        if (restart.equals("Q")) return;
        status = Status.HAS_NEXT;
        bridgeGame.retry();
    }

    /**
     * @return 입력 예외가 발생하지 않은 게임 종료 또는 재시작 커맨드
     * 예외가 발생하지 않을 때까지 게임 종료 또는 재시작 커맨드를 입력받는 함수
     */
    private static String readExitCommandNotException() {
        String restart = null;
        do {
            try {
                restart = inputView.readGameCommand();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException);
            }
        } while (Objects.isNull(restart));
        return restart;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();
        do {
            next();
        } while (status == Status.HAS_NEXT);
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getMove(), bridgeGame.getCount());
    }
}
