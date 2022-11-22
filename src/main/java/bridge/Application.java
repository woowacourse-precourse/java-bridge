package bridge;

public class Application {

    final static String startExceptionMessage = "[ERROR]";
    static int length;
    static BridgeGame bridgeGame;
    static Status status;
    static String restart = null;
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
        length = inputView.readBridgeSize();
        outputView.printNewLine();
        bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()), length);
    }

    /**
     * 다음단계로 넘어가는 함수다.
     */
    private static void next() {
        outputView.printInputMoveMessage();
        String next = inputView.readMoving();
        status = bridgeGame.move(next);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getMove());
        outputView.printNewLine();
        if (status == Status.FAIL) {
            failStep();
        }
    }

    /**
     * 실패 시 입력을 받아 세임을 재시작 하거나 상태를 실패로 고정한다.
     */
    private static void failStep() {
        outputView.printRestartMessage();
        restart = inputView.readGameCommand();

        if (restart.equals("Q")) return;
        status = Status.HAS_NEXT;
        bridgeGame.retry();
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
